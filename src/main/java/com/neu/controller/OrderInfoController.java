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
import com.neu.entity.OrderInfo;
import com.neu.entity.ShoppingCart;
import com.neu.entity.ShoppingItem;
import com.neu.entity.User;
import com.neu.service.OrderInfoService;

@RestController
@RequestMapping("orderInfo")
public class OrderInfoController {
	@Autowired
	private OrderInfoService orderInfoService;

	@RequestMapping("delete")
	public int delete(int id) {
		return orderInfoService.delete(id);

	}

	@RequestMapping("update")
	public int update(OrderInfo orderInfo) {
		return orderInfoService.update(orderInfo);
	}

	@RequestMapping("insert")
	public int insert(@RequestBody ShoppingCart commdityOrder,HttpSession session) {
		List<ShoppingItem> shoppingItems = commdityOrder.getShoppingItems();
		Integer orderNumber = (int) (Math.random() * 100000);
		
		User user = (User)session.getAttribute("user");
		
		Date date = new Date();

		for (ShoppingItem s : shoppingItems) {
			OrderInfo orderInfo = new OrderInfo(orderNumber, date, s.getCommodity(), user, (double) s.getCount());
			orderInfoService.insert(orderInfo);
		}
		
		session.setAttribute("shoppingCart", null);

		return 1;
	}

	@RequestMapping("test")
	public long test() {
		long random = Math.round((Math.random()) * 1000);
		System.out.println(random);
		Date date = new Date();
		System.out.println(date);
		return random;
	}

	@RequestMapping("getByUserIdPaged")
	public PageInfo<OrderInfo> getByUserIdPaged(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pageSize, @RequestBody User user) {
		return orderInfoService.getByUserIdPaged(pageNum, pageSize, user);
	}

	@RequestMapping("getPaged")
	public PageInfo<OrderInfo> getPaged(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pageSize, @RequestBody Map<String, Object> params) {
		return orderInfoService.getPaged(pageNum, pageSize, params);
	}

}
