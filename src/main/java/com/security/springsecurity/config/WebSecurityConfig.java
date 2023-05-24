package com.security.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.security.springsecurity.repositories.UserRepo;
import com.security.springsecurity.services.CustomUserDetailsService;

import lombok.AllArgsConstructor;

@Configuration
// @AllArgsConstructor
public class WebSecurityConfig {
    // private final UserRepo _repo;

    // @Bean
    // public UserDetailsService userDetailsService() {
    // return new CustomUserDetailsService(_repo);
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // should not use this in a prod app => BCryptPasswordEncoder
    }
}