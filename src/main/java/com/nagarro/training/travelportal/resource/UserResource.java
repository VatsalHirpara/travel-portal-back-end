package com.nagarro.training.travelportal.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.travelportal.model.User;
import com.nagarro.training.travelportal.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class UserResource {

	@Autowired
	UserService userService;

	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable(value = "id") int id) {
		return userService.getUserById(id);
	}
}
