package com.neu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.entity.Securityquestion;
import com.neu.service.SecurityquestionService;

@RestController
@RequestMapping("securityquestion")
public class SecurityquestionController {

	private List<Securityquestion> list = null;
	@Autowired
	private SecurityquestionService SQservice;

	@RequestMapping("insert")
	public int inser(Securityquestion securityquestion) {
		SQservice.insert(securityquestion);
		return 1;
	}

	@RequestMapping("verify")
	public String verify(@RequestBody List<Securityquestion> questions,HttpSession session) {
		for (Securityquestion sq1 : questions) {
			for (Securityquestion sq2 : list) {
				if (sq2.getId() == sq1.getId()) {
					if (!(sq2.getAnswer().equals(sq1.getAnswer()))) {
						return null;
					}else {
						break;
					}
				}
			}
		}
		return list.get(0).getUser().getPassword();
	}

	@RequestMapping("getByUserName")
	public List<Securityquestion> getByUserName(int userId) {
		list = SQservice.getByUserId(userId);
		return list;
	}

	@RequestMapping("noUserSQInfo")
	public List<Securityquestion> noUserSQInfo() {
		return null;
	}

}
