package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Profile;
import com.Service.ProfileService;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/profiles")
public class ProfileController {

	@Autowired
	ProfileService service;
	
	@GetMapping
	public List <Profile> getAll()
	{
		return service.getAll();
	}
	@PostMapping
	public Profile saveProfile(@RequestBody Profile p)
	{
		return service.saveProfile(p);
	}
	@GetMapping("/{id}")
	public Profile getById(@PathVariable long id)
	{
		return service.getById(id);
	}
	@PutMapping("/{id}")
	public Profile updateProfile(@RequestBody Profile p , @PathVariable long id)
	{
		return service.updateProfile(p, id);
	}
	@DeleteMapping("/{id}")
	public String deleteProfile(@PathVariable long  id)
	{
		 service.deleteProfile(id);
		 return "Profile deleted succsess";
	}
	
}
