package com.niit.SkillMappingProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.SkillMappingBackEnd.Entity.User;
import com.niit.SkillMappingBackEnd.Repository.UserDAOImpl;
import com.niit.SkillMappingBackEnd.utility.Validation;

/**
 * Servlet implementation class RegisterationController
 */
@WebServlet("/RegisterationController")
public class RegisterationController extends HttpServlet {

	UserDAOImpl userDao = new UserDAOImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);
		Validation validation = new Validation();
		PrintWriter out = response.getWriter();
		String employeeId = request.getParameter("EmployeeId");

		String name = request.getParameter("name");
		String emailId = request.getParameter("emailID");
		String password = request.getParameter("password");

		String role = request.getParameter("role");
		if (!validation.isFieldEmpty(employeeId)||!validation.isFieldEmpty(name)||!validation.isFieldEmpty(emailId)||!validation.isFieldEmpty(password)) {
			messages.put("Required", "* Fields are  required ");
		
		} 
		else
		if(validation.validateEmail(emailId)) {
			messages.put("emailId",	 "Enter valid EmailID ");
			//request.setAttribute("emailId", emailId);
			 
			 }
			 

		else if (messages.isEmpty()) {
			User user = new User();

			
			user.setEmpId(Integer.parseInt(employeeId));
			user.setName(name);
			out.println(emailId);
			user.setEmailId(emailId);
			user.setPassword(password);
			user.setRole(role);
			if (userDao.insertUser(user)) {
				messages.put("success", "Please inserted successfully");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else

			request.getRequestDispatcher("register.jsp").forward(request, response);

	}
}
