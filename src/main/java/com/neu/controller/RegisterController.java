package com.neu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.entity.User;
import com.neu.service.UserService;

@RestController
@RequestMapping("user")
public class RegisterController {

	private UserService userService;

	// 注册普通用户验证用户名字
	@RequestMapping("register")
	public String register(String username) {
		String message = "用户名keyon";
		List<User> list = userService.getAll();
		if (list != null) {
			for (User user : list) {
				if (username.equals(user.getUsername())) {
					message = "用户请存在,请重新输入";
					return message;
				}
			}
		}
		return null;
	}
}
