package com.neu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.entity.User;
import com.neu.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public User login(String username,String password) {
		
		return userService.login(username, password);
	}
}
