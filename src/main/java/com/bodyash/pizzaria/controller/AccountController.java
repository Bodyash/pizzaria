package com.bodyash.pizzaria.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bodyash.pizzaria.bean.UserAccount;
import com.bodyash.pizzaria.service.AccountService;

@Controller
@RequestMapping(value = "/signup")
public class AccountController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AccountService AccountService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createForm() {
    	ModelAndView mav = new ModelAndView("account/registration");
    	mav.addObject("user", new UserAccount());
        return mav;
    }

    //registration
    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(@RequestParam(value="field_username", required=true) String username, 
            @RequestParam(value="field_pwd1", required=false) String pwd1, 
            @RequestParam(value="field_pwd2", required=false) String pwd2) {
    	System.out.println("LOADING...");
    	UserAccount user = new UserAccount();
    	user.setSsoId(username.toLowerCase());
    	user.setPassword(bCryptPasswordEncoder.encode(pwd1));
    	if(AccountService.findBySso(user.getSsoId()) == null){
    		System.out.println("pass = " + pwd1 + " pass_hash = " + user.getPassword());
    		AccountService.saveUser(user); 
    	}else{
    		return "account/registration";
    	}
        
        return "redirect:/account/cabinet";
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


}
