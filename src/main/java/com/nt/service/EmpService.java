package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Dao.EmpDao;
import com.nt.entity.*;

@Service
public class EmpService {
	@Autowired
	EmpDao dao;
	
	
	
	public boolean add(Employee e) {
		return dao.add(e);
	}
	
	public boolean update(Employee e) {
		return dao.update(e);
	}
	
	public boolean delete(Employee e) {
		return dao.delete(e);
	}

	public Employee getRecordById(int id) {
		return dao.getRecordById(id);
	}
	
	public List<Employee> getAllRecord() {
		return dao.getAllRecord();
	}

	public Employee getRecordByName(String name) {
		return dao.getRecordByName(name);
	}

	public User getUser(String username, String password) {
		return dao.getUser(username, password);
	}

	public List<String> getEmployeeNames() {
		return dao.getEmployeeNames();
	}

	public UserDetails getUserDetailsById(int id) {
		return dao.getUserDetailsById(id);
	}
}
