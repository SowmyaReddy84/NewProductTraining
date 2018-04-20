package com.niit.SkillMappingBackEnd.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.SkillMappingBackEnd.Entity.Profile;
import com.niit.SkillMappingBackEnd.Entity.Profile;
import com.niit.SkillMappingBackEnd.utility.DbConnect;

public class ProfileDAOImpl {
	static Connection con = null;

	public ProfileDAOImpl() {
		con = DbConnect.connect();
	}
	//inserting profile details
	public boolean insertProfile(Profile profile) {
		Profile profile1 = new Profile();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO profile VALUES (?,?,?,?,?,?,?,?)");
			ps.setInt(2, profile.getEmpId());
			ps.setInt(1, profile.getProfileId());
			ps.setString(3, profile.getContactNo());
			ps.setString(4, profile.getQualification());
			ps.setString(5, profile.getSupervisorName());
			ps.setString(6, profile.getBusinessUnitName());
			ps.setString(7, profile.getCityName());
            ps.setString(8, "false");
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("profile details  inserted successful");

				return true;

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
//updating profile details
	public boolean updateProfile(Profile profile) {
	
		int rowsUpdated = 0;

		try {
			PreparedStatement ps = con.prepareStatement("UPDATE Profile SET cityName=? WHERE empId=?");
		
			ps.setString(1, profile.getCityName());
			ps.setInt(2, profile.getEmpId());
			
		

			rowsUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if (rowsUpdated > 0) {
			System.out.println("An existing profile was updated successfully!");
			return true;

		}
		return false;
	}
//Retrieving profile by Id
	public Profile getProfileById(int eid) {
		Profile profile = new Profile();

		try {

			PreparedStatement ps = con.prepareStatement("select * from profile where empId=?");
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				//profile.setEmpId(rs.getInt(1));
				
				profile.setCityName(rs.getString(7));
				//profile.setSupervisorName(rs.getString(7));

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return profile;
	}
//Deleting profile by Id
	public boolean deleteProfile(int id) {

		int rowsUpdated = 0;
		try {

			PreparedStatement ps = con.prepareStatement("delete from profile where empId=?");
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
	
	public Profile getProfileByCity(String cityName) {
		Profile profile = new Profile();

		try {

			PreparedStatement ps = con.prepareStatement("select * from profile where cityName=?");
			ps.setString(1, cityName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				profile.setEmpId(rs.getInt(1));
				
				profile.setContactNo(rs.getString(3));
				profile.setSupervisorName(rs.getString(5));
				profile.setBusinessUnitName(rs.getString(6));
				//profile.setSupervisorName(rs.getString(7));

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return profile;
	}

	public static List<Profile> getAllProfiles(String value){  
        List<Profile> list=new ArrayList<Profile>();  
          
        try{  
            
            PreparedStatement ps=con.prepareStatement("select * from profile where approved=?"); 
            ps.setString(1,value);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Profile profile=new Profile();  
                profile.setEmpId(rs.getInt(1));
                
				profile.setContactNo(rs.getString(3));
				profile.setQualification(rs.getString(4));
				profile.setSupervisorName(rs.getString(5));
				profile.setBusinessUnitName(rs.getString(6));  
				profile.setCityName(rs.getString(7));
                list.add(profile);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  


