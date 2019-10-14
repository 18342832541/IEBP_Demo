package com.neu.controller;

import java.util.List;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neu.entity.InformationManagement;
import com.neu.entity.InformationManagementExample;
import com.neu.service.InformationManagementService;

@RestController
@RequestMapping("information")
public class InformationManagementContoller {

	@Autowired
	private InformationManagementService informationManagementService;

	@RequestMapping("insert")
	// 资讯的增加
	// 资讯的发布
	public int insert(@RequestBody InformationManagement informationManagement) {
		return informationManagementService.insert(informationManagement);

	}

	// 资讯的减少
	@RequestMapping("delete")
	public int delete(@Required Integer id) {
		return informationManagementService.delete(id);

	}

	// 资讯的修改
	@RequestMapping("update")
	public int update(@RequestBody InformationManagement informationManagement) {
		return informationManagementService.update(informationManagement);

	}

	// 资讯的分页查询
	@RequestMapping("get")
	public PageInfo<InformationManagement> getPaged(int pageNum, int pageSize) {
		return informationManagementService.getPaged(pageNum, pageSize);

	}

	// 资讯的查询所有
	@RequestMapping("getAll")
	public List<InformationManagement> getAll() {

		return informationManagementService.getAll();

	}

	// 通过ID查询
	@RequestMapping("getById")
	public InformationManagement getById(int id) {
		return informationManagementService.getById(id);

	}

}
