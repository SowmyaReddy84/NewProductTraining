package com.niit.skillmapbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.skillmapbackend.entity.Skills;

public class SkillsDAOImpl implements SkillsDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Skills skill) {
		 sessionFactory.getCurrentSession().save(skill);
		return true;
		
	}

	@Override
	public boolean update(Skills skill) {
		sessionFactory.getCurrentSession().update(skill);
         return true;
	}

	

	@Override

	public List<Skills> listAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Skills")
				.list();

	}

	@Override

	public boolean delete(int empId) {
		sessionFactory.getCurrentSession().delete(empId);	
		return true;

	}

	@Override
	public List<Skills> searchBySkillName(String skillName) {
		return sessionFactory.getCurrentSession().createQuery("from Skills where skillName='"+skillName+"'").list();
	}

	

}
