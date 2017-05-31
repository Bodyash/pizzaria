package com.bodyash.pizzaria.dao;

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
		/*for (UserAccountRole uar : user.getUserRoles()) {
			new UserAccountRoleDaoIml().persist(uar);
		}*/
		persist(user);
	}
}