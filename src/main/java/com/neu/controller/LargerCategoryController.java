package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neu.entity.LargerCategory;
import com.neu.service.LargerCategoryService;

@RestController
@RequestMapping("largerCategory")
public class LargerCategoryController {
	@Autowired
	private LargerCategoryService largerCategoryService;

	// 大分类的增加
	@RequestMapping("insert")
	public int insert(LargerCategory largerCategory) {
		return largerCategoryService.insert(largerCategory);

		// 大分类的删除
	}

	@RequestMapping("delete")
	public int delete(int id) {
		return largerCategoryService.delete(id);

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
