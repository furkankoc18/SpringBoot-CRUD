package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Employee;

public interface EmployeeService {
	
	void saveEmployee(Employee employee);
	
	List<Employee>getAllEmployees();
}
