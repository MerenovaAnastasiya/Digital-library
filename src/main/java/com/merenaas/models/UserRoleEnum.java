package com.merenaas.models;

import org.springframework.security.core.GrantedAuthority;

public enum UserRoleEnum implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
