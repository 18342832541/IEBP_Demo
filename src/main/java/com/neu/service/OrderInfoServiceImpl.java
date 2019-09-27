package com.neu.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.entity.OrderInfo;
import com.neu.entity.OrderInfoExample;
import com.neu.entity.User;
import com.neu.mapper.OrderInfoMapper;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
	private OrderInfoMapper orderInfoMapper;

	@Override
	public int insert(OrderInfo entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 订单的状态修改
	@Override
	public int update(OrderInfo entity) {
		return orderInfoMapper.updateByPrimaryKeySelective(entity);
	}

	// 订单的删除
	@Override
	public int delete(int id) {
		return orderInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public OrderInfo getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<OrderInfo> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	// 通过流水号查询
	@Override
	public List<OrderInfo> getByType(int order_number) {
		OrderInfoExample example = new OrderInfoExample();
		example.or().andOrderNumberEqualTo(order_number);
		return orderInfoMapper.selectByExample(example);
	}

	// 通过状态查询
	@Override
	public List<OrderInfo> getByStatus(String order_status) {
		OrderInfoExample example = new OrderInfoExample();
		example.or().andOrderStatusEqualTo(order_status);
		return orderInfoMapper.selectByExample(example);
	}

	// 查询所有
	@Override
	public PageInfo<OrderInfo> getPaged(int pageNum, int pageSize) {
		List<OrderInfo> list = orderInfoMapper.selectByExample(new OrderInfoExample());
		PageInfo<OrderInfo> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<OrderInfo> getByUserIdPaged(int pageNum, int pageSize, int userId) {
		PageHelper.startPage(pageNum, pageSize);
		OrderInfoExample example = new OrderInfoExample();
		User user = new User();
		user.setId(userId);
		example.or().andUserEqualTo(user);
		example.setOrderByClause("order_time DESC");
		
		List<OrderInfo> list = orderInfoMapper.selectByExample(example);
		PageInfo<OrderInfo> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
