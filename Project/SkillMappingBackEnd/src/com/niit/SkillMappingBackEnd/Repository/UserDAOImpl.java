package com.niit.SkillMappingBackEnd.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.SkillMappingBackEnd.Entity.User;
import com.niit.SkillMappingBackEnd.Entity.User;
import com.niit.SkillMappingBackEnd.utility.DbConnect;

public class UserDAOImpl {
	static Connection con = null;

	public UserDAOImpl() {
		con = DbConnect.connect();
	}
	//inserting user details
	public boolean insertUser(User user) {
		User user1 = new User();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?)");
			ps.setInt(1, user.getEmpId());
			ps.setString(2, user.getName());

			ps.setString(3, user.getEmailId());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getRole());

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("employee details  inserted successful");

				return true;

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	//updating user details
	public boolean updateUser(User user) {
		// User user1=new User();
		int rowsUpdated = 0;

		try {
			PreparedStatement ps = con.prepareStatement("UPDATE Users SET name=? WHERE empId=?");
			// user1 = getUserById(uId);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getEmpId());

			// ps.setString(4, user1.getEmailId());

			rowsUpdated = ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (rowsUpdated > 0) {
			System.out.println("An existing user was updated successfully!");
			return true;

		}
		return false;
	}
	//Retrieving user by Id
	public User getUserById(int uid) {
		User user = new User();

		try {

			PreparedStatement ps = con.prepareStatement("select * from users where empId=?");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setEmpId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return user;
	}
	//Deleting user by Id
	public boolean deleteUser(int id) {

		int rowsUpdated = 0;
		try {

			PreparedStatement ps = con.prepareStatement("delete from users where empId=?");
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
	public boolean authorizeUser(int empId, String pwd)
	{
		boolean flag=false;
		User u = new User();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT* from users where empId=? and password=?");
					ps.setInt(1, empId);
			ps.setString(2, pwd);
			
			ResultSet rs =ps.executeQuery();
			flag = rs.next();
			
			
		        if(empId==u.getEmpId() && pwd.equals(u.getPassword())){  
		            return true;  
		        }else {  
		            return false;  
		        }  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return flag;

	}
	public static List<User> getAllUsers(){  
		List<User> list=new ArrayList<User>();  

		try{  

			PreparedStatement ps=con.prepareStatement("select * from user");  
			ResultSet rs=ps.executeQuery();  
			while(rs.next()){  
				User user=new User();  


				user.setEmpId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmailId(rs.getString(3));
				user.setPassword(rs.getString(4));

				user.setRole(rs.getString(5));

				list.add(user);  
			}  
			con.close();  
		}catch(Exception e){e.printStackTrace();}  

		return list;  
	}  
}
