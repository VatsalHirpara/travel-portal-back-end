package com.nagarro.training.travelportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String email, String password) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);

		String mailBody = "You have requested your user name and password for the your access to the Nagarro Travel Portal:\n"
				+ "Username: " + email + "\n" + "Password: " + password + "\n"
				+ "Please contact the Travel team if you have any questions.\n \n" + "Thank you,\n"
				+ "Nagarro Travel Team.";
		msg.setSubject("Nagarro Travel Portal Information");
		msg.setText(mailBody);
		javaMailSender.send(msg);
	}
}
