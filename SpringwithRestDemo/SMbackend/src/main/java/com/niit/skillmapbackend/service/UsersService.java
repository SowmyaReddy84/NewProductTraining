package com.niit.skillmapbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.skillmapbackend.entity.Users;

public interface UsersService {
public boolean addUsers(Users user);
	
	public boolean updateUsers(Users user);

	public Users listUserById(int empId);

	public List<Users> listAllUsers();

	public boolean deleteUser(int empId);

	public Users listUserByEmailId(String string);

	
}
