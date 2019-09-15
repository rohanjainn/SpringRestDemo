package com.rest.service;

import java.util.List;

import com.rest.entity.Employee;

public interface IEmployeeService {

	public List<Employee> getEmployee();

	public void saveEmployee(Employee emp); 

	public Employee getEmployee(int id);

	public void deleteEmployee(int id);
}
