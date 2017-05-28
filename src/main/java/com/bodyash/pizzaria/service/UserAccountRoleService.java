package com.bodyash.pizzaria.service;

import java.util.List;

import com.bodyash.pizzaria.bean.UserAccountRole;

public interface UserAccountRoleService {

	public List<UserAccountRole> findAll();

	public UserAccountRole findById(Integer id);
	
	public UserAccountRole findByType(String type);

}
