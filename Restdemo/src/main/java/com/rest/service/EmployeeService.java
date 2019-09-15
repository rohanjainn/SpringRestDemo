package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.dao.EmployeeDAO;
import com.rest.dao.IEmployeeDAO;
import com.rest.entity.Employee;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDAO empDao;

	@Override
	@Transactional
	public List<Employee> getEmployee() {
		
		return empDao.getEmployee();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee emp) {
		empDao.creatEmployee(emp);
		
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return empDao.getEmployee(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		empDao.deleteEmployee(id);
	}
	
			
	

}
