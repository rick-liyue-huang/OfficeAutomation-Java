package com.example.oa.controller;

import com.example.oa.entity.VacationForm;
import com.example.oa.service.VacationFormService;
import com.example.oa.utils.ResponseUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "VacationFormServlet", value = "/api/vacation_form/*")
public class VacationFormServlet extends HttpServlet {

    private VacationFormService vacationFormService = new VacationFormService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
    response.setContentType("application/json;charset=utf-8");
//	    http://localhost/rick_oc/api/vacation_form/create
    String uri = request.getRequestURI();
//    get 'create' part
    String methodName = uri.substring(uri.lastIndexOf("/") + 1);
    if (methodName.equals("create")) {
        this.create(request, response);
    } else if (methodName.equals("list")) {

    } else if (methodName.equals("audit")) {

    }
	}

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {
	    String strEmployeeId = request.getParameter("eid");
	    String formType = request.getParameter("formType");

	    String startTime = request.getParameter("startTime");
	    String endTime = request.getParameter("endTime");
	    String reason = request.getParameter("reason");

//	  create form to keep these
      VacationForm form = new VacationForm();
      form.setEmployeeId(Long.parseLong(strEmployeeId));
      form.setStartTime(new Date(Long.parseLong(startTime)));
      form.setEndTime(new Date(Long.parseLong(endTime)));
      form.setFormType(Integer.parseInt(formType));
      form.setReason(reason);
      form.setCreateTime(new Date());
      ResponseUtils responseUtils = null;

//    using service to deal with the form
        try {
            vacationFormService.createVacationForm(form);
            responseUtils = new ResponseUtils();
        } catch (Exception e) {
            e.printStackTrace();
            responseUtils = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        response.getWriter().println(responseUtils.toJsonString());
    }
}
