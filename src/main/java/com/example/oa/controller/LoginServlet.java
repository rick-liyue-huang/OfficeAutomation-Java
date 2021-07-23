package com.example.oa.controller;

import com.example.oa.entity.User;
import com.example.oa.service.UserService;
import com.example.oa.utils.ResponseUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/api/login")
public class LoginServlet extends HttpServlet {
	private UserService userService = new UserService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
//	 receive the user input from the front page;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		use business logic;
//		set one map to store result json
//		Map result = new LinkedHashMap<>();
		ResponseUtils resp = null;
		try {
			User user = userService.checkLogin(username, password);
//			set user to null to prevent from glance by others;
			user.setPassword(null);
			user.setSalt(null);
			resp = new ResponseUtils().put("user", user);
		} catch (Exception e) {
//			if get exception, print it out.
			e.printStackTrace();
			resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
		}
//		return json results by jackson framework
		response.getWriter().println(resp.toJsonString());
	}
}


/**
 *
 * //			if code is 0, it means it works successfully.
 * 			result.put("code", "0");
 * 			result.put("message", "success");
 * //			keep the group standard
 * 			Map data = new LinkedHashMap();
 * 			data.put("user", user);
 * 			result.put("data", data);
 *
 * 	e.printStackTrace();
 * 			result.put("code", e.getClass().getSimpleName());
 * 			result.put("message", e.getMessage());
 *
 *
 * 	ObjectMapper objectMapper = new ObjectMapper();
 * 		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
 * 		String jsonStr = objectMapper.writeValueAsString(result);
 * 		response.getWriter().println(jsonStr);
 */
