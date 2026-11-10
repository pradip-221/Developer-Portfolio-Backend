package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Profile;
import com.Repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository repo;
	
	public List <Profile> getAll()
	{
		return  repo.findAll();
	}
	
	public Profile saveProfile(Profile p)
	{
		return repo.save(p);
	}
	
	public Profile getById(long id)
	{
		return repo.findById(id).orElse(null);
	}
	
	public Profile updateProfile(Profile p, long id)
	{
		Profile exsting=getById(id);
		
		exsting.setEmail(p.getEmail());
		exsting.setFullName(p.getFullName());
		exsting.setGithuburl(p.getGithuburl());
		exsting.setIntroduction(p.getIntroduction());
		exsting.setLinkdinurl(p.getLinkdinurl());
		exsting.setLocation(p.getLocation());
		exsting.setTitle(p.getTitle());
		
		return repo.save(exsting);
}
	
	public void deleteProfile(long id)
	{
		repo.deleteById(id);	
	}
}
