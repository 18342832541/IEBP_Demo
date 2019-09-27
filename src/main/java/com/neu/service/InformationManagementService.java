package com.neu.service;

import com.github.pagehelper.PageInfo;
import com.neu.entity.InformationManagement;

public interface InformationManagementService extends IService<InformationManagement>{

 PageInfo<InformationManagement> getPaged(int pageNum, int pageSize);
	
}
