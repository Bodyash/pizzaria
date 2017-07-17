package com.bodyash.pizzaria.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bodyash.pizzaria.bean.Cart;
import com.bodyash.pizzaria.bean.Order;
import com.bodyash.pizzaria.bean.State;
import com.bodyash.pizzaria.service.CartService;
import com.bodyash.pizzaria.service.OrderService;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
	
	@Autowired
	@Qualifier(value="CartService")
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping
	public String get(HttpServletRequest request){
		return "redirect:/cart/"+request.getSession(true).getId();
	}
	
	@RequestMapping(value="/{cartId}", method = RequestMethod.GET)
	public String getCart(@PathVariable("cartId") String cartId, Model model, HttpServletRequest request){
		//If it is not your cart - redirect to your cart!
		if (request.getSession().getId().equals(cartId)){
			model.addAttribute("cartId", cartId);
			return "cart";
		}else{
			return "redirect:/cart/"+request.getSession(true).getId();
		}
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(HttpServletRequest request, ModelMap model){
		if(cartService.read(request.getSession(true).getId()) == null){
			model.addAttribute("emptycart", true);
		}else{
			model.addAttribute("order", new Order());
		}
		model.addAttribute("cartId", request.getSession(true).getId());
		return "checkout";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout(HttpServletRequest request, ModelMap model, @Valid Order order, BindingResult result){
		//set state as fresh order
		order.setState(State.ORDERED);
		//Serialize Cart to byte array
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutput out = new ObjectOutputStream(bos)){
				Cart cart = cartService.read(request.getSession(true).getId());
			  out.writeObject(cart);
			  out.flush();
			  byte[] cartBytes = bos.toByteArray();
			  order.setCart(cartBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		orderService.save(order);
		cartService.delete(request.getSession(true).getId());
		
		return "redirect:/cart";
	}
	
}
