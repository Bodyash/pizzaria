package com.bodyash.pizzaria.service;

import java.util.List;

import com.bodyash.pizzaria.bean.UserAccount;

public interface AccountService {
	 
    public UserAccount findById(int id);
     
    public UserAccount findBySso(String sso);

    public void saveUser(UserAccount user);
    
    public void updateUser(UserAccount user);
     
    public void deleteUserBySSO(String sso);
 
    public List<UserAccount> findAllUsers(); 
     
    public boolean isUserSSOUnique(Integer id, String sso);
     
}