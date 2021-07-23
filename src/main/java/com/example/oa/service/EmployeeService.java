package com.example.oa.service;

import com.example.oa.entity.Employee;
import com.example.oa.mapper.EmployeeMapper;
import com.example.oa.utils.MybatisUtils;

public class EmployeeService {
	public Employee selectById(Long employeeId) {
		Employee employee = (Employee) MybatisUtils.executeQuery(sqlSession -> {
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			return employeeMapper.selectById(employeeId);
		});
		return employee;
	}
}
