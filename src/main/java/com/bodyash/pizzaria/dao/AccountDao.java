package com.bodyash.pizzaria.dao;

import java.util.List;

import com.bodyash.pizzaria.bean.UserAccount;

public interface AccountDao {
    public UserAccount findById(int id);
    
    public UserAccount findBySSO(String sso);

    public void save(UserAccount user);
	
    public void deleteBySSO(String sso);
    
    public List<UserAccount> findAllUsers();
    
    public void updateUser(UserAccount user);

	public List<UserAccount> findBySsoPartru(String ssoId);
}
