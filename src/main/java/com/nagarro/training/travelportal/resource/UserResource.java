package com.nagarro.training.travelportal.resource;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.travelportal.model.User;
import com.nagarro.training.travelportal.repository.UserRepository;
import com.nagarro.training.travelportal.service.MailSenderService;
import com.nagarro.training.travelportal.service.PasswordGenerator;

@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "true")
@RestController
public class UserResource {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordGenerator passwordGenerator;
	
	@Autowired
	MailSenderService mailSenderService;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserByUd(@PathVariable(value = "id") int id){
		return userRepository.findById(id);
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User body) {
		User user = userRepository.save(body);
		user.setPassword(passwordGenerator.generateRandomPassword());
		mailSenderService.sendEmail(user.getEmail(),user.getPassword());
		userRepository.flush();
		return user;
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable("id") Integer id,@RequestBody User user){
		user.setId(id);
		user.setPassword(passwordGenerator.generateRandomPassword());
		return userRepository.saveAndFlush(user);
	}
}
