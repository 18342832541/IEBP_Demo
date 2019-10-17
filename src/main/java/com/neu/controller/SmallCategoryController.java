package com.neu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neu.entity.SmallCategory;
import com.neu.service.CommodityService;
import com.neu.service.SmallCategoryService;

@RestController
@RequestMapping("smallCategory")
public class SmallCategoryController {
	@Autowired
	private SmallCategoryService smallCategoryService;
	
	@Autowired
	private CommodityService commodityService;

	@RequestMapping("insert")
	public int insert(@RequestBody SmallCategory smallCategory) {
		return smallCategoryService.insert(smallCategory);

		// 小分类的删除
	}

	@RequestMapping("delete")
	@Transactional
	public int delete(@RequestBody SmallCategory smallCategory) {
		//事务处理
		commodityService.deleteBySm(smallCategory);
		return smallCategoryService.delete(smallCategory.getId());

	}

	// 小分类的分页
	@RequestMapping("getPaged")
	public PageInfo<SmallCategory> getPaged(
			@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestBody Map<String, Object> params) {
		return smallCategoryService.getPaged(pageNum, pageSize, params);
	}

	// 小分类的分页
	@RequestMapping("getAllSelective")
	public PageInfo<SmallCategory> getAllSelective(
			@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestBody Map<String, Object> params) {
		return smallCategoryService.getPagedSelective(pageNum, pageSize, params);
	}
	
	@RequestMapping("getAll")
	public List<SmallCategory> getAll(@RequestBody Map<String, Object> params) {
		String s = params.get("id").toString();
		return smallCategoryService.getAll(Integer.parseInt(s));
	}

}
