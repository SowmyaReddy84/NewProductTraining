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
	public Employee listById(int empId) {
		return (Employee)sessionFactory.getCurrentSession()
				.createQuery("from Employee where empId=" + empId)
				.uniqueResult();
	}

	@Override
	public Employee listByEmailId(String emailId) {
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
		sessionFactory.getCurrentSession().delete(listById(empId));	
		return true;

	}

	


	

}
