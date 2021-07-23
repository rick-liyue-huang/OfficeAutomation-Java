package com.example.oa.service;

import com.example.oa.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.security.auth.login.LoginException;

import static org.junit.Assert.*;

public class UserServiceTest {

	private UserService userService = new UserService();
	@Test
	public void checkLogin() {
		User user = userService.checkLogin("test", "test");
		System.out.println(user);
	}
	@Test
	public void checkLogin1() {
		User user = userService.checkLogin("test", "test1");
		System.out.println(user);
	}
}