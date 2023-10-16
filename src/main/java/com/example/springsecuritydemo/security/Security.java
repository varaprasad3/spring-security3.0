package com.example.springsecuritydemo.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.springsecuritydemo.service.UserInfoUserDetails;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class Security {

	@Bean
	public UserDetailsManager userDetailsManager(PasswordEncoder pe) {
//		UserDetails userDetails = User.withUsername("varaprasad").password(pe.encode("varaprasad123")).roles("ADMIN").build() ;
//		UserDetails userDetails2 = User.withUsername("karthik").password(pe.encode("karthik123")).roles("USER").build() ;
		
		return new UserInfoUserDetails() ;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder() ;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeHttpRequests().requestMatchers("/welcome","/saveUser").permitAll().and().authorizeHttpRequests().requestMatchers("/hello").authenticated().and().formLogin().and().build() ;
	}
}
