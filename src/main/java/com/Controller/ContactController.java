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

import com.Entity.Contact;
import com.Service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	ContactService service;
	
	@GetMapping
	public List <Contact> getAll()
	{
		return service.getAll();
	}
	
	@PostMapping
	public Contact saveCon(@RequestBody Contact c)
	{
		return service.saveContact(c);
	}
	
	@GetMapping("/{id}")
	public Contact getById(@PathVariable long id)
	{
		return service.getById(id);
	}
	@PutMapping("/{id}")
	public Contact updateContact(@RequestBody Contact c , @PathVariable long id)
	{
		return service.updateContact(c, id);
	}
	@DeleteMapping("/{id}")
	public String deleteContact(@PathVariable long id)
	{
		 service.deleteContact(id);
		 return "Contact deleted succsess";
		
	}
}
