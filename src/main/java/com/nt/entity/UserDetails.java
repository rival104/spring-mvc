package com.nt.entity;

public class UserDetails {
	private int userId;
	private String fullName;
	private String address;
	private String position;
	public UserDetails(int userId, String fullName, String address, String position) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.address = address;
		this.position = position;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
