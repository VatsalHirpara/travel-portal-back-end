package com.nagarro.training.travelportal.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.nagarro.training.travelportal.model.User;

public interface UserService {

	User addUser(User user);

	Optional<User> getUserById(int id);

	ResponseEntity<?> sendPasswordToUserEmail(String email);

}