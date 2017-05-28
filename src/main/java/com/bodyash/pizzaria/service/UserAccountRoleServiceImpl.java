package com.bodyash.pizzaria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyash.pizzaria.bean.UserAccountRole;
import com.bodyash.pizzaria.dao.UserAccountRoleDao;
@Service("userAccountRoleService")
@Transactional
public class UserAccountRoleServiceImpl implements UserAccountRoleService {
	
    @Autowired
    UserAccountRoleDao dao;

	@Override
	public List<UserAccountRole> findAll() {
		return dao.findAll();
	}

	@Override
	public UserAccountRole findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public UserAccountRole findByType(String type) {
		return dao.findByType(type);
	}

}
