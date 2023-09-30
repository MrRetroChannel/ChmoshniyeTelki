package com.boostywannabe.springproj.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RoleType {
    NONE("NONE"),
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    EDITOR("ROLE_EDITOR"),
    CREATOR("ROLE_CREATOR");

    private final String role;

    RoleType(String role) {
        this.role = role;
    }

    @JsonValue
    public String getRole() {
        return role;
    }
}
