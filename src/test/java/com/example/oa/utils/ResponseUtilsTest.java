package com.example.oa.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseUtilsTest {
	@Test
	public void put() {
		ResponseUtils utils = new ResponseUtils("LoginException", "pwd error").put("class", "xxx class");
		String result = utils.toJsonString();
		System.out.println(result);
	}
}