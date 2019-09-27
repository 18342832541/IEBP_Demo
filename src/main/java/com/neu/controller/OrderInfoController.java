package com.neu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neu.entity.OrderInfo;
import com.neu.service.OrderInfoService;

@RestController
@RequestMapping("orderInfo")
public class OrderInfoController {
	private OrderInfoService orderInfoService;

	@RequestMapping("delete")
	int delete(int id) {
		return orderInfoService.delete(id);

	}

	@RequestMapping("update")
	int update(OrderInfo orderInfo) {
		return orderInfoService.update(orderInfo);
	}

	@RequestMapping("getByType")
	List<OrderInfo> getByType(int orde_number) {

		return orderInfoService.getByType(orde_number);

	}

	@RequestMapping("getByStatus")
	List<OrderInfo> getByStatus(String order_status) {

		return orderInfoService.getByStatus(order_status);
	}

	@RequestMapping("getByUserIdPaged")
	PageInfo<OrderInfo> getPaged(
			@RequestParam(defaultValue = "1") int pageNum,
			@RequestBody int userId) {
		return orderInfoService.getByUserIdPaged(pageNum, 5,userId);
	}

}
