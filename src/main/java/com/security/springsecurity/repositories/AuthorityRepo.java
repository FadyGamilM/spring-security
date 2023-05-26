package com.security.springsecurity.repositories;

import com.security.springsecurity.domain.Authority;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorityRepo extends JpaRepository<Authority, Long> {

    @Query(value = "SELECT * FROM authorities WHERE action = ?1", nativeQuery = true)
    Optional<Authority> getAuthorityByAuthorityAction(String action);

    @Query(value = "SELECT * FROM authorities", nativeQuery = true)
    Optional<List<Authority>> getAllAuthorities();

}