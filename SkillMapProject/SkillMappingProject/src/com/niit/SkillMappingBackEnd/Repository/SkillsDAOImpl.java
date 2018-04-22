package com.niit.SkillMappingBackEnd.Repository;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.SkillMappingBackEnd.Entity.Profile;
import com.niit.SkillMappingBackEnd.Entity.Skills;
import com.niit.SkillMappingBackEnd.Entity.Skills;
import com.niit.SkillMappingBackEnd.Entity.Skills;
import com.niit.SkillMappingBackEnd.utility.DbConnect;

public class SkillsDAOImpl {
	static Connection con = null;

	public SkillsDAOImpl() {
		con = DbConnect.connect();
	}
	//inserting skills details
	public boolean insertSkills(Skills skills) {
				try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO skills VALUES (?,?,?,?)");
		ps.setInt(2,skills.getSkillId());
			ps.setInt(1, skills.getProfileId());
			ps.setString(3, skills.getSkillName());
			ps.setInt(4, skills.getExperience());
			
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("skills details  inserted successfully");

				return true;

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
//updating details
	public boolean updateSkills(Skills skills) {
	
		int rowsUpdated = 0;

		try {
			PreparedStatement ps = con.prepareStatement("UPDATE Skills SET experience=? WHERE empId=?");
		
			ps.setInt(1, skills.getExperience());
			ps.setInt(2, skills.getEmpId());
			

			rowsUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if (rowsUpdated > 0) {
			System.out.println("An existing skills was updated successfully!");
			return true;

		}
		return false;	
		}

//Deleting skills by Id
	public boolean deleteSkills(int id) {

		int rowsUpdated = 0;
		try {

			PreparedStatement ps = con.prepareStatement("delete from skills where empId=?");
			ps.setInt(1, id);
			rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("employee details  deleted successfully");

				return true;

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;

	}
	
	public Skills getSkillsByCity(String string) {
		Skills skills = new Skills();

		try {

			PreparedStatement ps = con.prepareStatement("select * from skills where cityName=?");
			ps.setString(1, string);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				skills.setEmpId(rs.getInt(1));
				
				skills.setContactNo(rs.getString(3));
				skills.setSupervisorName(rs.getString(5));
				skills.setBusinessUnitName(rs.getString(6));
				//skills.setSupervisorName(rs.getString(7));

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return skills;
	}

	public static List<Skills> listProfilesBySkillName(String skill){  
        List<Skills> list=new ArrayList<Skills>();  
          
        try{  
            
            PreparedStatement ps=con.prepareStatement("select profile.empId,profile.contactNo, profile.supervisorName,skills.experience, profile.businessUnitName, profile.cityName from skills inner join profile on skills.profileId = profile.profileId where skillName=? and approved=?");  
            ps.setString(1, skill);
            ps.setString(2, "true");
            ResultSet rs=ps.executeQuery();  
           
            while(rs.next()){  
                Skills skills=new Skills();  
                skills.setEmpId(rs.getInt(1));
                skills.setContactNo(rs.getString(2));
				skills.setSupervisorName(rs.getString(3));
				
				skills.setExperience(rs.getInt(4));
				
				
				
				skills.setBusinessUnitName(rs.getString(5));  
				skills.setCityName(rs.getString(6));
                list.add(skills);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
	
}  



