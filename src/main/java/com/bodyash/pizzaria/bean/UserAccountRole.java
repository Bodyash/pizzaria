package com.bodyash.pizzaria.bean;

public enum UserAccountRole {
    USER("USER"),
    ADMIN("ADMIN");

    String userAccountRole;

    private UserAccountRole(String userAccountRole) {
        this.userAccountRole = userAccountRole;
    }

    public String getUserAccountRole() {
        return userAccountRole;
    }

}