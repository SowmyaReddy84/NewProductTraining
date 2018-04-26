package com.niit.skillmapbackend.entity;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	private int empId;
	
	private String name;
	private String emailId;
	private String password;
	private String role;
	private String contactNo;
	private String qualification;
	private String supervisorName;
	private String cityName;
	private String businessUnitName;
	private boolean isApproved;
	private String numOfStudentsTrained;
	private String numOfstudentsPlaced;
	private String placedCompanyName;
	
		
	/* @OneToMany(targetEntity = Skills.class, fetch = FetchType.EAGER, mappedBy = "skill")
		private Set<Skills> skills = new HashSet<Skills>(0);
*/

	
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getBusinessUnitName() {
		return businessUnitName;
	}
	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
	}
	
	public String getNumOfStudentsTrained() {
		return numOfStudentsTrained;
	}
	public void setNumOfStudentsTrained(String numOfStudentsTrained) {
		this.numOfStudentsTrained = numOfStudentsTrained;
	}
	public String getNumOfstudentsPlaced() {
		return numOfstudentsPlaced;
	}
	public void setNumOfstudentsPlaced(String numOfstudentsPlaced) {
		this.numOfstudentsPlaced = numOfstudentsPlaced;
	}
	public String getPlacedCompanyName() {
		return placedCompanyName;
	}
	public void setPlacedCompanyName(String placedCompanyName) {
		this.placedCompanyName = placedCompanyName;
	}
	/*public Set<Skills> getSkills() {
		return skills;
	}
	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}*/
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}

