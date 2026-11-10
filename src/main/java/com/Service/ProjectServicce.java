package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Project;
import com.Repository.ProjectRepository;

@Service
public class ProjectServicce {

	@Autowired
	ProjectRepository repo;
	
	
	public List <Project> getAll()
	{
		return repo.findAll();
	}
	
	public Project saveProject(Project p)
	{
		return repo.save(p);
	}
	
	public Project getByid(long id)
	{
		return repo.findById(id).orElse(null);
	}
	
	public Project updateProject(Project p, long id)
	{
		Project exsting=getByid(id);
		
		exsting.setCategory(p.getCategory());
		exsting.setDescription(p.getDescription());
		exsting.setGithubUrl(p.getGithubUrl());
		exsting.setLiveUrl(p.getLiveUrl());
		exsting.setTagline(p.getTagline());
		exsting.setTechnologies(p.getTechnologies());
		
		return repo.save(exsting);
	}
	
	public void deleteProject(long id)
	{
		repo.deleteById(id);
	}
}
