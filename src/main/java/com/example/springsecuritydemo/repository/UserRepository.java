package com.example.springsecuritydemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecuritydemo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
            Optional<User>    findByName(String brand) ;
}
