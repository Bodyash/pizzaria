package com.bodyash.pizzaria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bodyash.pizzaria.bean.UserAccount;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	@Qualifier("accountDao")
    private com.bodyash.pizzaria.dao.AccountDao dao;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
 
    public UserAccount findById(int id) {
        return dao.findById(id);
    }
 
    public UserAccount findBySso(String sso) {
        return dao.findBySSO(sso);
    }

	@Override
	public void saveUser(UserAccount user) {
        System.out.println("NOT Encrypted pass: " + user.getPassword());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println("Encrypted pass: " + user.getPassword());
        dao.save(user);
	}

}
