package com.niit.SkillMappingBackEnd.TestCase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.SkillMappingBackEnd.Entity.Profile;
import com.niit.SkillMappingBackEnd.Repository.ProfileDAOImpl;

public class ProfileTestCase {

	private static ProfileDAOImpl profileDao = new ProfileDAOImpl();
	private Profile profile1 = new Profile();

	@BeforeClass

	public static void init() {
		profileDao = new ProfileDAOImpl();

	}

	@Ignore

	@Test
	public void testInsertProfile() {
		boolean flag;
		profile1 = new Profile();

		
	

		profile1.setEmpId(1111);
		profile1.setBusinessUnitName("CEB");
		profile1.setCityName("Banglore");
		profile1.setQualification("BE");
		profile1.setSupervisorName("neelam");
		profile1.setContactNo("890754333");
	
		 flag = profileDao.insertProfile(profile1);
		assertEquals("Failed to insert profiledetails!", true, flag);
	}

	 @Ignore

	@Test
	public void testgetProfileById() {
		profile1 = profileDao.getProfileById(1111);
		assertEquals("Failed to get Profile !", "Banglore", profile1.getCityName());
	}
	@Ignore
	@Test
	public void testgetProfileByCity() {
		profile1 = profileDao.getProfileByCity("Banglore");
		assertEquals("Failed to get Profile !", "harishita", profile1.getSupervisorName());
	}
	
	
	
 @Ignore

	@Test
	public void testUpdateProfile() {

		profile1 = profileDao.getProfileById(1111);

		profile1.setCityName("manglore");

		boolean flag = profileDao.updateProfile(profile1);
		assertEquals("Failed to update profiledetails!", true, flag);
	}

	@Ignore
	@Test
	public void testDeleteProfile() {

		boolean flag = profileDao.deleteProfile(117);
		assertEquals("Failed to delete profiledetails!", true, flag);
	}
	//@Ignore
	@Test
	public void listProfileTestcase() {

		int count = profileDao.getAllProfiles().size();

		assertEquals("Failed to list the profiles!", 1, count);

	}
}
