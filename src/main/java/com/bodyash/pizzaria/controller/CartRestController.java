package com.bodyash.pizzaria.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bodyash.pizzaria.bean.Cart;
import com.bodyash.pizzaria.bean.CartItem;
import com.bodyash.pizzaria.bean.Order;
import com.bodyash.pizzaria.bean.Product;
import com.bodyash.pizzaria.service.CartService;
import com.bodyash.pizzaria.service.OrderService;
import com.bodyash.pizzaria.service.ProductService;

@Controller
@RequestMapping(value="rest/cart")
public class CartRestController {

	@Autowired
	@Qualifier(value="CartService")
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Cart create(@RequestBody Cart cart){
		return cartService.create(cart);
	}
	
	@RequestMapping(value="/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId){
		Cart cart = cartService.read(cartId);
		if(cart!=null){
			return cart;
		}
		return null;
	}
	
	@RequestMapping(value="/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void update(String cartId, @RequestBody Cart cart){
		cartService.update(cartId, cart);
	}
	
	@RequestMapping(value="/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value="cartId") String cartId){
		cartService.delete(cartId);
	}
	
	@RequestMapping(value="/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value="productId") int productId, HttpServletRequest request){
		String sessionId = request.getSession().getId();
		Cart cart = cartService.read(sessionId);
		
		if(cart == null){
			cartService.create(new Cart(sessionId));
			cart = cartService.read(sessionId);
		}
		
		Product product = productService.findProductById(productId);
		if(product == null) {
			throw new IllegalArgumentException("Product not Found");
		}
		
		cart.addCartItem(new CartItem(product));
		cartService.update(sessionId, cart);
		
	}
	
	@RequestMapping(value="/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable("productId") int productId, HttpServletRequest request){
		
		String sessionId = request.getSession().getId();
		Cart cart = cartService.read(sessionId);
		if(cart == null){
			cart = cartService.create(new Cart(sessionId));
		}
		
		Product product = productService.findProductById(productId);
		if(product == null){
			throw new IllegalArgumentException("Product not Found");
		}
		
		cart.removeCartItem(new CartItem(product));
		cartService.update(sessionId, cart);
	}
	
/*	@RequestMapping(value="/checkout", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void checkout(HttpServletRequest request){
		String sessionId = request.getSession(true).getId();
		Cart cart = cartService.read(sessionId);
		if (cart != null){
			Order order = new Order();
			order = orderService.setOrderCart(cart, order);
		}else{
			//DONT FORGET TO DO SOMETHING WITH IT!
		}
	} */
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Illegal request, please verify your payload")
	public void handleClientErrors(Exception ex) {
		ex.printStackTrace();
	}
	 
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal Server Error")
	public void handleServletErrors(Exception ex){
		ex.printStackTrace();
	}
	
	
}
