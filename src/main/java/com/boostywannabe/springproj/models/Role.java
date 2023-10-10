package com.boostywannabe.springproj.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "role")
    private RoleType role;

    public Role() {

    }

    public Role(RoleType role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.getRole();
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
