package com.neu.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.neu.entity.MailingList;
import com.neu.mapper.MailingListMapper;

@Service
public class MailingListServiceImpl implements MailingListService{
      private MailingListMapper mailingListMapper;
	 
	@Override
	public int insert(MailingList entity) {
	 return	mailingListMapper.insert(entity);
	}

	@Override
	public int update(MailingList entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MailingList getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<MailingList> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
