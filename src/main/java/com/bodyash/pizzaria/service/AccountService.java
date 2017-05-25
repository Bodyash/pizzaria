package com.bodyash.pizzaria.service;

import com.bodyash.pizzaria.bean.UserAccount;

public interface AccountService {
	 
    UserAccount findById(int id);
     
    UserAccount findBySso(String sso);

	void saveUser(UserAccount user);
     
}