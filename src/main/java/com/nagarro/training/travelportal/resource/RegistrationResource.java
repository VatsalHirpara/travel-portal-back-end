package com.nagarro.training.travelportal.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.travelportal.model.User;
import com.nagarro.training.travelportal.repository.UserRepository;
import com.nagarro.training.travelportal.service.MailSenderService;
import com.nagarro.training.travelportal.service.PasswordGenerator;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "true")
public class RegistrationResource {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordGenerator passwordGenerator;
	
	@Autowired
	MailSenderService mailSenderService;
	
	@PostMapping("/registration")
	public User addUser(@RequestBody User body) {
		User user = userRepository.save(body);
		user.setPassword(passwordGenerator.generateRandomPassword());
		mailSenderService.sendEmail(user.getEmail(),user.getPassword());
		userRepository.flush();
		return user;
	}
}
