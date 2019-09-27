package com.neu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.entity.InformationManagement;
import com.neu.entity.InformationManagementExample;
import com.neu.mapper.InformationManagementMapper;

@Service
public class InformationManagementServiceImpl  implements InformationManagementService{
    @Autowired
    private  InformationManagementMapper informationManagementMapper;
	
	
    //资讯的增加
    //资讯的发布
	@Override
	public int insert(InformationManagement entity) {
      return  informationManagementMapper.insert(entity);
	}
    //资讯的修改
	@Override
	public int update(InformationManagement entity) {
	 return	 informationManagementMapper.updateByPrimaryKeySelective(entity);
		
	}
    //资讯的删除
	@Override
	public int delete(int id) {
	    return informationManagementMapper.deleteByPrimaryKey(id);
	}

	@Override
	public InformationManagement getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
    
	@Override
	public PageInfo<InformationManagement> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
	
		return null;
	}
	
	//资讯的分页
	@Override
	public PageInfo<InformationManagement> getPaged(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<InformationManagement> list = informationManagementMapper.getAll();
		PageInfo pageInfo =  new  PageInfo<>(list);
		return pageInfo;
		
	}

}




