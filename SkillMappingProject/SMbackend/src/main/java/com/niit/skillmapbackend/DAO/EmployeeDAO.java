package com.niit.skillmapbackend.DAO;

import java.util.List;

import com.niit.skillmapbackend.entity.Employee;

public interface EmployeeDAO {
	public boolean add(Employee emp);
	
	public boolean update(Employee emp);

	public Employee listById(int empId);
	
	public Employee listByEmailId(String emailId);
	
	public List<Employee> listAll();

	public boolean delete(int empId);

}
