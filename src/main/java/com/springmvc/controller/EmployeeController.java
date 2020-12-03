package com.springmvc.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Employee;
import com.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String employees() {
		return "employee-list";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employee/create")
	public String saveEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname,
			@RequestParam(name = "gender",required = false) String gender) {
		Employee employee = new Employee();
			employee.setName(name);
			employee.setSurname(surname);
			employee.setCreatedTime(new Date(System.currentTimeMillis()));
			employee.setCreatedBy(1L);
			employee.setLastUpdatedBy(1L);
			employee.setLastUpdatedDate(new Date(System.currentTimeMillis()));
			employee.setUuid(UUID.randomUUID());
			employee.setGender(gender);
			employeeService.saveEmployee(employee);
		return "redirect:/";
	}
}
