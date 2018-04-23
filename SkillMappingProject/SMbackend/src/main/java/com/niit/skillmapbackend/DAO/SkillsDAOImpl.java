package com.niit.skillmapbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.skillmapbackend.entity.Skills;

public class SkillsDAOImpl implements SkillsDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Skills emp) {
		 sessionFactory.getCurrentSession().save(emp);
		return true;
		
	}

	@Override
	public boolean update(Skills emp) {
		sessionFactory.getCurrentSession().update(emp);
         return true;
	}

	@Override
	public Skills listById(int empId) {
		return (Skills)sessionFactory.getCurrentSession()
				.createQuery("from Skills where empId=" + empId)
				.uniqueResult();
	}


	@Override

	public List<Skills> listAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Skills")
				.list();

	}

	@Override

	public boolean delete(int empId) {
		sessionFactory.getCurrentSession().delete(listById(empId));	
		return true;

	}

	@Override
	public Skills listBySkillName(String skillName) {
		return (Skills)sessionFactory.getCurrentSession()
				.createQuery("from Skills where skillName='"+skillName+"'")
				.uniqueResult();
	}

	

}
