package com.garcia.springbootweb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.garcia.springbootweb.credential.User;
import com.garcia.springbootweb.service.UserService;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringbootwebApplication.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService service;
	
	@Test
	public void testFindUserByEmail() {
		User user = service.findUserByEmail("admin@sb2.com");
		assertNotNull(user);
		assertEquals(1, user.getActive());
	}
	
}
