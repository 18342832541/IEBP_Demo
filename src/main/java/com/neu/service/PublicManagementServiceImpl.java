package com.neu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.neu.entity.LargerCategoryExample;
import com.neu.entity.PublicManagement;
import com.neu.entity.PublicManagementExample;
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
		PublicManagementExample example=new PublicManagementExample();
		example.or().andIdEqualTo(id);
		List<PublicManagement> list = publicManagementMapper.selectByExample(example);
		if(list != null && list.size() != 0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public PageInfo<PublicManagement> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	//公告的查询
	@Override
	public List<PublicManagement> getAll(){
	/*	return publicManagementMapper.getAll();*/
		/*PublicManagementExample example=new PublicManagementExample();*/
	return 	publicManagementMapper.selectByExample(new PublicManagementExample());
	
		
	}

}
