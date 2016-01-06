package com.ec.seller.manager;

import com.ec.seller.domain.Addr;
import com.ec.seller.domain.query.AddrQuery;

import java.util.List;

public interface AddrManager {
	public List<Addr> selectByCondition(AddrQuery addressQuery);

}
