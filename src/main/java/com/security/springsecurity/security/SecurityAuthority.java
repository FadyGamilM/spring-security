package com.security.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import com.security.springsecurity.domain.Authority;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    // wrapper over the authority entity
    @Autowired
    private final Authority authority;

    @Override
    public String getAuthority() {
        return authority.getAction();
    }

}