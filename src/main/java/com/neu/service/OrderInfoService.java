package com.neu.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.neu.entity.OrderInfo;

public interface OrderInfoService  extends IService<OrderInfo>{
	   //订单编号查询
	   List<OrderInfo> getByType(int order_number);
	   //通过订单状态查询
	   List<OrderInfo> getByStatus(String order_status);
	   //订单的所有查询
	   PageInfo<OrderInfo> getPaged(int pageNum, int pageSize);
	   
	   //用户单人订单查询
	   PageInfo<OrderInfo> getByUserIdPaged(int pageNum, int pageSize,int userId);
}
