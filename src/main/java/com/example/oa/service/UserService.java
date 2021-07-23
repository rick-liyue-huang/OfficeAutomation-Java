package com.example.oa.service;

import com.example.oa.entity.User;
import com.example.oa.mapper.UserMapper;
import com.example.oa.service.exception.LoginException;


/**
 * the indeed business to deal with the backend login process.
 */
public class UserService {
	private UserMapper userMapper = new UserMapper();

	/**
	 * validate the result by input content
	 * @param username input username
	 * @param password input password
	 * @return User entity
 	 * @throws LoginException custom exception
	 */
	public User checkLogin(String username, String password) {
		User user = userMapper.selectByUsername(username);
		if(user == null) {
			throw new LoginException("username is not exist");
		}
		if (!password.equals(user.getPassword())) {
			throw new LoginException("password is not corrected");
		}
		return user;
	}
}
