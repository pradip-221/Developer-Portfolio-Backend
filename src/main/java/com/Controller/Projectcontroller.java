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

import com.Entity.Project;
import com.Service.ProjectServicce;

@RestController
@RequestMapping("/projects")
public class Projectcontroller {

	@Autowired
	ProjectServicce service;
	
	@GetMapping
	public List <Project> getAll()
	{
		return service.getAll();
	}
	
	@PostMapping
	public Project saveProject(@RequestBody Project p)
	{
		return service.saveProject(p);
	}
	
	@GetMapping("/{id}")
	public Project getByid(@PathVariable long id)
	{
		return service.getByid(id);
	}
	
	@PutMapping("/{id}")
	public Project updateProject(@RequestBody Project p , @PathVariable long id)
	{
		return service.updateProject(p, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProject(@PathVariable long id)
	{
		service.deleteProject(id);
		return "Project deleted succsefully";
	}
}
