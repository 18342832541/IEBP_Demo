package com.neu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.entity.Commodity;
import com.neu.entity.CommodityExample;
import com.neu.entity.Comreview;
import com.neu.entity.ComreviewExample;
import com.neu.entity.ComreviewExample.Criteria;
import com.neu.entity.User;
import com.neu.mapper.CommodityMapper;
import com.neu.mapper.ComreviewMapper;

@Service
// 评论指面对的是注册用户，游客不可以评论
public class ComreviewServiceImpl implements ComreviewService {
	@Autowired
	ComreviewMapper comreviewMapper;
	
	@Autowired
	CommodityMapper commodityMapper;

	// 添加评论
	@Override
	public int insert(Comreview entity) {

		return comreviewMapper.insertSelective(entity);
	}

	@Override
	public int update(Comreview entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 评论删除(只有管理者有权限)
	@Override
	public int delete(int id) {
		return comreviewMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Comreview getById(int id) {

		return null;

	}

	// 商品的评论的分页查询，通过商品的名字查询
	@Override
	public PageInfo<Comreview> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		
		ComreviewExample example = new ComreviewExample();
		if(params.get("comname") != null && params.get("comname").toString() != "") {
			String comname = params.get("comname").toString();
			CommodityExample commodityExample = new CommodityExample();
			commodityExample.or().andComnameLike("%"+comname+"%");
			List<Commodity> commodities = commodityMapper.selectByExample(commodityExample);
			if(commodities.size() != 0) {
				for(Commodity c : commodities) {
					example.or().andCommodityEqualTo(c);
				}
			}else {
				return null;
			}
		}
		example.setOrderByClause("comreview_time desc");
		PageHelper.startPage(pageNum, pageSize);
		List<Comreview> list = comreviewMapper.selectByExample(example);
		if(list.size() != 0) {
			PageInfo<Comreview> pageInfo = new PageInfo<>(list);
			return pageInfo;
		}
		return null;
		
		
	}

	@Override
	// 已修改自己的方法,通过个人的id,查询自己所写的评论
	public List<Comreview> getByUserId(User user) {
		ComreviewExample example = new ComreviewExample();
		example.or().andUserEqualTo(user);
		example.setOrderByClause("comreview_time desc");
		
		List<Comreview> list = comreviewMapper.selectByExample(example);
		return list;

	}

}
