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

import com.Entity.Skill;
import com.Service.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {

	
	@Autowired
	SkillService service;
	
	@GetMapping
	public List <Skill> getBySkills()
	{
		return service.getAllSkillss();
	}
	
	@PostMapping
	public Skill saveSkills(@RequestBody Skill s)
	{
		return service.saveSkillss(s);
	}
	
	@GetMapping("/{id}")
	public Skill getById(@PathVariable long id)
	{
		return service.getById(id);
	}
	
	@PutMapping("/{id}")
	public Skill updateSkill(@RequestBody Skill s, @PathVariable long id)
	{
		return service.updateSkilsss(s, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteSkills(@PathVariable long id)
	{
		 service.deleteSkill(id);
		 return "Skill deleted succsesss";
	}	 
}
