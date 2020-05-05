package com.training.employeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.employeeapp.model.Employee;
import com.training.employeeapp.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/")
	public String getHomePage() {
		return "index";
	}
	
	@RequestMapping("/employees")
	public String getAllEmployeeDetails(Model model) {
		List<Employee> employees = employeeRepository.findAllEmployees();
		model.addAttribute("employees", employees);
		return "employeedetails";
	}
}
