/**
 * 
 */
/**
 * @author Global.Root
 *
 */
package com.niit.smrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillmapbackend.entity.Employee;
import com.niit.skillmapbackend.service.EmployeeService;

@RestController
@RequestMapping("/RestAPI/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeesService;
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> listAllEmployees() {
		
		return  new ResponseEntity <List<Employee>>(employeesService.listAllEmployees(), HttpStatus.CREATED);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") int empId) {
		
		if(employeesService.listEmployeeById(empId)!=null) {
			return new ResponseEntity<Employee>(employeesService.listEmployeeById(empId), HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND); 
	}
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empId") int empId) {
		
		if(employeesService.listEmployeeById(empId)!=null) {
			employeesService.deleteEmployee(empId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
		
		if(employeesService.listEmployeeByEmailId(employee.getEmailId())!=null) {
			
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		else {
			employeesService.addEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
		
		if(employeesService.listEmployeeById(employee.getEmpId())!=null) {
			employeesService.updateEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	


}
	