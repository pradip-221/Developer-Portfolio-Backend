package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.LerningProject;
import com.Service.LearningService;

@RestController
@RequestMapping("/learning")
public class LerningController {

	@Autowired
	LearningService service;
	@GetMapping
	public List <LerningProject> getAll()
	{
		return service.getAll();
	}
	
	@PostMapping
	public LerningProject saveProject(@RequestBody LerningProject p)
	{
		return service.save(p);
	}
	
	@GetMapping("/{id}")
	public LerningProject getById(@PathVariable long id)
	{
		return service.getById(id);
	}
	
	@PutMapping("/{id}")
	public LerningProject updateProject(@RequestBody LerningProject p, @PathVariable long id)
	{
		return service.updateProject(p, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProject(@PathVariable long id)
	{
		 service.deleteProject(id);
		 return "Project deleted succsess";
		 
	}

}
