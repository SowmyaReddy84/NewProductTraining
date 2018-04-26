package com.niit.skillmapbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.skillmapbackend.DAO.EmployeeDAO;
import com.niit.skillmapbackend.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	@Override
	public boolean addEmployee(Employee employee) {
		if(employeeDAO.searchById(employee.getEmpId())!=null) {
			return false;
		}
		else {
			employeeDAO.add(employee);
			return true;
		}

	}
	@Override
	public boolean updateEmployee(Employee employee) {
		if(employeeDAO.searchById(employee.getEmpId())!=null) {	
			employeeDAO.update(employee);
			return true;
		}
		else {
			return false;
		}

	}


	@Override
	public Employee searchEmployeeById(int empId) {
		return employeeDAO.searchById(empId);

	}
	@Override
	public List<Employee> listAllEmployees() {
		return employeeDAO.listAll();

	}
	@Override
	public boolean deleteEmployee(int empId) {
		if(employeeDAO.searchById(empId)!=null) {	
			employeeDAO.delete(empId);
			return true;
		}
		else {
			return false;
		}


	}


	@Override
	public boolean approveEmployee(Employee emp) {
		if(employeeDAO.approveEmployee(emp))
					return true;
		else
			return false;
	}








}
