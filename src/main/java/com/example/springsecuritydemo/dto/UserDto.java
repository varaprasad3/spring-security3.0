package com.example.springsecuritydemo.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.springsecuritydemo.entity.User;

public class UserDto implements UserDetails {

	private String name ;
	private String password ;
	private List<GrantedAuthority> authorities ;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password ;
	}

	@Override
	public String getUsername() {
		return name ;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public UserDto (User user) {
		name = user.getName() ;
		password = user.getPassword() ;
		authorities = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority :: new ).collect(Collectors.toList()) ;
	} 
	
}
