/**
 * 
 */
/**
 * @author Global.Root
 *
 */
package com.niit.smrest.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillmapbackend.entity.Employee;
import com.niit.skillmapbackend.service.EmployeeService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/restapi/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeesService;

	@GetMapping
	public ResponseEntity<List<Employee>> listAllEmployees() {
		if(employeesService.listAllEmployees()!=null) 
			return  new ResponseEntity <List<Employee>>(employeesService.listAllEmployees(), HttpStatus.CREATED);
		else
			return new ResponseEntity<List<Employee>> (HttpStatus.NOT_FOUND); 
	}

	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") int empId) {

		if(employeesService.searchEmployeeById(empId)!=null) {
			return new ResponseEntity<Employee>(employeesService.searchEmployeeById(empId), HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND); 
	}

	/*@GetMapping("/{emailId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("emailId") String emailId) {

		if(employeesService.searchByemailId(emailId)!=null) {
			return new ResponseEntity<Employee>(employeesService.searchEmployeeById(empId), HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND); 
	}*/

	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empId") int empId) {

		if(employeesService.searchEmployeeById(empId)!=null) {
			employeesService.deleteEmployee(empId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}

	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {

		if(employeesService.searchEmployeeById(employee.getEmpId())!=null) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		else {
			employeesService.addEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {

		if(employeesService.searchEmployeeById(employee.getEmpId())!=null) {
			employeesService.updateEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {

			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/approve/{empId}")
	public ResponseEntity<Void> approveEmployee(@RequestBody Employee employee) {


		employeesService.updateEmployee(employee);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	@RequestMapping(value = "/restapi/**", method = RequestMethod.OPTIONS)
    public void corsHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        response.addHeader("Access-Control-Max-Age", "3600");
    }
}




