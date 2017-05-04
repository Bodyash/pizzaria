package com.bodyash.pizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
	@RequestMapping
	public ModelAndView cart(){
		ModelAndView mav = new ModelAndView("cart");
		mav.addObject("cart", null);
		return mav;
	}
}
