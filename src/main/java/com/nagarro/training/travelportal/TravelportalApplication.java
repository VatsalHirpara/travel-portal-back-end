package com.nagarro.training.travelportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class TravelportalApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TravelportalApplication.class, args);
		System.out.println("App is running!");
	}
}