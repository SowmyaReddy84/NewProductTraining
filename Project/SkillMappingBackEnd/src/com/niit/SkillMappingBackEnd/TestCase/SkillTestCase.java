package com.niit.SkillMappingBackEnd.TestCase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.SkillMappingBackEnd.Entity.Skills;
import com.niit.SkillMappingBackEnd.Repository.SkillsDAOImpl;

public class SkillTestCase {

	private static SkillsDAOImpl skillsDao = new SkillsDAOImpl();
	private Skills skills1 = new Skills();

	@BeforeClass

	public static void init() {
		skillsDao = new SkillsDAOImpl();

	}

	@Ignore

	@Test
	public void testInsertSkills() {
		boolean flag;
		skills1 = new Skills();

		
	
        skills1.setProfileId(1);
		skills1.setExperience(20);
		skills1.setSkillName("jsp");
	
		 flag = skillsDao.insertSkills(skills1);
		assertEquals("Failed to insert skillsdetails!", true, flag);
	}


@Ignore

@Test
public void testUpdateSkill() {
	skills1 = new Skills();

	skills1 = skillsDao.getSkillsByCity("Banglore");

	skills1.setCityName("manglore");

	boolean flag = skillsDao.updateSkills(skills1);
	assertEquals("Failed to update skillsdetails!", true, flag);
}
@Ignore
@Test
public void testDeleteSkill() {

	boolean flag = skillsDao.deleteSkills(11);
	assertEquals("Failed to delete skillsdetails!", true, flag);
}
//@Ignore
@Test
public void listSkillTestcase() {
	int count = skillsDao.listProfilesBySkillName("java").size();
	assertEquals("Failed to list profiledetails!", 2, count);
}
}


