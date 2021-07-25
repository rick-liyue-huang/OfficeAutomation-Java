package com.example.oa.service;

import com.example.oa.entity.Employee;
import com.example.oa.mapper.EmployeeMapper;
import com.example.oa.utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {
	public Employee selectById(Long employeeId) {
		Employee employee = (Employee) MybatisUtils.executeQuery(sqlSession -> {
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			return employeeMapper.selectById(employeeId);
		});
		return employee;
	}

	public Employee selectLeader(Long employeeId) {
		Employee l = (Employee) MybatisUtils.executeQuery(sqlSession -> {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.selectById(employeeId);
			Map params = new HashMap<>();
			Employee leader = null;
			if (employee.getLevel() < 7) {
//				query the department manager
					params.put("level", 7);
					params.put("departmentId", employee.getDepartmentId());
					List<Employee> employees =  mapper.selectByParams(params);
					leader = employees.get(0);

			} else if (employee.getLevel() == 7) {
//				query the boss
					params.put("level", 8);
				List<Employee> employees =  mapper.selectByParams(params);
				leader = employees.get(0);

			} else if (employee.getLevel() == 8) {
//				query himself
					leader = employee;
			}
			return leader;
		});
		return l;
	}
}
