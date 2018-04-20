package com.niit.SkillMappingProject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.SkillMappingBackEnd.utility.Validation;

import java.util.*;
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Map<String, String> messages = new HashMap<String, String>();
		    request.setAttribute("messages", messages);
	
		Validation validation = new Validation();
		
		
		
		System.out.println("role");
		String employeeId = request.getParameter("username");
		String password = request.getParameter("password");
		if (!validation.isFieldEmpty(employeeId)) {
	        messages.put("EmployeeId", "Please enter  EmpolyeeID ");
	        request.setAttribute("empId", employeeId);
	        
		}
		else if(!validation.isFieldEmpty(password)){
			messages.put("password", "Please enter password");
			request.setAttribute("pwd", password);
		}
		
		if (messages.isEmpty()) {
			 request.getRequestDispatcher("/loginController").forward(request, response);
	    }
		else

	    request.getRequestDispatcher("login.jsp").forward(request, response);
			

}
}
