package com.niit.SkillMappingProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.SkillMappingBackEnd.Entity.Profile;
import com.niit.SkillMappingBackEnd.Entity.Skills;
import com.niit.SkillMappingBackEnd.Repository.ProfileDAOImpl;
import com.niit.SkillMappingBackEnd.Repository.SkillsDAOImpl;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	SkillsDAOImpl skillsDao=new SkillsDAOImpl();
	
    
    public SearchServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String key=request.getParameter("searchKey");	
	List<Skills> skilledProfiles=skillsDao.listProfilesBySkillName(key);
	 session = request.getSession(); 
	session.setAttribute("skilledProfileslist", skilledProfiles);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
