package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.LerningProject;
import com.Repository.LerningRepository;

@Service
public class LearningService {

	@Autowired
	LerningRepository repo;
	
	public List <LerningProject> getAll()
	{
		return repo.findAll();
	}
	
	public LerningProject save(LerningProject p)
	{
		return repo.save(p);
	}
	
	public LerningProject getById(long id)
	{
		return repo.findById(id).orElse(null);
	}
	
	public LerningProject updateProject(LerningProject p , long id)
	{
		LerningProject exsting=getById(id);
		
		exsting.setCategory(p.getCategory());
		exsting.setDescription(p.getDescription());
		exsting.setRelatedProject(p.getRelatedProject());
		exsting.setStatus(p.getStatus());
		exsting.setTopic(p.getTopic());
		
		return repo.save(exsting);
	}
	
	public void deleteProject(long id)
	{
		repo.deleteById(id);
	}
}
