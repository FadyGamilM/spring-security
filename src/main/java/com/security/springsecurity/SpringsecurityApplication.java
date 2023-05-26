package com.security.springsecurity;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.security.springsecurity.domain.Authority;
import com.security.springsecurity.domain.User;
import com.security.springsecurity.services.UserService;

@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {

			userService.saveUser(new User(1L, "fadyG", "fadyfady", new ArrayList<>()));
			userService.saveUser(new User(2L, "magyM", "magymagy", new ArrayList<>()));
			userService.saveUser(new User(3L, "ahmedM", "ahmedahmed", new ArrayList<>()));

			userService.saveAuthority(new Authority(1L, "READ", new ArrayList<>()));
			userService.saveAuthority(new Authority(2L, "UPDATE", new ArrayList<>()));
			userService.saveAuthority(new Authority(3L, "CREATE", new ArrayList<>()));
			userService.saveAuthority(new Authority(4L, "DELETE", new ArrayList<>()));

			userService.addAuthorityToUser("CREATE", "fadyG");
			userService.addAuthorityToUser("READ", "magyM");
			userService.addAuthorityToUser("READ", "fadyG");
			userService.addAuthorityToUser("DELETE", "ahmedM");
		};
	}

}
