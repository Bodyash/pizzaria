package com.bodyash.pizzaria.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    AccountService AccountService;
    
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
        AccountService.saveUser(user);

        model.addAttribute("success", "User " + user.getSsoId() + " has been registered successfully");
        return "registrationsuccess";
    }
   
    @RequestMapping(value = "account/{userId}")
    public String getUserProfile(@PathVariable String userId, Map<String, Object> model) {
    	try{
    		UserAccount userAccount = AccountService.findById(Integer.valueOf(userId));
    		 model.put("user", userAccount);
    	     return "account/view";
    	}catch (Exception e) {
			System.out.println("Wrong User ID in Path Variable");
		}
	    return "home";
       
    }
    
    @ModelAttribute("roles")
    public List<UserAccountRole> initializeProfiles() {
        return userAccountRoleService.findAll();
    }


}
