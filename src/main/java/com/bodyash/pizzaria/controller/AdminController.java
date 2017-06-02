package com.bodyash.pizzaria.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bodyash.pizzaria.bean.UserAccount;
import com.bodyash.pizzaria.bean.UserAccountRole;
import com.bodyash.pizzaria.service.AccountService;
import com.bodyash.pizzaria.service.UserAccountRoleService;

@Controller
public class AdminController {
	
    @Autowired
    AccountService accountService;
    
    @Autowired
    UserAccountRoleService userAccountRoleService;
	
    @RequestMapping(value = "/adminpanel", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "account/adminpanel";
    }
 
    @RequestMapping(value = "/orderpanel", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "account/dba";
    }
    
    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String usePage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "account/cabinet";
    }
    
    @RequestMapping(value = "adminpanel/userlist", method = RequestMethod.GET)
    public String userList(ModelMap model) {
        model.addAttribute("userlist", accountService.findAllUsers());
        return "account/userlist";
    }
    
    @RequestMapping(value = "adminpanel/newuser", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        UserAccount user = new UserAccount();
        model.addAttribute("user", user);
        return "account/newuser";
    }
    
    @RequestMapping(value = { "adminpanel/delete-user-{ssoId}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId) {
        accountService.deleteUserBySSO(ssoId);
        return "redirect:/adminpanel/userlist";
    }
    
    @RequestMapping(value = "adminpanel/newuser", method = RequestMethod.POST)
    public String saveRegistration(@Valid UserAccount user, @RequestParam("userRoles") String userRoles,
            BindingResult result, ModelMap model) {
 
        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "newuser";
        }
         
        System.out.println("SSO ID : "+user.getSsoId());
        System.out.println("Password : "+user.getPassword());
        System.out.println("Checking UserRoles....");
        if(user.getUserRoles()!=null){
        	if(userRoles.length()>0){
        		user.setUserProfiles(this.requestUserRolesConverter(userRoles));
        	}
            for(UserAccountRole role : user.getUserRoles()){
                System.out.println("Role : "+ role.getType());
            }
        }
        if(accountService.findBySso(user.getSsoId()) != null){
            model.addAttribute("success", "User " + user.getSsoId() + " IS ALREADY in DB");
            return "registrationsuccess";
        }else{
        	accountService.saveUser(user);
        }
        model.addAttribute("success", "User " + user.getSsoId() + " has been registered successfully");
        return "registrationsuccess";
    }
    
    @RequestMapping(value = { "adminpanel/edit-user-{ssoId}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable String ssoId, ModelMap model) {
        UserAccount user = accountService.findBySso(ssoId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "account/newuser";
    }
    
    @RequestMapping(value = { "adminpanel/edit-user-{ssoId}" }, method = RequestMethod.POST)
    public String updateUser(@Valid UserAccount user, BindingResult result, @RequestParam("userRoles") String userRoles,
            ModelMap model, @PathVariable String ssoId) {
        if (result.hasErrors()) {
            return "account/newuser";
        }
 
        /*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
            FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }*/
        
        System.out.println("SSO ID : "+user.getSsoId());
        System.out.println("Password : "+user.getPassword());
        System.out.println("Checking UserRoles....");
        if(user.getUserRoles()!=null){
        	if(userRoles.length()>0){
        		user.setUserProfiles(this.requestUserRolesConverter(userRoles));
        	}
            for(UserAccountRole role : user.getUserRoles()){
                System.out.println("Roles after requestUserRolesConverter method : "+ role.getType());
            }
        }
 
        accountService.updateUser(user);
 
        model.addAttribute("success", "User " + user.getSsoId() + " updated successfully");
        return "registrationsuccess";
    }
    
    private Set<UserAccountRole> requestUserRolesConverter(String userRoles) {
    	Set<UserAccountRole> set = new HashSet<UserAccountRole>();
		if (!userRoles.contains(",")){
			try {
				set.add(userAccountRoleService.findById(Integer.valueOf(userRoles)));
			} catch (Exception e) {
				return null;
			}
		}else{
			try {
				StringTokenizer st = new StringTokenizer(userRoles, ",");
				while (st.hasMoreTokens()){
					set.add(userAccountRoleService.findById(Integer.valueOf(st.nextToken())));
				}
			} catch (Exception e) {
				return null;
			}	
		}
		return set;
	}

	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
    
    @ModelAttribute("roles")
    public List<UserAccountRole> initializeProfiles() {
        return userAccountRoleService.findAll();
    }

}
