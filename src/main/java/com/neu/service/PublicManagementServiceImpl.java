package com.neu.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.neu.entity.PublicManagement;
import com.neu.mapper.PublicManagementMapper;

@Service
public class PublicManagementServiceImpl  implements PublicManagementService{
        @Autowired
        private PublicManagementMapper publicManagementMapper;
	//公告的增加
	@Override
	public int insert(PublicManagement entity) {
	 return publicManagementMapper.insert(entity);
		
	}
    //公共的修改
	@Override
	public int update(PublicManagement entity) {
	 return	publicManagementMapper.updateByPrimaryKeySelective(entity);
		
	}
    //公共的删除
	@Override
	public int delete(int id) {
	 return publicManagementMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public PublicManagement getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<PublicManagement> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
