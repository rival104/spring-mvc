package com.nt.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;

@Component
public class EmpDao {
	@Autowired
	JdbcTemplate template;
	
	public boolean add(Employee e) {
		Object args[] = {e.getId(), e.getName(),e.getSal()};
		try {
			int result = template.update("INSERT INTO emp values(?, ?, ?)", args);
			if(result == 1) return true;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		return false;
	}
}
