package com.niit.skillmapbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.skillmapbackend.entity.Employee;

public interface EmployeeService {
public boolean addEmployee(Employee emp);
	
	public boolean updateEmployee(Employee emp);

	public Employee listEmployeeById(int empId);

	public List<Employee> listAllEmployees();

	public boolean deleteEmployee(int empId);

	public Employee listEmployeeByEmailId(String string);

	
}
