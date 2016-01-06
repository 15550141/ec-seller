package com.ec.seller.service;

import com.ec.seller.domain.Addr;
import com.ec.seller.domain.query.AddrQuery;

import java.util.List;

public interface AddrService {
	public List<Addr> selectByCondition(AddrQuery addressQuery);

	/**
	 * 根据一级、二级、三级地址id获得收货人地址信息
	 * @param province
	 * @param city
	 * @param county
	 * @param address
	 * @return
	 */
	public String getDetailConsigneeAddress(int province, int city, int county, String address);
}
