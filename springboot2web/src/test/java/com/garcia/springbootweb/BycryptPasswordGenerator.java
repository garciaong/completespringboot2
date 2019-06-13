package com.garcia.springbootweb;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BycryptPasswordGenerator {

	public static void main(String [] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("123"));
	}
	
}
