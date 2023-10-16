package com.example.springsecuritydemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.springsecuritydemo.entity.User;
import com.example.springsecuritydemo.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository  userRepository  ;
	
	@Autowired
	PasswordEncoder passwordEncoder ;
	
	public String saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user) ;
		return "data saved successfully " ;
	}
	
}
