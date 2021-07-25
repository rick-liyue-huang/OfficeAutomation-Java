package com.example.oa.service;

import com.example.oa.entity.VacationForm;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class VacationFormServiceTest {

	VacationFormService service = new VacationFormService();
	@Test
	public void createVacationForm() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(
				"dd/MM/yyyy"
		);
		VacationForm form = new VacationForm();
		form.setEmployeeId(1L);
		form.setStartTime(sdf.parse("26/03/2021"));
		form.setEndTime(sdf.parse("27/03/2021"));
		form.setFormType(1);
		form.setReason("72");
		form.setCreateTime(new Date());
		VacationForm savedForm = service.createVacationForm(form);
		System.out.println(savedForm.getFormId());
	}
}