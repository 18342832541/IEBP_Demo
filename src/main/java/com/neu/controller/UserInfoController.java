package com.neu.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neu.entity.User;
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
	public int update(@RequestBody UserInfo userInfo,@Required HttpSession session) {
		User user = (User)session.getAttribute("user");
		
		userInfo.setUser(user);
		
		UserInfo ifUserInfo = userInfoService.getById(user.getId());
		if(ifUserInfo == null || ifUserInfo.toString() == "") {
			Date registTime = (Date)session.getAttribute("registTime");
			if(registTime != null) {
				userInfo.setRegistTime(registTime);
				session.removeAttribute("registTime");
			}
			return userInfoService.insert(userInfo);
		}else {
			return userInfoService.update(userInfo);
		}
	}

}
