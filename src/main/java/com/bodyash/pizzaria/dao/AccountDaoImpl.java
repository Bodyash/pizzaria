package com.bodyash.pizzaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bodyash.pizzaria.bean.UserAccount;
import com.bodyash.pizzaria.dao.AccountDao;


@Repository("accountDao")
public class AccountDaoImpl extends AbstractDao<Integer, UserAccount> implements AccountDao {
 
    public UserAccount findById(int id) {
    	return getByKey(id);
    }
 
    public UserAccount findBySSO(String sso) {
    	Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        return (UserAccount) crit.uniqueResult();
    }

	@Override
	public void save(UserAccount user) {
		persist(user);
	}

	@Override
	public void deleteBySSO(String sso) {
        UserAccount user = this.findBySSO(sso);
        delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
    public List<UserAccount> findAllUsers() {
        List<UserAccount> users = getSession().createCriteria(UserAccount.class).list();
        return users;
    }
	
	@Override
	public void updateUser(UserAccount user){
		update(user);
	}
}