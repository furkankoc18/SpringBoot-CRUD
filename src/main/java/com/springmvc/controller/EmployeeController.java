package com.springmvc.controller;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.model.Employee;
import com.springmvc.service.EmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET, value = { "", "/{uuid}" })
	public String employees(Model model, @PathVariable(required = false, value = "uuid") String uuid) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		try {
			if (Objects.nonNull(uuid)) {
				UUID.fromString(uuid);
				model.addAttribute("uuid", uuid);
			}
		} catch (IllegalArgumentException exception) {
			return "redirect:/employee";
		}
		return "employee-list";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public String saveEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname,
			@RequestParam(required = false, value = "uuid") String uuid,
			@RequestParam(name = "gender", required = false) String gender,
			@RequestParam(name = "salary", required = false) Double salary) {

		Employee employee;
		if (Objects.nonNull(uuid) && !uuid.isEmpty()) {
			employee = employeeService.getEmployeeByUuid(uuid);
			employee.setLastUpdatedBy(1L);
			employee.setLastUpdatedDate(new Date(System.currentTimeMillis()));
		} else {
			employee = new Employee();
			employee.setCreatedTime(new Date(System.currentTimeMillis()));
			employee.setCreatedBy(1L);
			employee.setLastUpdatedBy(1L);
			employee.setLastUpdatedDate(new Date(System.currentTimeMillis()));
			employee.setUuid(UUID.randomUUID());
		}
		employee.setName(name);
		employee.setSurname(surname);
		employee.setGender(gender);
		employee.setSalary(salary);
		employeeService.saveEmployee(employee);
		return "redirect:/employee";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/delete/{uuid}")
	public String deleteEmployee(@PathVariable("uuid") String uuid) {
		Employee employee = employeeService.getEmployeeByUuid(uuid);
		employeeService.removeEmployee(employee);
		return "redirect:/employee";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/edit/{uuid}")
	public String editEmployee(Model model, HttpServletRequest request, @PathVariable("uuid") String uuid,
			RedirectAttributes redirectAttributes) {
		Employee employee = employeeService.getEmployeeByUuid(uuid);
		if (Objects.nonNull(employee)) {
			redirectAttributes.addFlashAttribute("employee", employee);
			return "redirect:/employee/" + uuid;
		}
		return "redirect:/employee";
	}

}
