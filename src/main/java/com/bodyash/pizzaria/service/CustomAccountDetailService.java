package com.bodyash.pizzaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.bodyash.pizzaria.bean.UserAccount;
import com.bodyash.pizzaria.bean.UserAccountRole;


public class CustomAccountDetailService implements UserDetailsService{
   
	@Autowired
    private AccountService accountService;

    @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount account = accountService.findBySso(username);
        if (account == null) {
        	System.out.println("Username not found!");
            throw new UsernameNotFoundException("Username not FOUND!!!");
        }
        return new org.springframework.security.core.userdetails.User(account.getSsoId(), account.getPassword(), true, true, true, true, getGrantedAuthorities(account));
	}

    private List<GrantedAuthority> getGrantedAuthorities(UserAccount user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(UserAccountRole userAccountRole : user.getUserRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userAccountRole.getType()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }

}
