package com.niit.skillmapbackend.DAO;

import java.util.List;

import com.niit.skillmapbackend.entity.Users;

public interface UsersDAO {
	public boolean add(Users user);
	
	public boolean update(Users user);

	public Users listById(int empId);
	
	public Users listByEmailId(String emailId);
	
	public List<Users> listAll();

	public boolean delete(int empId);

}
