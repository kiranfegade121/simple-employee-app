package com.training.employeeapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.training.employeeapp.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Employee> rowMapper = new EmployeeMapper();
	
	public List<Employee> findAllEmployees() {
			return jdbcTemplate.query("SELECT * FROM employees", rowMapper);
	}
	
	private class EmployeeMapper implements RowMapper<Employee> {

		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		}
		
	}

}
