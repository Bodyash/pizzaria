package com.bodyash.pizzaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.bodyash.pizzaria.bean.UserAccountRole;
import com.bodyash.pizzaria.service.UserAccountRoleService;

public class RoleToUserAccountRoleTypeConverter implements Converter<Object, UserAccountRole>{

    @Autowired
    private UserAccountRoleService userAccountRoleService;
	
	@Override
	public UserAccountRole convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        UserAccountRole profile= userAccountRoleService.findById(id);
        System.out.println("Profile : "+profile);
        return profile;
    }

}
