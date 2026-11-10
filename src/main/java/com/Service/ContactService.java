package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Contact;
import com.Repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository repo;
	
	public List <Contact> getAll()
	{
		return repo.findAll();
	}
	
	public Contact saveContact(Contact c)
	{
		return repo.save(c);
	}
	
	public Contact getById(long id)
	{
		return repo.findById(id).orElse(null);
	}
	
	public Contact updateContact(Contact c, long id)
	{
		Contact exsting=getById(id);
		
		exsting.setEmail(c.getEmail());
		exsting.setSubject(c.getSubject());
		exsting.setName(c.getName());
		
		return repo.save(exsting);
	}
	
	public void deleteContact(long id)
	{
		 repo.deleteById(id);
	}
}
