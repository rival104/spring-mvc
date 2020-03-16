package com.nt.entity;

public class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private int sal;

	public Employee(int id, String name, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
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
	
	@Override
	public int compareTo(Employee e) {
		if(this.id > e.id) return -1;
		if(this.id < e.id) return 1;
		return 0;
	}
	
	@Override
	public String toString() {
		return "id: " + id + ", name: " + name + ", sal:" + sal;
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
