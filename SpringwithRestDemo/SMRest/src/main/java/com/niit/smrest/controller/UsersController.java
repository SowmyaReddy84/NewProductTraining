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

import com.niit.skillmapbackend.entity.Users;
import com.niit.skillmapbackend.service.UsersService;

@RestController
@RequestMapping("/api/Users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("/")
	public ResponseEntity<List<Users>> listAllUserss() {
		
		return  new ResponseEntity <List<Users>>(usersService.listAllUsers(), HttpStatus.CREATED);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Users> getUsers(@PathVariable("empId") int empId) {
		
		if(usersService.listUserById(empId)!=null) {
			return new ResponseEntity<Users>(usersService.listUserById(empId), HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND); 
	}
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("empId") int empId) {
		
		if(usersService.listUserById(empId)!=null) {
			usersService.deleteUser(empId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> addUsers(@RequestBody Users user) {
		
		if(usersService.listUserByEmailId(user.getEmailId())!=null) {
			
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		else {
			usersService.addUsers(user);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<Void> updateUser(@RequestBody Users user) {
		
		if(usersService.listUserById(user.getEmpId())!=null) {
			usersService.updateUsers(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	


}
	