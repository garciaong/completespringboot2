package com.garcia.springbootweb.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.garcia.springbootweb.credential.Role;
import com.garcia.springbootweb.credential.User;
import com.garcia.springbootweb.repository.RoleRepository;
import com.garcia.springbootweb.repository.UserRepository;

@Service("userService")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

}