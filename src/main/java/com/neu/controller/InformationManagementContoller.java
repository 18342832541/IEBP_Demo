package com.neu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neu.entity.InformationManagement;
import com.neu.service.InformationManagementService;

@RestController
@RequestMapping("information")
public class InformationManagementContoller {

	@Autowired
	private InformationManagementService informationManagementService;
	
	@RequestMapping("insert")
	//资讯的增加
	//资讯的发布
	public int  insert(InformationManagement  informationManagement) {
	return	informationManagementService.insert(informationManagement);
		
		
	}
	//资讯的减少
	public int  delete(int id) {
		return	informationManagementService.delete(id);
			
			
		}
	//资讯的修改
	public int  update(InformationManagement  informationManagement) {
		return	informationManagementService.update(informationManagement);
			
			
		}
	//资讯的分页查询
	
	public  PageInfo<InformationManagement> getPaged(int pageNum,int pageSize){
		return informationManagementService.getPaged(pageNum, pageSize);
		
		
	}
	
	
	
	
	
	
	
	
}
