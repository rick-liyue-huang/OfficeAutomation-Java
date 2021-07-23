package com.example.oa.mapper;

import com.example.oa.entity.Employee;

public interface EmployeeMapper {
//	match with employee.xml id
	public Employee selectById(Long employeeId);
}
