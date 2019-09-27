package com.neu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.entity.PublicManagement;
import com.neu.service.PublicManagementService;

@RestController
@RequestMapping("public")
public class PublicManagementController {

	@Autowired
	private PublicManagementService  publicManagementService;
	//公共管理的增加
	@RequestMapping("insert")
	
	public  int  insert(PublicManagement publicManagement) {
	 return	publicManagementService.insert(publicManagement);	
	}
	//公共管理的删除
    @RequestMapping("delete")
	public  int  delete(PublicManagement publicManagement) {
	 return	publicManagementService.insert(publicManagement);	
	}
    //公共管理的修改
    @RequestMapping("update")
	public  int  update(PublicManagement publicManagement) {
	 return	publicManagementService.insert(publicManagement);	
	}
	
}
