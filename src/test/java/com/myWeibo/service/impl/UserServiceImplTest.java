package com.myWeibo.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myWeibo.pojo.User;
import com.myWeibo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class UserServiceImplTest {
	@Resource(name="userService")
	private UserService service;
	@Test
	public void testAuthentication() {
		User user=new User("root","admin");
		service.authentication(user);
	}
	@Ignore
	@Test
	public void testSelectByUsername() {
		fail("Not yet implemented");
	}

}
