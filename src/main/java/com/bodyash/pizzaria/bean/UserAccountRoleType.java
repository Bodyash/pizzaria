package com.bodyash.pizzaria.bean;


public enum UserAccountRoleType {
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");
     
    String userAccountRoleType;
     
    private UserAccountRoleType(String userAccountRoleType){
        this.userAccountRoleType = userAccountRoleType;
    }
     
    public String getUserAccountRoleType(){
        return userAccountRoleType;
    }
     
}
