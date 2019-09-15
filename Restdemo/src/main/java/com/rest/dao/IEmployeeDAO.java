package com.rest.dao;

import java.util.List;

import com.rest.entity.Employee;

public interface IEmployeeDAO {

	public List<Employee> getEmployee();
	public Employee getEmployee(int id);
	public void creatEmployee(Employee emp);
	public void deleteEmployee(int id);
	public Employee updateEmployee(int id);
}
