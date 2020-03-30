package com.nt.entity;

public class User {
	private int userId;
	private String username;
	@SuppressWarnings("unused")
	private String password;
	private String role;
	private String userDetail;
	
	public User(int userId, String username, String password, String role, String userDetail) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.userDetail = userDetail;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	public String getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(String userDetail) {
		this.userDetail = userDetail;
	}
}

