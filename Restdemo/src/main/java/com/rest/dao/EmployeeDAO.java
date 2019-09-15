package com.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rest.entity.Employee;

@Repository
public class EmployeeDAO implements IEmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getEmployee() {
		
		Session currentsession=sessionFactory.getCurrentSession();
		
	// create a query  ... sort by last name
			Query<Employee> theQuery = 
					currentsession.createQuery("from Employee ",Employee.class);
			
			// execute query and get result list
			List<Employee> employees = theQuery.getResultList();
					
			// return the results		
			return employees;
			
	}
	@Override
	public Employee getEmployee(int id) {
	// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// now retrieve/read from database using the primary key
			Employee employee = currentSession.get(Employee.class,id);
			
			return employee;
	}

	public void creatEmployee(Employee emp) {
		
		Session currentsession=sessionFactory.getCurrentSession();
		
		currentsession.saveOrUpdate(emp);
	}
	@Override
	public void deleteEmployee(int id) {
		
		Session currentsession=sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentsession.createQuery("delete from Employee where id=:id");
		theQuery.setParameter("customerId", id);
		
		theQuery.executeUpdate();	
	}

	public Employee updateEmployee(int id) {
		
		return null;
	}

}
