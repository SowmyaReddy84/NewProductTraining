package com.niit.SkillMappingBackEnd.Entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.niit.SkillMappingBackEnd.utility.Validation;
public class User {

	private int empId;
	private String name;
	private String emailId;
	private String password;
	private String role;
	private Validation valid;
	
	public User() {
		valid=new Validation();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
		this.password = password;
	
		
	}

	

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		
		
		if(valid.validateEmail(emailId))
		    this.emailId = emailId;
		else
			emailId="";
		
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

}
