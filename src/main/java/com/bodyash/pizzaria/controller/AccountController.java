package com.bodyash.pizzaria.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bodyash.pizzaria.bean.UserAccount;
import com.bodyash.pizzaria.service.AccountService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    AccountService AccountService;
    
    @RequestMapping(value = "/signup")
    public ModelAndView createForm() {
    	ModelAndView mav = new ModelAndView("account/registration");
    	mav.addObject("user", new UserAccount());
        return mav;
    }

    //registration
    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") UserAccount userAccount, BindingResult result) {
    	System.out.println("LOADING...");
        if (result.hasErrors()) {
            return "user/registration";
        }
        AccountService.saveCustomer(userAccount);
        return "redirect:/user/" + userAccount.getName();
    }
   
    @RequestMapping(value = "/{userId}")
    public String getUserProfile(@PathVariable String userId, Map<String, Object> model) {
        UserAccount userAccount = AccountService.findByUsername(userId);
        model.put("user", userAccount);
        return "account/view";
    }


}