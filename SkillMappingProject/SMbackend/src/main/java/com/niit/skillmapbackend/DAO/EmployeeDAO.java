package com.niit.skillmapbackend.DAO;

import java.util.List;

import com.niit.skillmapbackend.entity.Employee;

public interface EmployeeDAO {
	public boolean add(Employee emp);
	
	public boolean update(Employee emp);

	public Employee searchById(int empId);
	
	public Employee searchByEmailId(String emailId);
	
	public List<Employee> listAll();

	public boolean delete(int empId);
	
	
	
	public	boolean approveEmployee(Employee emp);

	public boolean authenticate(int empId, String password, String role); 
		
	}
	

