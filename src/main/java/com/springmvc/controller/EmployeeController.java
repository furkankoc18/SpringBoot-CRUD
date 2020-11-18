package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String employees() {
		return "employee-list";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employee/create")
	public String saveEmployee() {
		return "";
	}
}
