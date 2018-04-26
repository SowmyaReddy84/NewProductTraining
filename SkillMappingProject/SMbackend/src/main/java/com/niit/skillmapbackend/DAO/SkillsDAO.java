package com.niit.skillmapbackend.DAO;

import java.util.List;

import com.niit.skillmapbackend.entity.Skills;

public interface SkillsDAO {
public boolean add(Skills skill);
	
	public boolean update(Skills skill);

	//public Skills listById(int skillId);
	
	public List<Skills> searchBySkillName(String skillName);
	
	public List<Skills> listAll();

	public boolean delete(int skillId);


}
