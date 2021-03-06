package com.niit.SkillMappingBackEnd.TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.SkillMappingBackEnd.Entity.User;
import com.niit.SkillMappingBackEnd.Repository.UserDAOImpl;
import com.niit.SkillMappingBackEnd.utility.Validation;

public class UserTestCase {
	private static UserDAOImpl userDao = new UserDAOImpl();
	private User user1 = new User();

	@BeforeClass

	public static void init() {
		userDao = new UserDAOImpl();

	}

	@Ignore
	@Test 
	   public void testisFieldEmpty()
	   {
		   boolean flag;
		   Validation valid=new Validation();
			 flag=valid.isFieldEmpty("");
			assertEquals("Field is empty!", false, flag);
		
		   
	   }
@Ignore
   @Test 
   public void testEmailId()
   {
	   boolean flag;;
	   Validation valid=new Validation();
		 flag=valid.validateEmail("xyz@gmail.com");
		assertEquals("Invalid Email!", true, flag);
	
	   
   }
   @Test 
   public void testInvalidEmailId()
   {
	   boolean flag;
	   Validation valid=new Validation();
		 flag=valid.validateEmail("xyzmail.com");
		assertEquals("Invalid Email!", false, flag);
	
	   
   }
  // @Ignore
	@Test
	public void testInsertUser() {
		boolean flag;
		user1 = new User();

		user1.setEmpId(116);
		user1.setName("suresh");
		user1.setEmailId("suresh@gmail.com");
		
		user1.setRole("Employer");
		user1.setPassword("abcd");
		//user1.setIBU("CEB");
		 flag = userDao.insertUser(user1);
		assertEquals("Failed to insert userdetails!", true, flag);
		user1 = new User();

		user1.setEmpId(1114);
		user1.setName("ajit");
		user1.setEmailId("prakash@gmail.com");
	
		user1.setRole("Employer");
		user1.setPassword("xyz");
		//user1.setIBU("CEB");
		 flag = userDao.insertUser(user1);
		assertEquals("Failed to insert userdetails!", true, flag);
	}

	 @Ignore

	@Test
	public void testgetUserById() {
		user1 = userDao.getUserById(117);
		assertEquals("Failed to get User !", "seema", user1.getName());
	}

 @Ignore

	@Test
	public void testUpdateUser() {

		user1 = userDao.getUserById(118);

		user1.setName("hhh");

		boolean flag = userDao.updateUser(user1);
		assertEquals("Failed to update userdetails!", true, flag);
	}

	@Ignore
	@Test
	public void testDeleteUser() {

		boolean flag = userDao.deleteUser(117);
		assertEquals("Failed to delete userdetails!", true, flag);
	}
	@Ignore
	@Test
	public void testAuthorizeUser()
	{
		String role=userDao.authorizeUser(112,"sonu123");
		assertEquals("Failed to authorize userdetails!", "HR", role);
		String role1=userDao.authorizeUser(112,"sonu");
		assertEquals("Failed to authorize userdetails!", "Employee", role1);
				
	}

}
