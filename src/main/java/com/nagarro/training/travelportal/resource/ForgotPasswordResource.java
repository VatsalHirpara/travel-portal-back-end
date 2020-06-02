package com.nagarro.training.travelportal.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.travelportal.dto.ForgotPassword;
import com.nagarro.training.travelportal.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ForgotPasswordResource {

	@Autowired
	UserService userService;

	@PostMapping("/forgot-password")
	public ResponseEntity<?> sendPasswordToUser(@RequestBody ForgotPassword body) {
		return userService.sendPasswordToUserEmail(body.getEmail());
	}
}
