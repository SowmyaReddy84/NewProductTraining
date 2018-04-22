package com.niit.SkillMappingProject.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.SkillMappingBackEnd.Entity.Profile;
import com.niit.SkillMappingBackEnd.Repository.ProfileDAOImpl;

/**
 * Servlet implementation class ApproveServlet
 */
@WebServlet("/ApproveServlet")
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ProfileDAOImpl profileDao=new ProfileDAOImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] empIdList = request.getParameterValues("pendinglist");
		 ArrayList<String> list =  new ArrayList(); 
		
		   for(String id:empIdList ) {
			   
			   profileDao.approveProfile(id)
		   }
          
    }
	/*private void approveProfile(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        pf.approveProfile(id);
        List<Profile> profilelist = pf.getAllProfiles("false");
		session.setAttribute("profilelist", profilelist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pendingProfiles.jsp");
             dispatcher.forward(request, response);
 
    }
	private void deleteProfile(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        pf.deleteProfile(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pendingProfiles.jsp");
        try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        response.sendRedirect("list");
 
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
