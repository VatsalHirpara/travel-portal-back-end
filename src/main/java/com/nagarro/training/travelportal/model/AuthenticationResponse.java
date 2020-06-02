package com.nagarro.training.travelportal.model;

public class AuthenticationResponse {
	private final String jwt;
	private final int userId;
	private final boolean isAdmin;
	private final int status;

	public AuthenticationResponse(String jwt, int userId, int status, boolean isAdmin) {
		this.jwt = jwt;
		this.userId = userId;
		this.status = status;
		this.isAdmin = isAdmin;
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

	public boolean isAdmin() {
		return isAdmin;
	}
}
