package com.ec.seller.manager.impl;

import com.ec.seller.dao.AddrDao;
import com.ec.seller.domain.Addr;
import com.ec.seller.domain.query.AddrQuery;
import com.ec.seller.manager.AddrManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AddrManagerImpl implements AddrManager {
	
	@Autowired
	private AddrDao addrDao;

	private final static Log LOG = LogFactory.getLog(AddrManagerImpl.class);

	@Override
	public List<Addr> selectByCondition(AddrQuery addressQuery) {
		
		return addrDao.selectByCondition(addressQuery);
	}
	

}
