package com.example.oa.controller;

import com.example.oa.entity.Department;
import com.example.oa.entity.Employee;
import com.example.oa.entity.Node;
import com.example.oa.service.DepartmentService;
import com.example.oa.service.EmployeeService;
import com.example.oa.service.RbacService;
import com.example.oa.utils.ResponseUtils;
import org.apache.commons.codec.language.RefinedSoundex;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserInfoServlet", value = "/api/user_info")
public class UserInfoServlet extends HttpServlet {
//	get the rbac info
  private RbacService rbacService = new RbacService();
//  get the employee info
  private EmployeeService employeeService = new EmployeeService();
  private DepartmentService departmentService = new DepartmentService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		get the user id
    String uid = request.getParameter("uid");
//    get the employee id
    String eid = request.getParameter("eid");

    List<Node> nodes = rbacService.selectNodeByUserId(Long.parseLong(uid));
//    change plant to tree constructors
      List<Map> treeList = new ArrayList<>();
      Map module = null;
      for (Node node: nodes) {
          if(node.getNodeType() == 1) {
//              this is module, and it includes some functions
              module = new LinkedHashMap();
              module.put("node", node);
              module.put("children", new ArrayList<>());
//     add the module to list
              treeList.add(module);
          } else if (node.getNodeType() == 2) {
//     it we get functions, it will add to children property.
              List children = (List) module.get("children");
              children.add(node);
          }
      }
			Employee employee = employeeService.selectById(Long.parseLong(eid));
      Department department = departmentService.selectById(employee.getDepartmentId());
      String string = new ResponseUtils().
		      put("nodeList", treeList).
		      put("employee", employee).
		      put("department", department).
		      toJsonString();

      response.setContentType("application/json;charset=utf-8");
      response.getWriter().println(string);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
