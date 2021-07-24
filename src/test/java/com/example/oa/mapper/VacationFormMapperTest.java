package com.example.oa.mapper;

import com.example.oa.entity.VacationForm;
import com.example.oa.utils.MybatisUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class VacationFormMapperTest {

	/**
	 * through Test this Mapper, we get the first form record;
	 */
	@Test
	public void insert() {
		MybatisUtils.executeUpdate(sqlSession -> {
			VacationFormMapper formMapper = sqlSession.getMapper(VacationFormMapper.class);
			VacationForm form = new VacationForm();
			form.setFormType(1);
			form.setEmployeeId(4l);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date startTime = null;
			Date endTime = null;
			try {
				startTime = sdf.parse("25/03/2020");
				endTime = sdf.parse("28/03/2020");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			form.setStartTime(startTime);
			form.setEndTime(endTime);
			form.setReason("go home");
			form.setCreateTime(new Date());
			form.setState("processing");

			formMapper.insert(form);
			return null;
		});
	}
}