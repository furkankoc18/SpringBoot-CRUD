package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Employee;

public interface EmployeeService {
	
	void saveEmployee(Employee employee);

	void removeEmployee(Employee employee);
	
	Employee getEmployeeByUuid(String uuid);
	
	List<Employee>getAllEmployees();
	
}
