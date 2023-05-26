package com.security.springsecurity.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.security.springsecurity.domain.Authority;
import com.security.springsecurity.domain.User;

public interface UserService {
    // add new user to database
    User saveUser(User user);

    // add new authority to datbase
    Authority saveAuthority(Authority authority);

    // add authority to user
    void addAuthorityToUser(String authorityAction, String username);

    // get all authorities
    List<Authority> getAllAuthorities();

    // get all users
    List<User> getAllUsers();

    // get user via username
    User getByUsername(String username);
}