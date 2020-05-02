package com.nagarro.training.travelportal.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.travelportal.model.AuthenticationRequest;
import com.nagarro.training.travelportal.model.AuthenticationResponse;
import com.nagarro.training.travelportal.model.MyUserDetails;
import com.nagarro.training.travelportal.service.MyUserDetailsService;
import com.nagarro.training.travelportal.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "true")
public class AuthenticationResource {
	@Autowired
	private AuthenticationManager authenticationManager;
 
	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception{
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final MyUserDetails myUserDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(myUserDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt,myUserDetails.getId(),200,myUserDetails.getIsAdmin()));
	}	
}
