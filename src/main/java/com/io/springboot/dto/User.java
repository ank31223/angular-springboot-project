package com.io.springboot.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	private String id;
	private String username;
	private String fullName;
	private int age;
	private String city;
	private String state;
	private String password;
	private String role="user";
	
	public User() {
		super();
	}

	

	
	public User(String id, String username, String fullName, int age, String city, String state, String password,
			String role) {
		super();
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.age = age;
		this.city = city;
		this.state = state;
		this.password = password;
		this.role = role;
	}




	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	


}
