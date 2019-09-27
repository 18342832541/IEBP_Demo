package com.neu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neu.entity.UserInfo;
import com.neu.service.UserInfoService;

@RestController
@RequestMapping("userInfo")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("insert")
	public int insert(UserInfo userInfo) {
		return userInfoService.insert(userInfo);

	}

	// 查询个人信息
	@RequestMapping("getById")
	public UserInfo getById(@RequestParam int id) {
		UserInfo userInfo = userInfoService.getById(id);
		return userInfo;
	}

	// 先执行查询个人信息再修改
	@RequestMapping("update")
	public int update(UserInfo userInfo) {

		return userInfoService.update(userInfo);
	}

}
