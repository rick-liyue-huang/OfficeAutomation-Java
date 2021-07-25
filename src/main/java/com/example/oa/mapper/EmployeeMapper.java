package com.example.oa.mapper;

import com.example.oa.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
//	match with employee.xml id
	public Employee selectById(Long employeeId);
	public List<Employee> selectByParams(Map params);
}
