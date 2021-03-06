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
		Object[] args = { user, pass };
		try {
			User user1 = template.queryForObject("SELECT * FROM users WHERE username= ? and password = ?", args,
					new RowMapper<User>() {

						@Override
						public User mapRow(ResultSet rs, int rowNum) throws SQLException {
							int userId = rs.getInt(1);
							String username = rs.getString(2);
							String password = rs.getString(3);
							String role = rs.getString(4);
							String userDetail = rs.getString(5);
							return new User(userId, username, password, role, userDetail);
						}
					});
			return user1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	public boolean add(Employee e) {
		Object[] args = { e.getName(), e.getSal(), e.getEmpType(), e.getDesignation(), e.getDob(), e.getPhone(), e.getEmail(), e.getGender(), e.getRole(),  e.getTechStack(), e.getCreatorId() };
		try {
			int result = template.update("INSERT INTO emp (`ename`, `esal`, `empType`, `designation`, `dob`, `phone`, `email`, `gender`, `userRole`, `techStack`, `created_by`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", args);
			if (result == 1) {
				logger.info(
						"New employee registered(id, name, sal): " + e.getId() + " " + e.getName() + " " + e.getSal());
				return true;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}

	public boolean update(Employee e) {
		Object[] args = { e.getSal(), e.getId() };
		try {
			int result = template.update("UPDATE emp SET esal = ? WHERE eid= ?", args);
			if (result == 1) {
				logger.info(e.getId() + " updated with salary: " + e.getSal());
				return true;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}

	public boolean delete(Employee e) {
		Object[] args = { e.getId() };
		try {
			int result = template.update("DELETE FROM emp WHERE eid = ?", args);
			if (result == 1) {
				logger.info(e.getId() + " deleted!");
				return true;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}

	public Employee getRecordById(int id) {
		Object[] args = { id };
		try {
			Employee e = template.queryForObject("SELECT * FROM emp WHERE eid = ?", args, new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new Employee(rs.getInt(1), 
							rs.getString(2), 
							rs.getInt(3), 
							rs.getString(4), 
							rs.getString(5), 
							rs.getString(6), 
							rs.getString(7), 
							rs.getString(8), 
							rs.getString(9), 
							rs.getString(10),
							rs.getString(11), 
							rs.getInt(12));
				}
			});
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
					return new Employee(rs.getInt(1), 
										rs.getString(2), 
										rs.getInt(3), 
										rs.getString(4), 
										rs.getString(5), 
										rs.getString(6), 
										rs.getString(7), 
										rs.getString(8), 
										rs.getString(9), 
										rs.getString(10),
										rs.getString(11), 
										rs.getInt(12));
				}});
			return e;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public List<Employee> getAllRecordByUser(int userId) {
		Object[] args = { userId };
		try {
			List<Employee> e = template.query("SELECT * FROM emp WHERE created_by = ?", args, new RowMapper<Employee>() {
				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new Employee(rs.getInt(1), 
										rs.getString(2), 
										rs.getInt(3), 
										rs.getString(4), 
										rs.getString(5), 
										rs.getString(6), 
										rs.getString(7), 
										rs.getString(8), 
										rs.getString(9), 
										rs.getString(10),
										rs.getString(11), 
										rs.getInt(12));
				}});
			return e;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public Employee getRecordsByName(String name, int id) {
		Object[] args = { name, id };
		try {
			Employee e = template.queryForObject("SELECT * FROM emp WHERE ename = ? and created_by = ?", args, new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new Employee(rs.getInt(1), 
							rs.getString(2), 
							rs.getInt(3), 
							rs.getString(4), 
							rs.getString(5), 
							rs.getString(6), 
							rs.getString(7), 
							rs.getString(8), 
							rs.getString(9), 
							rs.getString(10),
							rs.getString(11), 
							rs.getInt(12));
				}
			});
			return e;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public List<String> getEmployeeNames(int userId) {
		Object[] args = {userId};
		try {
			List<String> names = template.query("SELECT ename FROM emp WHERE created_by = ?",args , new RowMapper<String>() {

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					String name = rs.getString(1);
					return name;
				}
			});
			return names;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
