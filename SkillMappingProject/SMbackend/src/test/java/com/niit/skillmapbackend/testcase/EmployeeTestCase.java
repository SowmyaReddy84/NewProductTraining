package com.niit.skillmapbackend.testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.skillmapbackend.config.ApplicationContext;
import com.niit.skillmapbackend.entity.Employee;
import com.niit.skillmapbackend.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ApplicationContext.class)

public class EmployeeTestCase {

	@Autowired
	private EmployeeService employeesService;

	@Before
	public void setup() {
		

		Employee emp1=new Employee();
		emp1.setEmpId(13);
		emp1.setPassword("abcd");
		emp1.setRole("HR");
		emp1.setEmailId("raju@gmail.com");
		employeesService.addEmployee(emp1);
		}
	
	@After
	public void teardown() {
		
		employeesService.deleteEmployee(13);
		
	}
	@Ignore
	@Test
	public void testAddEmployee() {
		
		Employee employee=new Employee();
		employee.setEmpId(111);
		employee.setName("janya");
		employee.setPassword("janya@123");
		employee.setRole("Employee");
		employee.setEmailId("janya@gmail.com");
		
		assertEquals("insert failed",true, employeesService.addEmployee(employee));
				
	}
	@Ignore
	@Test
	public void listAllEmployeeTestcase() {

		int count = employeesService.listAllEmployees().size();

	assertEquals("Failed to list the employees!", 3, count);

	}
	@Ignore
	@Test
	public void updateEmployeeTestcase() {
		Employee employee=new Employee();
		employee = employeesService.listEmployeeById(13);
		//employees.setEmployeeName("HTML");
      //employee.setEmailId("sonu@gmail.com");
		employee.setContactNo("987654321");
		boolean flag = employeesService.updateEmployee(employee);

		assertEquals("Failed to update the employees!", true, flag);

	}

	@Ignore
	@Test
	public void deleteEmployeeTestcase() {
		Employee employee=new Employee();
		boolean flag = employeesService.deleteEmployee(111);

		assertEquals("Failed to delete the employees!", true, flag);

	}

	//@Ignore
	@Test
	public void listEmployeebyIdTestcase() {
		Employee employee=new Employee();
		employee = employeesService.listEmployeeById(110);
		assertEquals("Failed to get the employees!", "aju@gmail.com", employee.getEmailId());
	}

	


}
