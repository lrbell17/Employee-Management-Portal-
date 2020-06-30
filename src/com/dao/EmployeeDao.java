package com.dao;

import java.util.List;

import com.entity.Employee;

public interface EmployeeDao {
	
	public int delete(int id);
	public int save(Employee emp);
	
	public Employee getEmployeeById(int id);
	
	public List<Employee> getAllEmployees();
	int update(Employee emp);
	
	

}
