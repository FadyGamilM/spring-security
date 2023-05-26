package com.security.springsecurity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.springsecurity.domain.Authority;
import com.security.springsecurity.domain.User;
import com.security.springsecurity.repositories.AuthorityRepo;
import com.security.springsecurity.repositories.UserRepo;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepo _userRepo;

    @Autowired
    private final AuthorityRepo _authorityRepo;

    @Override
    public User saveUser(User user) {
        log.info("save user {} to database", user.getUsername());
        return _userRepo.save(user);
    }

    @Override
    public Authority saveAuthority(Authority authority) {
        log.info("save authority {} to database", authority);
        return _authorityRepo.save(authority);
    }

    @Override
    public void addAuthorityToUser(String authorityAction, String username) {
        var authority = _authorityRepo.getAuthorityByAuthorityAction(authorityAction).get();
        var user = _userRepo.getUserByUsername(username).get();
        user.getAuthorities().add(authority);
    }

    @Override
    public List<Authority> getAllAuthorities() {
        log.info("get all authorities");
        return _authorityRepo.getAllAuthorities().get();
    }

    @Override
    public List<User> getAllUsers() {
        log.info("get all users");
        return _userRepo.getAllUsers().get();
    }

    @Override
    public User getByUsername(String username) {
        log.info("get user {} by username", username);
        return _userRepo.getUserByUsername(username).get();
    }

}