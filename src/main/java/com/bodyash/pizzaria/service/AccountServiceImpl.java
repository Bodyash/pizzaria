package com.bodyash.pizzaria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	public void updateUser(UserAccount user) {
        UserAccount entity = dao.findById(user.getId());
        if(entity!=null){
            entity.setSsoId(user.getSsoId());
            if(entity.getPassword().startsWith("$") && entity.getPassword().length() == 60){
            	System.out.println("Password already Encrypted!");
            	entity.setPassword(user.getPassword());
            }else{
            	System.out.println("Password changed! Need to encrypt!");
            	entity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            }
            entity.setUserProfiles(user.getUserRoles());
            dao.updateUser(entity);
        }
    }
 
    public void deleteUserBySSO(String sso) {
        dao.deleteBySSO(sso);
    }
 
    public List<UserAccount> findAllUsers() {
        return dao.findAllUsers();
    }
 
    public boolean isUserSSOUnique(Integer id, String sso) {
        UserAccount user = findBySso(sso);
        return ( user == null || ((id != null) && (user.getId() == id)));
    }

	@Override
	public List<UserAccount> findBySsoPartry(String ssoId) {
		return dao.findBySsoPartru(ssoId);
	}

}
