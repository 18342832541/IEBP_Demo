package com.neu.controller;

import java.util.List;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.entity.PublicManagement;
import com.neu.service.PublicManagementService;

@RestController
@RequestMapping("public")
public class PublicManagementController {

	@Autowired
	private PublicManagementService publicManagementService;

	// 公共管理的增加
	@RequestMapping("insert")

	public int insert(@RequestBody PublicManagement publicManagement) {
		return publicManagementService.insert(publicManagement);
	}

	// 公共管理的删除
	@RequestMapping("delete")
	public int delete(@Required Integer id) {
		return publicManagementService.delete(id);
	}

	// 公共管理的修改
	@RequestMapping("update")
	public int update(@RequestBody PublicManagement publicManagement) {
		return publicManagementService.update(publicManagement);
	}

	// 查询所有
	@RequestMapping("getAll")
	public List<PublicManagement> getAll() {
		return publicManagementService.getAll();
	}

	// 通过ID查询
	@RequestMapping("getById")
	public PublicManagement getById(int id) {
		return publicManagementService.getById(id);

	}

}
