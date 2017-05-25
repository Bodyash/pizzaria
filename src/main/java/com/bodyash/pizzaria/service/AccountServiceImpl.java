package com.bodyash.pizzaria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bodyash.pizzaria.bean.UserAccount;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	@Qualifier("accountDao")
    private com.bodyash.pizzaria.dao.AccountDao dao;
 
    public UserAccount findById(int id) {
        return dao.findById(id);
    }
 
    public UserAccount findBySso(String sso) {
        return dao.findBySSO(sso);
    }

	@Override
	public void saveUser(UserAccount user) {
		// TODO Auto-generated method stub
		
	}

}