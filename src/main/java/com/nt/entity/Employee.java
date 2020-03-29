package com.nt.entity;

public class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private int sal;
	private String empType;
	private String designation;
	private String dob;
	private String phone;
	private String email;
	private String gender;
	private String role;
	private String techStack;
	private int creatorId;
	private static final String[] properties = {
			"id",
			"name",
			"salary",
			"emplyoee type",
			"designation",
			"DOB",
			"phone",
			"email",
			"gender",
			"role",
			"tech stack",
			"creator Id"
			};
	
	public Employee(int id, String name, int sal, String empType, String designation, String dob, String phone,
			String email, String gender, String role, String techStack, int creatorId) {
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.empType = empType;
		this.designation = designation;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.role = role;
		this.techStack = techStack;
		this.creatorId = creatorId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Employee(int id, String name, int sal, int creatorId) {
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.creatorId = creatorId;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}
	
	
	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTechStack() {
		return techStack;
	}

	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	
	public String[] getProperties() {
		return properties;
	}

	@Override
	public int compareTo(Employee e) {
		if(this.id > e.id) return -1;
		if(this.id < e.id) return 1;
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		Employee emp = (Employee) o;
		if(this.id == emp.id) {
			return true;
		}
		return false;
	}
}
