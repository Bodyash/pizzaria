package com.bodyash.pizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bodyash.pizzaria.bean.Category;
import com.bodyash.pizzaria.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/")
    public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("pizzas", productService.findProductByCategory(Category.PIZZA));
		return mav;
    }
	
	@RequestMapping(value = "/drinks")
    public ModelAndView drinks() {
		ModelAndView mav = new ModelAndView("drinks");
		mav.addObject("drinks", productService.findProductByCategory(Category.DRINK));
		return mav;
    }
	
	@RequestMapping(value = "/desserts")
    public ModelAndView desserts() {
		ModelAndView mav = new ModelAndView("desserts");
		mav.addObject("desserts", productService.findProductByCategory(Category.DESSERT));
		return mav;
    }
	
	@RequestMapping(value = "/contacts")
    public ModelAndView contacts() {
		return new ModelAndView("info/contacts");
    }
	
	@RequestMapping(value = "/about")
    public ModelAndView about() {
		return new ModelAndView("info/about");
    }
	
	

}
