package com.security.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.springsecurity.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = """
            SELECT * FROM users WHERE username = ?1;
                """, nativeQuery = true)
    User getUserByUsername(String username);
}