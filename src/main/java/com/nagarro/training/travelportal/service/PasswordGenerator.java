package com.nagarro.training.travelportal.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class PasswordGenerator {
	
	/**
	 * 	generates random alphanumeric secure password of length 8
	 * 
	 * @return randomly generated secure password as a String
	 */
	public String generateRandomPassword()
	{
		SecureRandom random = new SecureRandom();
		return random.ints(48, 122 + 1)
				.filter(i -> Character.isAlphabetic(i) || Character.isDigit(i))
				.limit(8)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint,
						StringBuilder::append)
				.toString();
	}
}
