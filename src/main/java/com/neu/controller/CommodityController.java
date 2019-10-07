package com.neu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neu.entity.Commodity;
import com.neu.service.CommodityService;

@RestController
@RequestMapping("commodity")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;

	// 商品的增加
	@RequestMapping("insert")
	public int insert(@RequestBody Commodity commodity) {
		return commodityService.insert(commodity);

		// 商品的删除
	}

	@RequestMapping("delete")
	public int delete(@RequestBody Commodity commodity) {
		return commodityService.delete(commodity.getId());

	}

	/// 商品的更新
	@RequestMapping("update")
	public int update(@RequestBody Commodity commodity) {
		return commodityService.update(commodity);

	}

	// 商品的分页
	@RequestMapping("getPaged")
	public PageInfo<Commodity> getPaged(
			@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, 
			@RequestBody Map<String, Object> params) {
		PageInfo<Commodity> pageInfo = commodityService.getPaged(pageNum, pageSize, params);
		return pageInfo;
	}

	// 查询商品信息
	@RequestMapping("getById")
	public Commodity getById(int id) {

		Commodity commodity = commodityService.getById(id);
		return commodity;

	}

}
