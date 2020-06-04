package com.nagarro.training.travelportal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.training.travelportal.model.User;
import com.nagarro.training.travelportal.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordGenerator passwordGenerator;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	MailSenderService mailSenderService;

	@Override
	@Transactional
	public User addUser(User user) {
		User savedUser = userRepository.save(user);
		String password = passwordGenerator.generateRandomPassword();
		savedUser.setPassword(encoder.encode(password));
		mailSenderService.sendEmail(savedUser.getEmail(), password);
		userRepository.flush();
		return savedUser;
	}

	@Override
	@Transactional
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public ResponseEntity<?> sendPasswordToUserEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		if (user.isPresent()) {
			String password = passwordGenerator.generateRandomPassword();
			System.out.println(user.get().getEmail() + " " + password);
			user.get().setPassword(encoder.encode(password));
			mailSenderService.sendEmail(user.get().getEmail(), password);
			userRepository.flush();
			return new ResponseEntity("Successfully sent!", HttpStatus.OK);
		} else {
			return new ResponseEntity("Please register first", HttpStatus.BAD_REQUEST);
		}
	}

}
