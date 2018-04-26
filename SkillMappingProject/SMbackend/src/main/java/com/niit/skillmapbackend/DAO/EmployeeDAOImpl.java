package com.niit.skillmapbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.skillmapbackend.entity.Employee;


@Repository("employeeDAO")
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Employee emp) {
		 sessionFactory.getCurrentSession().save(emp);
		return true;
		
	}

	@Override
	public boolean update(Employee emp) {
		sessionFactory.getCurrentSession().update(emp);
         return true;
	}

	@Override
	public Employee searchById(int empId) {
		return (Employee)sessionFactory.getCurrentSession()
				.createQuery("from Employee where empId=" + empId)
				.uniqueResult();
	}

	@Override
	public Employee searchByEmailId(String emailId) {
		return (Employee)sessionFactory.getCurrentSession()
				.createQuery("from Employee where emailId='"+emailId+"'")
				.uniqueResult();
	}

	@Override

	public List<Employee> listAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Employee")
				.list();

	}

	@Override

	public boolean delete(int empId) {
		sessionFactory.getCurrentSession().delete(searchById(empId));	
		return true;

	}

	@Override
	public boolean approveEmployee(Employee emp) {
		try {
			emp.setApproved(true);
			sessionFactory.getCurrentSession().update(emp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
   
	@Override
	public boolean authenticate(int empId, String password,String role) {
		return false;
		
	}

	


	

}
