package com.nagarro.training.travelportal.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.travelportal.model.User;
import com.nagarro.training.travelportal.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class RegistrationResource {

	@Autowired
	UserService userService;

	@PostMapping("/registration")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}