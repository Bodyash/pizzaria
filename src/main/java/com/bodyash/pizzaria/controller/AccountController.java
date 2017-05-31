package com.bodyash.pizzaria.controller;

import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bodyash.pizzaria.bean.UserAccount;
import com.bodyash.pizzaria.bean.UserAccountRole;
import com.bodyash.pizzaria.service.AccountService;
import com.bodyash.pizzaria.service.UserAccountRoleService;

@Controller
public class AccountController {
	
    @Autowired
    UserAccountRoleService userAccountRoleService;

    @Autowired
    AccountService accountService;
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView createForm() {
    	ModelAndView mav = new ModelAndView("account/registration");
    	UserAccount user = new UserAccount();
    	mav.addObject("user", user);
        return mav;
    }

    //registration
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String saveUser(@Valid UserAccount user,
            BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "account/registration?error";
        }
        System.out.println("SSO ID : "+user.getSsoId());
        System.out.println("Password : "+user.getPassword());
        System.out.println("Checking UsrProfiles....");
        //Set a new USER ROLE from DB
        HashSet<UserAccountRole> userRoles = new HashSet<>();
        UserAccountRole uar = userAccountRoleService.findByType("USER");
        userRoles.add(uar);
        user.setUserProfiles(userRoles);
        for(UserAccountRole role : user.getUserRoles()){
        	System.out.println("Profile : "+ role.getType());
        }
        //SAVE USER
        accountService.saveUser(user);

        model.addAttribute("success", user.getSsoId() + " has been registered");
        return "account/login";
    }


}
