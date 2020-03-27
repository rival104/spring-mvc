package com.nt.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.nt.entity.*;

@Component
public class EmpDao {
	@Autowired
	JdbcTemplate template;
	
	private static final Logger logger = Logger.getLogger(EmpDao.class.getName());
	
	public User getUser(String user, String pass) {
		Object[] args = {user, pass};
		try {
			User user1 = template.queryForObject("SELECT * FROM users WHERE username= ? and password = ?", args, new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					int userId = rs.getInt(1);
					String username = rs.getString(2);
					String password = rs.getString(3);
					String role = rs.getString(4);
					return new User(userId, username, password, role);
				}} );
			return user1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public UserDetails getUserDetailsById(int id) {
		Object[] args = {id};
		try {
			UserDetails userdt = template.queryForObject("SELECT * FROM employee.userdetails WHERE user_Id = ?", args, new RowMapper<UserDetails>() {

				@Override
				public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
					int userId = rs.getInt(1);
					String fullName = rs.getString(2);
					String address = rs.getString(3);
					String position = rs.getString(4);
					return new UserDetails(userId, fullName, address, position);
				}} );
			return userdt;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public boolean add(Employee e) {
		Object[] args = {e.getId(), e.getName(),e.getSal()};
		try {
			int result = template.update("INSERT INTO emp values(?, ?, ?)", args);
			if(result == 1) {
				logger.info("New employee registered(id, name, sal): " + e.getId() +" "+ e.getName() +" "+ e.getSal());
				return true;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Employee e) {
		Object[] args = {e.getSal(), e.getId()};
		try {
			int result = template.update("UPDATE emp SET esal = ? WHERE eid= ?", args);
			if(result == 1) {
				logger.info(e.getId() + " updated with salary: " + e.getSal());
				return true;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(Employee e) {
		Object[] args = {e.getId()};
		try {
			int result = template.update("DELETE FROM emp WHERE eid = ?", args);
			if(result == 1) {
				logger.info(e.getId() + " deleted!");
				return true; 
			}
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

	public List<Employee> getAllRecord() {
		try {
			List<Employee> e = template.query("SELECT * FROM emp", new RowMapper<Employee>() {

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

	public Employee getRecordByName(String name) {
		Object[] args = {name};
		try {
			Employee e = template.queryForObject("SELECT * FROM emp WHERE ename = ?", args, new RowMapper<Employee>() {

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

	public List<String> getEmployeeNames() {
		try {
			List<String> names = template.query("SELECT ename FROM emp", new RowMapper<String>() {

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					String name = rs.getString(1);
					return name;
				}});
			return names;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
