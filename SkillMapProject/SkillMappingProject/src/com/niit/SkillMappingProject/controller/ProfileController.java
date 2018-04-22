package com.niit.SkillMappingProject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.SkillMappingBackEnd.Entity.Profile;
import com.niit.SkillMappingBackEnd.Entity.User;
import com.niit.SkillMappingBackEnd.Repository.ProfileDAOImpl;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProfileDAOImpl profileDao=new ProfileDAOImpl();
    
    public ProfileController() {
    
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int empId= Integer.parseInt(request.getParameter("empId"));
		String contactNo=request.getParameter("contactNo");
		String qualification=request.getParameter("qualification");
		String supervisorName=request.getParameter("supervisorName");
		String cityName=request.getParameter("cityName");
		String ibu=request.getParameter("businessUnitName");
		Profile profile=new Profile();
		profile.setEmpId(empId);
		profile.setContactNo(contactNo);;
		profile.setCityName(cityName);
		profile.setQualification(qualification);
		profile.setSupervisorName(supervisorName);
		profile.setBusinessUnitName(ibu);
		if(profileDao.insertProfile(profile)){
			 request.getRequestDispatcher("Skills.jsp").forward(request, response);
		}
		else 
			 request.getRequestDispatcher("profile.jsp").forward(request, response);
			
				
	}

}
