package com.security.springsecurity.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.springsecurity.domain.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityUser implements UserDetails {

    // decorate the User domain entity by wrapping it and extends its
    // functionalities for other abstractions
    private final User _user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // this method returns a collection of authorities abstraction, and this
        // abstraction provides one method which returns string and receives nothing, so
        // thats what i will return
        // here i returned a List.of(lambda function takes nothing and returns string)
        // -> which returns collection of same func definition
        return List.of(() -> "read");
    }

    @Override
    public String getPassword() {
        return _user.getPassword();
    }

    @Override
    public String getUsername() {
        return _user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}