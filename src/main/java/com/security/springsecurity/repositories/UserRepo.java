package com.security.springsecurity.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.security.springsecurity.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE username = ?1", nativeQuery = true)
    Optional<User> getUserByUsername(String username);

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    Optional<List<User>> getAllUsers();

}