package com.example.oa.mapper;

import com.example.oa.entity.User;
import com.example.oa.utils.MybatisUtils;

/**
 * here only used to couple with mappers/xxx.xml files
 * the exact business will to server directory.
 */
public class UserMapper {
	public User selectByUsername(String username) {
		User user = (User) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("usermapper.selectByUsername",
				username));
//		if not exist, return null;
		return user;
	}
}
