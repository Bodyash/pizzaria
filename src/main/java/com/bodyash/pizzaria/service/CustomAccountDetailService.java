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


public class CustomAccountDetailService implements UserDetailsService{
    @Autowired
    private AccountService accountService;

    @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount account = accountService.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Username not FOUND!!!");
        }
        return new org.springframework.security.core.userdetails.User(account.getName(), account.getPass_hash(), true, true, true, true, getGrantedAuthorities(account));
	}

    private List<GrantedAuthority> getGrantedAuthorities(UserAccount user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        System.out.print("authorities :" + authorities);
        return authorities;
    }

}
