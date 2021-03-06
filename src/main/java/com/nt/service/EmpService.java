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

	public Employee getRecordsByName(String name, int userId) {
		return dao.getRecordsByName(name, userId);
	}

	public User getUser(String username, String password) {
		return dao.getUser(username, password);
	}

	public List<String> getEmployeeNames(int userId) {
		return dao.getEmployeeNames(userId);
	}

	public List<Employee> getAllRecordByUser(int userId) {
		return dao.getAllRecordByUser(userId);
	}
}
