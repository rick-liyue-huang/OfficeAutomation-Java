package com.example.oa.mapper;

import com.example.oa.entity.ProcessFlow;
import com.example.oa.utils.MybatisUtils;
import org.junit.Test;

import java.util.Date;
import java.util.Properties;

import static org.junit.Assert.*;

public class ProcessFlowMapperTest {

	@Test
	public void insert() {
		MybatisUtils.executeUpdate(sqlSession -> {
			ProcessFlowMapper processFlowMapper = sqlSession.getMapper(ProcessFlowMapper.class);

			ProcessFlow processFlow = new ProcessFlow();
			processFlow.setFormId(3l);
			processFlow.setOperatorId(2l);
			processFlow.setAction("audit");
			processFlow.setResult("approved");
			processFlow.setReason("agree");
			processFlow.setCreateTime(new Date());
			processFlow.setAuditTime(new Date());
			processFlow.setOrderNo(1);
			processFlow.setState("ready");
			processFlow.setIsLast(1);

			processFlowMapper.insert(processFlow);
			return null;
		});
	}
}