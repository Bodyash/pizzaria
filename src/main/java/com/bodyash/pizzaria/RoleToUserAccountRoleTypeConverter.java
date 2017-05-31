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
        System.out.println("Role : " + profile);
        return profile;
	}
	
	
	/*public UserAccountRole convert(Object element) {
        System.out.println("Converter is working....");
        Integer id = Integer.parseInt((String)element);
        UserAccountRole profile= userAccountRoleService.findById(id);
        System.out.println("Role : " + profile);
        return profile;
    }*/
	
   /* @Override
    public UserAccountRole convert(Object element) {
        String type = (String)element;
        UserAccountRole profile= userAccountRoleService.findByType(type);
        System.out.println("Role ... : "+profile);
        return profile;
    }*/

}
