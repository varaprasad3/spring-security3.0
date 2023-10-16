package com.example.springsecuritydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritydemo.dao.UserDao;
import com.example.springsecuritydemo.entity.User;

@RestController

public class UserController {

	@Autowired
	UserDao userDao ;
	
	@RequestMapping
	("/hello")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String m1() {
		return "hi " ;
	}
	
	@RequestMapping("/welcome")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String m2() {
		return "welcome admin" ;
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User user) {
		return userDao.saveUser(user) ;
	}

}
