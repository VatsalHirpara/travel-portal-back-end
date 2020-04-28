package com.nagarro.training.travelportal.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.travelportal.model.User;
import com.nagarro.training.travelportal.repository.UserRepository;

@RestController
public class UserResource {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserByUd(@PathVariable(value = "id") int id){
		return userRepository.findById(id);
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userRepository.saveAndFlush(user);
	}
}
