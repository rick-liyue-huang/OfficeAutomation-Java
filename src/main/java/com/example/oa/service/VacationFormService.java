package com.example.oa.service;

import com.example.oa.entity.Employee;
import com.example.oa.entity.ProcessFlow;
import com.example.oa.entity.VacationForm;
import com.example.oa.mapper.EmployeeMapper;
import com.example.oa.mapper.ProcessFlowMapper;
import com.example.oa.mapper.VacationFormMapper;
import com.example.oa.utils.MybatisUtils;

import java.util.Date;

public class VacationFormService {
	private EmployeeService employeeService = new EmployeeService();
	/**
	 * deal with the vacation form in business layer;
	 * @param form input form from frontend;
	 * @return the persistence entities form
	 */
	public VacationForm createVacationForm(VacationForm form) {
		VacationForm f = (VacationForm) MybatisUtils.executeUpdate(sqlSession -> {
			//	1. set the persistence layer form:
			//		level < 8, the form state is 'processing';
			//		level = 8, the form state is 'complete';
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee employee = employeeMapper.selectById(form.getEmployeeId());
			if (employee.getLevel() == 8) {
				form.setState("approved");
			} else {
				form.setState("processing");
			}
			VacationFormMapper vacationFormMapper = sqlSession.getMapper(VacationFormMapper.class);
//			add the presetting form insert into the mapper
			vacationFormMapper.insert(form);

			//  2. add one process flow record, with 'complete' state, which means the vacation application submitted; here
			//  form is prepared already, and needs to add one record of process flow to form;
			ProcessFlowMapper processFlowMapper = sqlSession.getMapper(ProcessFlowMapper.class);
			ProcessFlow flow1 = new ProcessFlow();
			flow1.setFormId(form.getFormId());
			flow1.setOperatorId(employee.getEmployeeId());
			flow1.setAction("apply");
			flow1.setCreateTime(new Date());
			flow1.setOrderNo(1);
			flow1.setState("complete");
			flow1.setIsLast(0);
			processFlowMapper.insert(flow1);

			//	3. set the different state by applicant employee:
			//	3.1. level < 7 and term >= 72, the process flow needs level 7 and 8 approved; level < 7 and term < 72, the
			//	process flow needs level 7 approved;
			if (employee.getLevel() < 7) {
				Employee dm = employeeService.selectLeader(employee.getEmployeeId());
				ProcessFlow flow2 = new ProcessFlow();
				flow2.setFormId(form.getFormId());
				flow2.setOperatorId(dm.getEmployeeId());
				flow2.setAction("audit");
				flow2.setCreateTime(new Date());
				flow2.setOrderNo(2);
				flow2.setState("process");
//				here needs to confirm the vacation term
				long diff = form.getEndTime().getTime() - form.getStartTime().getTime();
				float hours = diff / (1000 * 60 * 60) * 1f;
				if (hours >= 72) {
					flow2.setIsLast(0);
					processFlowMapper.insert(flow2);
//				needs further boss approved
					Employee boss = employeeService.selectLeader(dm.getEmployeeId());
					ProcessFlow flow3 = new ProcessFlow();
					flow3.setFormId(form.getFormId());
					flow3.setOperatorId(boss.getEmployeeId());
					flow3.setAction("audit");
					flow3.setCreateTime(new Date());
					flow3.setState("ready");
					flow3.setOrderNo(3);
					flow3.setIsLast(1);
					processFlowMapper.insert(flow3);
				} else {
					flow2.setIsLast(1);
					processFlowMapper.insert(flow2);
				}
			}
			//	3.2. level = 7, need the level 8 approved;
			else if (employee.getLevel() == 7) {
				Employee boss = employeeService.selectLeader(employee.getEmployeeId());
				ProcessFlow flow2 = new ProcessFlow();
				flow2.setFormId(form.getFormId());
				flow2.setOperatorId(boss.getEmployeeId());
				flow2.setAction("audit");
				flow2.setCreateTime(new Date());
				flow2.setState("process");
				flow2.setOrderNo(2);
				flow2.setIsLast(1);
				processFlowMapper.insert(flow2);
			}
			//	3.3. level = 8, just needs himself approved.
			else if (employee.getLevel() == 8) {
				ProcessFlow flow2 = new ProcessFlow();
				flow2.setFormId(form.getFormId());
				flow2.setOperatorId(employee.getEmployeeId());
				flow2.setAction("audit");
				flow2.setResult("approved");
				flow2.setReason("auto pass");
				flow2.setCreateTime(new Date());
				flow2.setAuditTime(new Date());
				flow2.setState("complete");
				flow2.setOrderNo(2);
				flow2.setIsLast(1);
				processFlowMapper.insert(flow2);
			}
			return form;
		});

		return f;
	}
}