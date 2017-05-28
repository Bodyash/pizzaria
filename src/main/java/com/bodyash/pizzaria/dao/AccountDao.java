package com.bodyash.pizzaria.dao;

import com.bodyash.pizzaria.bean.UserAccount;

public interface AccountDao {
    UserAccount findById(int id);
    
    UserAccount findBySSO(String sso);

	void save(UserAccount user);
}
