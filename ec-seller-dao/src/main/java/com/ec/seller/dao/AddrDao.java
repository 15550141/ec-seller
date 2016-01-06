package com.ec.seller.dao;

import com.ec.seller.domain.Addr;
import com.ec.seller.domain.query.AddrQuery;

import java.util.List;

public interface AddrDao {
	
	/**
	 * 添加地址信息
	 * @param address
	 * @return
	 */
	public Integer insert(Addr address);

	/**
	 * 依据地址ID修改地址信息
	 * @param address
	 */
	public void modify(Addr address);

	/**
	 * 依据地址ID查询地址信息
	 * @param addressId
	 * @return
	 */
	public Addr selectByAddressId(int addressId);
	
	/**
	 * 根据相应的条件查询满足条件的地址信息的总数
	 * @param addressQuery
	 * @return
	 */
	public int countByCondition(AddrQuery addressQuery);
	
	/**
	 * 根据相应的条件查询地址信息
	 * @param addressQuery
	 * @return
	 */
	public List<Addr> selectByCondition(AddrQuery addressQuery);
}