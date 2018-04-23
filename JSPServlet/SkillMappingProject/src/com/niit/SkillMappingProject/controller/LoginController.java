package com.niit.SkillMappingProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.niit.SkillMappingBackEnd.Repository.UserDAOImpl;
import com.niit.SkillMappingBackEnd.utility.Validation;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		{

			ProfileDAOImpl profileDao = new ProfileDAOImpl();
			
			UserDAOImpl userDao = new UserDAOImpl();
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			//String str = request.getParameter("username");
			String id= request.getParameter("username");
            String pwd=request.getParameter("password");
			 int empId = Integer.parseInt(id);
			 String role= request.getParameter("role");
				//String pwd = ((String) request.getAttribute("password"));
				System.out.println("login controller");
				
				
				try
				 {
				 String userValidate = userDao.authorizeUser(empId, pwd,role);
				 System.out.println(userValidate);
				 if(userValidate.equals("HR"))
				 {
				 System.out.println("Hr");
				 
				 session = request.getSession(); //Creating a session
				 session.setAttribute("HR", empId); //setting session attribute
				// request.setAttribute("userName", userName);
				 List<Profile> profilelist = profileDao.getAllProfiles("false");
					session.setAttribute("profilelist", profilelist);
				 request.getRequestDispatcher("pendingProfiles.jsp").forward(request, response);
				 }
				 else if(userValidate.equals("Employer"))
				 {
					 
				 System.out.println("Employer");
				 List<Profile> profilelist1 = profileDao.getAllProfiles("true");
					session.setAttribute("profilelist1", profilelist1);
				 session = request.getSession();
				 session.setAttribute("Employer", empId);
				 
				 request.getRequestDispatcher("/approvedProfiles.jsp").forward(request, response);
				 }
				 else if(userValidate.equals("Empolyee"))
				 {
				 System.out.println("Employee");
				 
				session = request.getSession();
				 session.setMaxInactiveInterval(10*60);
				 session.setAttribute("Empolyee", empId);
				 
				 request.getRequestDispatcher("/home.jsp").forward(request, response);
				 }
				 else
				 {
				 System.out.println("Error message = "+userValidate);
				 request.setAttribute("errMessage", userValidate);
				 
				 request.getRequestDispatcher("/login.jsp").forward(request, response);
				 }
				 }
				 catch (IOException e1)
				 {
				 e1.printStackTrace();
				 }
				 catch (Exception e2)
				 {
				 e2.printStackTrace();
				 }
				} //End of doPost()
				}
}
// }
