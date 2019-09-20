package com.neu.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.entity.Securityquestion;
import com.neu.entity.User;
import com.neu.service.SecurityquestionService;

@RestController
@RequestMapping("securityquestion")
public class SecurityquestionController {

	@Autowired
	private SecurityquestionService service;
	
	@RequestMapping("insert")
	public int inser(Securityquestion securityquestion) {
		service.insert(securityquestion);
		return 1;
	}
	
	@RequestMapping("getByUserId")
	public String getByUserId(Map<String, Object> questons,HttpSession session) {
		String msg = null;
		int userId = ((User)session.getAttribute("user")).getId();
		
		List<Securityquestion> list = service.getByUserId(userId);

		return msg;
	}
	
	
}
