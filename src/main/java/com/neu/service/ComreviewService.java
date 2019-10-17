package com.neu.service;

import java.util.List;

import com.neu.entity.Commodity;
import com.neu.entity.Comreview;
import com.neu.entity.User;

public interface ComreviewService  extends IService<Comreview>{
	List<Comreview> getByUserId(User user);

	int deleteByCommodity(Commodity commodity);
	
	
	
	
}
