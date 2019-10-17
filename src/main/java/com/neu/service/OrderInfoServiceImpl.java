package com.neu.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.entity.ConstantItem;
import com.neu.entity.OrderInfo;
import com.neu.entity.OrderInfoExample;
import com.neu.entity.OrderInfoExample.Criteria;
import com.neu.entity.User;
import com.neu.mapper.OrderInfoMapper;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Override
	public int insert(OrderInfo entity) {
		return orderInfoMapper.insertSelective(entity);
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
		PageHelper.startPage(pageNum, pageSize);
		OrderInfoExample example = new OrderInfoExample();
		Criteria criteria = example.or();
		Criteria criteria2 = example.or();

		if (params.get("orderNumber").toString() != "") {
			Integer orderNumber = Integer.parseInt(params.get("orderNumber").toString());
			criteria.andOrderNumberEqualTo(orderNumber);
			criteria2.andOrderNumberEqualTo(orderNumber);
		};
		if (params.get("orderTime").toString() != "") {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			Date orderTime = null;
			try {
				orderTime = f.parse(params.get("orderTime").toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			criteria.andOrderTimeGreaterThanOrEqualTo(orderTime);
			criteria2.andOrderTimeGreaterThanOrEqualTo(orderTime);
		};
		if (Integer.parseInt(params.get("status").toString()) != 0) {
			Integer status = Integer.parseInt(params.get("status").toString());
			ConstantItem constantItem = new ConstantItem();
			constantItem.setId(status);
			criteria.andConstantItem1EqualTo(constantItem);
			criteria2.andConstantItem2EqualTo(constantItem);
		};
		example.setOrderByClause("order_time DESC, id desc");
		List<OrderInfo> list = orderInfoMapper.selectByExample(example);
		PageInfo<OrderInfo> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	/*
	 * // 通过流水号查询
	 * 
	 * @Override public List<OrderInfo> getByType(int order_number) {
	 * OrderInfoExample example = new OrderInfoExample();
	 * example.or().andOrderNumberEqualTo(order_number); return
	 * orderInfoMapper.selectByExample(example); }
	 * 
	 * // 通过状态查询
	 * 
	 * @Override public List<OrderInfo> getByStatus(String order_status) {
	 * OrderInfoExample example = new OrderInfoExample();
	 * example.or().andOrderStatusEqualTo(order_status); return
	 * orderInfoMapper.selectByExample(example); }
	 */

	// 查询所有
	/*
	 * @Override public PageInfo<OrderInfo> getPaged1(int pageNum, int
	 * pageSize,Map<String, Object> params) { PageHelper.startPage(pageNum,
	 * pageSize); List<OrderInfo> list = orderInfoMapper.selectByExample(new
	 * OrderInfoExample()); PageInfo<OrderInfo> pageInfo = new PageInfo<>(list);
	 * return pageInfo; }
	 */
	@Override
	public List<OrderInfo> getAll() {
		List<OrderInfo> list = orderInfoMapper.selectByExample(new OrderInfoExample());
		return list;
	}

	@Override
	public PageInfo<OrderInfo> getByUserIdPaged(int pageNum, int pageSize, User user) {
		PageHelper.startPage(pageNum, pageSize);
		OrderInfoExample example = new OrderInfoExample();
		example.or().andUserEqualTo(user);
		example.setOrderByClause("order_time DESC, id desc");

		List<OrderInfo> list = orderInfoMapper.selectByExample(example);
		PageInfo<OrderInfo> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
