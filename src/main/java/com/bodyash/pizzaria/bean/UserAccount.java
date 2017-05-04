package com.bodyash.pizzaria.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String pass_hash;
    private String role = UserAccountRole.USER.getUserAccountRole();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
	public String getPass_hash() {
		return pass_hash;
	}

	public void setPass_hash(String pass_hash) {
		this.pass_hash = pass_hash;
	}


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserAccount))
            return false;
        UserAccount other = (UserAccount) obj;
        if (id != other.id)
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserProfile [id=" + id + ",  role=" + role + "]";
    }


}
