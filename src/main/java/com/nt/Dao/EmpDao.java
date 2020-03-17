package com.nt.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;

@Component
public class EmpDao {
	@Autowired
	JdbcTemplate template;
	
	public boolean add(Employee e) {
		Object[] args = {e.getId(), e.getName(),e.getSal()};
		try {
			int result = template.update("INSERT INTO emp values(?, ?, ?)", args);
			if(result == 1) return true;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Employee e) {
		Object[] args = {e.getSal(), e.getId()};
		try {
			int result = template.update("UPDATE emp SET esal = ? WHERE eid= ?", args);
			if(result == 1) return true;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(Employee e) {
		Object[] args = {e.getId()};
		try {
			int result = template.update("DELETE FROM emp WHERE eid = ?", args);
			if(result == 1) return true;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}

	public Employee getRecordById(int id) {
		Object[] args = {id};
		try {
			Employee e = template.queryForObject("SELECT * FROM emp WHERE eid = ?", args, new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					int salary = rs.getInt(3);
					return new Employee(id, name, salary);
				}});
			return e;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
