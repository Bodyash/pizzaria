package com.bodyash.pizzaria.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bodyash.pizzaria.bean.UserAccount;
import com.bodyash.pizzaria.dao.AccountDao;


@Repository("userDao")
public class AccountDaoImpl extends AbstractDao<Integer, UserAccount> implements AccountDao {
 
    public UserAccount findById(int id) {
    	return getByKey(id);
    }
 
    public UserAccount findBySSO(String sso) {
    	Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        return (UserAccount) crit.uniqueResult();
    }
}