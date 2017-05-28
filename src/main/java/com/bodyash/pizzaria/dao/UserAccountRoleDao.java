package com.bodyash.pizzaria.dao;

import java.util.List;

import com.bodyash.pizzaria.bean.UserAccountRole;

public interface UserAccountRoleDao {
	
    public List<UserAccountRole> findAll();
    
    public UserAccountRole findByType(String type);
     
    public UserAccountRole findById(int id);

}
