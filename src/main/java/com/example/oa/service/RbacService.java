package com.example.oa.service;

import com.example.oa.entity.Node;
import com.example.oa.mapper.RbacMapper;

import java.util.List;

public class RbacService {
	private RbacMapper rbacMapper = new RbacMapper();
	public List<Node> selectNodeByUserId(Long userId) {
		return rbacMapper.selectNodeByUserId(userId);
	}
}
