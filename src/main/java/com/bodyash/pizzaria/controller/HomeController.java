package com.bodyash.pizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
    public ModelAndView home() {
		return new ModelAndView("home");
    }
	
	@RequestMapping(value = "/drinks")
    public ModelAndView drinks() {
		return new ModelAndView("drinks");
    }
	
	@RequestMapping(value = "/desserts")
    public ModelAndView desserts() {
		return new ModelAndView("desserts");
    }

}
