package com.security.springsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.springsecurity.repositories.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo _repo;

    public CustomUserDetailsService(UserRepo repo) {
        _repo = repo;
    }

    public CustomUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // we can't return this user because it doesn't implement the UserDetails and
        // also i decided to not let the User domain entity implements UserDetails (S in
        // SOLID)
        // the design-wise solution i will use is to use the adaptor pattern, i will
        // make the entity User adapt the UserDetails
        var user = _repo.getUserByUsername(username);
        return null;
    }

}