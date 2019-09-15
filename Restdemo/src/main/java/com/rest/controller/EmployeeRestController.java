package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.Employee;
import com.rest.service.EmployeeService;
import com.rest.service.IEmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// autowire the CustomerService
	@Autowired
	private IEmployeeService employeeService;
	
	// add mapping for GET /customers
	@GetMapping("/employees")
	public List<Employee> getEmployee() {
		
		return employeeService.getEmployee();
		
	}
		
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id)
	{
		Employee emp=employeeService.getEmployee(id);
		
		if(emp==null)
			throw new EmployeeNotFoundException("Employee not found "+id);
		return emp;
	}
}


















