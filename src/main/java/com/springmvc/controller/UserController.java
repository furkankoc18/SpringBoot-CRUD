package com.springmvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String userLogin() {
		return "user-login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String userSignin() {
		return "redirect:/employee";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/signup")
	public String userSignUp() {
		return "user-signup";
	}
}
