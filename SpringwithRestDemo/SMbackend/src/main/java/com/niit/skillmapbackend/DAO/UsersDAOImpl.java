package com.niit.skillmapbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.skillmapbackend.entity.Users;
@Repository("usersDAO")
@Transactional
public class UsersDAOImpl implements UsersDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public boolean add(Users user) {
		 sessionFactory.getCurrentSession().save(user);
		return true;
		
	}

	public boolean update(Users user) {
		sessionFactory.getCurrentSession().update(user);
         return true;
	}

	public Users listById(int empId) {
		return (Users)sessionFactory.getCurrentSession()
				.createQuery("from Users where empId=" + empId)
				.uniqueResult();
	}
	public Users listByEmailId(String emailId) {
		return (Users)sessionFactory.getCurrentSession()
				.createQuery("from Users where emailId='"+emailId+"'")
				.uniqueResult();
	}

	public List<Users> listAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Users")
				.list();

	}

	public boolean delete(int empId) {
		sessionFactory.getCurrentSession().delete(listById(empId));	
		return true;

	}

	

}
