package com.bodyash.pizzaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.bodyash.pizzaria.bean.UserAccountRole;

public class UserAccountRoleDaoIml extends AbstractDao<Integer, UserAccountRole> implements UserAccountRoleDao{

	@Override
	public List<UserAccountRole> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<UserAccountRole>)crit.list();
	}

	@Override
	public UserAccountRole findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (UserAccountRole) crit.uniqueResult();
	}

	@Override
	public UserAccountRole findById(int id) {
		 return getByKey(id);
	}

}
