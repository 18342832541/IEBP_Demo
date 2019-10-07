package com.neu.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neu.entity.Comreview;
import com.neu.entity.User;
import com.neu.service.ComreviewService;

@RestController
@RequestMapping("comreview")

public class ComreviewController {

	@Autowired
	private ComreviewService comreviewService;

	// 评论的增加
	@RequestMapping("insert")
	public int insert(@RequestBody Comreview comreview, HttpSession session) {
		Date date = new Date();
		User user = (User)session.getAttribute("user");
		comreview.setComreviewTime(date);
		comreview.setUser(user);

		return comreviewService.insert(comreview);
	}

	// 评论的删除
	@RequestMapping("delete")
	public int delete(@RequestBody Comreview comreview) {

		return comreviewService.delete(comreview.getId());

	}

	// 商品的评论的分页的分页查询
	@RequestMapping("getPaged")
	public PageInfo<Comreview> getPaged(
			@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "7") int pageSize, 
			@RequestBody Map<String, Object> params) {
		return comreviewService.getPaged(pageNum, pageSize, params);
	}

	// 个人的评论查询
	@RequestMapping("getByUserId")
	List<Comreview> getByUserId(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Comreview> list = comreviewService.getByUserId(user);
		return list;

	}

}
