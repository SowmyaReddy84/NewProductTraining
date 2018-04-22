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
import com.niit.skillmapbackend.entity.Users;
import com.niit.skillmapbackend.service.UsersService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ApplicationContext.class)

public class UsersTestCase {

	@Autowired
	private UsersService usersService;

	@Before
	public void setup() {
		

		Users emp1=new Users();
		emp1.setEmpId(13);
		emp1.setPassword("abcd");
		emp1.setRole("HR");
		emp1.setEmailId("sonu@gmail.com");
		usersService.addUsers(emp1);
		}
	
	@After
	public void teardown() {
		
		usersService.deleteUser(111);
		
	}
	@Ignore
	@Test
	public void testAddUsers() {
		
		Users user=new Users();
		user.setEmpId(133);
		user.setPassword("abcd");
		user.setRole("HR");
		user.setEmailId("sonu@gmail.com");
		
		assertEquals("insert failed",true, usersService.addUsers(user));
				
	}
	@Ignore
	@Test
	public void listUsersTestcase() {

		int count = usersService.listAllUsers().size();

	assertEquals("Failed to list the users!", 3, count);

	}
	@Ignore
	@Test
	public void updateUsersTestcase() {
		Users user=new Users();
		user = usersService.listUserById(13);
		//users.setUsersName("HTML");
      user.setEmailId("RAju@gmail.com");
		boolean flag = usersService.updateUsers(user);

		assertEquals("Failed to update the users!", true, flag);

	}

	@Ignore
	@Test
	public void deleteUsersTestcase() {
		Users user=new Users();
		boolean flag = usersService.deleteUser(11);

		assertEquals("Failed to delete the users!", true, flag);

	}

	//@Ignore
	@Test
	public void listUsersbyIdTestcase() {
		Users user=new Users();
		user = usersService.listUserById(133);
		assertEquals("Failed to get the users!", "sonu@gmail.com", user.getEmailId());
	}

	


}
