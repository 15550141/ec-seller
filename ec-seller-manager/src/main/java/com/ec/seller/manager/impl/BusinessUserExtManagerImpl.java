package com.ec.seller.manager.impl;

import com.ec.seller.dao.BusinessUserExtDao;
import com.ec.seller.domain.BusinessUserExt;
import com.ec.seller.manager.BusinessUserExtManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BusinessUserExtManagerImpl implements BusinessUserExtManager{
	
	@Autowired
	private BusinessUserExtDao businessUserExtDao;
	private final static Log LOG = LogFactory.getLog(BusinessUserExtManagerImpl.class);
	@Override
	public Integer insert(BusinessUserExt businessUserExt) {
		return businessUserExtDao.insert(businessUserExt);
	}
	@Override
	public void modifyByUserId(BusinessUserExt businessUserExt) {
		businessUserExtDao.modifyByUserId(businessUserExt);
		
	}
	@Override
	public BusinessUserExt selectByUserId(int userId) {
		
		return businessUserExtDao.selectByUserId(userId);
	}
	
	
	

}
