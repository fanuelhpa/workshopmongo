package com.fandev.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandev.workshopmongo.domain.User;
import com.fandev.workshopmongo.domain.repositories.UserRepository;
import com.fandev.workshopmongo.services.exceptions.ResouceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		
		Optional<User> obj = repo.findById(id);
		User user = obj.orElseThrow(() -> new ResouceNotFoundException(id));
		return user;
	}
}
