package com.training.employeeapp.repository;

import java.util.List;

import com.training.employeeapp.model.Employee;

public interface EmployeeRepository {
	
	public List<Employee> findAllEmployees();
}
