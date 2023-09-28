package com.boostywannabe.springproj.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RoleType {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String role;

    private RoleType(String role) {
        this.role = role;
    }

    @JsonValue
    public String getRole() {
        return role;
    }
}
