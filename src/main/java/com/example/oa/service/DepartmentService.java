package com.example.oa.service;

import com.example.oa.entity.Department;
import com.example.oa.mapper.DepartmentMapper;
import com.example.oa.utils.MybatisUtils;

public class DepartmentService {
	public Department selectById(Long departmentId) {
		return (Department) MybatisUtils.executeQuery(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).selectById(departmentId));
	}
}
