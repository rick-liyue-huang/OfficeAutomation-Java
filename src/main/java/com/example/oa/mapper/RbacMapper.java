package com.example.oa.mapper;

import com.example.oa.entity.Node;
import com.example.oa.utils.MybatisUtils;

import java.util.List;

public class RbacMapper {
	public List<Node> selectNodeByUserId(Long userId) {
		List list = (List) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList("rbacmapper.selectNodebyUserId", userId));
		return list;
	}
}
