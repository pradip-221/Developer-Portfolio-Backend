package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Skill;
import com.Repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	SkillRepository repo;
	
	public List <Skill> getAllSkillss()
	{
		return repo.findAll();
	}
	
	public Skill saveSkillss(Skill s)
	{
		return repo.save(s);
	}
	
	public Skill getById(long id)
	{
		return repo.findById(id).orElse(null);
	}
	
	public Skill updateSkilsss(Skill s, long id)
	{
		Skill exsting=getById(id);
		
		exsting.setCategory(s.getCategory());
		exsting.setDescription(s.getDescription());
		exsting.setName(s.getName());
		exsting.setProficiencyLevel(s.getProficiencyLevel());
		
		return repo.save(exsting);
	}
	
	public void deleteSkill(long id)
	{
		repo.deleteById(id);
	}
}
