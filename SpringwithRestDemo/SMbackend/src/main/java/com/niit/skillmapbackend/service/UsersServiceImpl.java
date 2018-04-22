package com.niit.skillmapbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.skillmapbackend.DAO.UsersDAO;
import com.niit.skillmapbackend.entity.Users;
@Service
public class UsersServiceImpl implements UsersService {
  @Autowired
  private UsersDAO usersDAO;
	public boolean addUsers(Users user) {
		if(usersDAO.listById(user.getEmpId())!=null) {
			return false;
		}
		else {
			usersDAO.add(user);
			return true;
		}

	}

	public boolean updateUsers(Users user) {
		if(usersDAO.listById(user.getEmpId())!=null) {	
			usersDAO.update(user);
			return true;
		}
		else {
			return false;
		}

	}

	public Users listUserById(int empId) {
		return usersDAO.listById(empId);

	}

	public List<Users> listAllUsers() {
		return usersDAO.listAll();

	}

	public boolean deleteUser(int empId) {
		if(usersDAO.listById(empId)!=null) {	
			usersDAO.delete(empId);
			return true;
		}
		else {
			return false;
		}

	
	}

	public Users listUserByEmailId(String email) {
		
		return usersDAO.listByEmailId(email);
	}

	

}
