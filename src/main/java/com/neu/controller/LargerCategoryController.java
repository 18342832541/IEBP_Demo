package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neu.entity.LargerCategory;
import com.neu.service.CommodityService;
import com.neu.service.LargerCategoryService;
import com.neu.service.SmallCategoryService;

@RestController
@RequestMapping("largerCategory")
public class LargerCategoryController {
	@Autowired
	private LargerCategoryService largerCategoryService;

	@Autowired
	private SmallCategoryService smallCategoryService;
	
	@Autowired
	private CommodityService commodityService;
	
	// 大分类的增加
	@RequestMapping("insert")
	public int insert(@RequestBody LargerCategory largerCategory) {
		return largerCategoryService.insert(largerCategory);

		// 大分类的删除
	}

	@RequestMapping("delete")
	@Transactional
	public int delete(@RequestBody LargerCategory largerCategory) {
		//事务处理一下
		smallCategoryService.deleteByLg(largerCategory);
		commodityService.deleteByLg(largerCategory);
		return largerCategoryService.delete(largerCategory.getId());

	}

	/// 大分类的更新
	@RequestMapping("update")
	public int update(LargerCategory largerCategory) {
		return largerCategoryService.update(largerCategory);

	}

	// 大分类的分页
	@RequestMapping("getPaged")
	public PageInfo<LargerCategory> getPaged(
			@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pageSize) {
		return largerCategoryService.getPaged(pageNum, pageSize);
	}

	/// 大分类的所有
	@RequestMapping("getALl")
	public List<LargerCategory> getALl() {
		return largerCategoryService.getAll();
	}

}
