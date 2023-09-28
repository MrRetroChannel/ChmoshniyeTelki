package com.boostywannabe.springproj.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleID;

    @Column(name = "role")
    private RoleType role;

    public Role() {

    }

    public Role(Long roleID) {
        this.roleID = roleID;
    }

    public Role(Long roleID, RoleType role) {
        this.roleID = roleID;
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.getRole();
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
