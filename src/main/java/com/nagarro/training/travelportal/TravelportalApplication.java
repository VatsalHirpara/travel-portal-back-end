package com.nagarro.training.travelportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TravelportalApplication {
	
//	@Autowired
//	UserRepository userRepository; 
//	
//	@PostConstruct
//	public void init() {  
//		List<User> l = new ArrayList<>();
//		User u1 = new User(1,"vatsal","hirpara");u1.setFirstName("vatsal");l.add(u1);
//		userRepository.saveAll(l);  
//	}
//	
	public static void main(String[] args) {
		SpringApplication.run(TravelportalApplication.class, args);
		System.out.println("running!");
	}
}