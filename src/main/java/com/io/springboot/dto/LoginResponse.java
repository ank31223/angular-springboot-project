package com.io.springboot.dto;

public class LoginResponse {

	String token;
	User user;

	public LoginResponse() {
		super();
	}

	public LoginResponse(String token, User user) {
		super();
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
