package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.entity.ConstantItem;
import com.neu.service.ConstantItemService;

@RestController
@RequestMapping("constantItem")
public class ConstantItemController {

	@Autowired
	private ConstantItemService constantItemService;
	
	@RequestMapping("getByIds")
	private List<ConstantItem> getByIds(Integer id){
		return constantItemService.getByIds(id);
	}
}
