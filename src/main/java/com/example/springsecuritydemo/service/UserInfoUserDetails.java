package com.example.springsecuritydemo.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import com.example.springsecuritydemo.dto.UserDto;
import com.example.springsecuritydemo.entity.User;
import com.example.springsecuritydemo.exception.UserNotFoundException;
import com.example.springsecuritydemo.repository.UserRepository;

public class UserInfoUserDetails implements UserDetailsManager {
	
	@Autowired
	UserRepository userRepository ;
	
	
	
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Optional<User> user = userRepository.findByName(username) ;
		return user.map(UserDto :: new).orElseThrow(()-> new UserNotFoundException("user not found" + username) ) ;
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
