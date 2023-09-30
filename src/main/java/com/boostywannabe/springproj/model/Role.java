package com.boostywannabe.springproj.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role")
    private Long roleID;

    @Transient
    private RoleType role;

    public Role() {

    }

    public Role(RoleType role) {
        this.roleID = Long.valueOf(role.ordinal());
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
