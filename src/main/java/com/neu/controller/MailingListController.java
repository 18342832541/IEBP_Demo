package com.neu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.entity.MailingList;
import com.neu.service.MailingListService;

@RestController
@RequestMapping("mailingList")
public class MailingListController  {
	
	@Autowired
	private MailingListService mailingListService;
	
	//快递信息的填写
	@RequestMapping("insert")
	public int insert(MailingList mailingList) {
		return   mailingListService.insert( mailingList);
		
	}

	
}
