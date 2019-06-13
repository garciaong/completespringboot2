package com.garcia.springbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garcia.springbootweb.credential.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);
	
}