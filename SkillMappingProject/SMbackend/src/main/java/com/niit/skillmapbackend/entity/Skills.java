package com.niit.skillmapbackend.entity;

import java.sql.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Skills {
	int empId;
	private String skillName;
	private int experience;
	int skillId;
	
	/*@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="empId", nullable = false, updatable = false, insertable = false)*/
	private Employee employee;
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}


}
