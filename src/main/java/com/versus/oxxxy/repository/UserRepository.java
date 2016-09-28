package com.versus.oxxxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.versus.oxxxy.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}