package com.security.springsecurity.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/demo")
    public String SayHello() {
        var authenticatedUser = SecurityContextHolder.getContext().getAuthentication();
        authenticatedUser.getAuthorities().stream().forEach(a -> System.out.println(a));
        return authenticatedUser.getPrincipal().toString();
    }
}