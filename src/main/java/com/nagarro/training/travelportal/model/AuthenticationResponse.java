package com.nagarro.training.travelportal.model;

public class AuthenticationResponse {
	private final String jwt;
	private final int userId;
	private final int status;
	

	public AuthenticationResponse(String jwt,int userId,int status) {
        this.jwt = jwt;
        this.userId=userId;
        this.status=status;
    }

    public String getJwt() {
        return this.jwt;
    }
    public int getUserId() {
    	return this.userId;
    }
    public int getStatus() {
    	return this.status;
    }
}
