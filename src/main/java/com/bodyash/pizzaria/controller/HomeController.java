package com.bodyash.pizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
    public ModelAndView home() {
		System.out.println("SENDING USER TO MAIN PAGE");
		return new ModelAndView("home");
    }
	
	@RequestMapping(value = "/drinks")
    public ModelAndView drinks() {
		return new ModelAndView("drinks");
    }

}
