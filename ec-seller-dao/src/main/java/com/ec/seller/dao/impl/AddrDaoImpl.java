package com.ec.seller.dao.impl;

import com.ec.seller.dao.AddrDao;
import com.ec.seller.domain.Addr;
import com.ec.seller.domain.query.AddrQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

public class AddrDaoImpl extends SqlMapClientTemplate implements AddrDao {

	@Override
	public Integer insert(Addr address) {
		return (Integer) insert("Addr.insert", address);
	}

	@Override
	public void modify(Addr address) {
		update("Addr.updateByPrimaryKey", address);
	}

	@Override
	public Addr selectByAddressId(int addressId) {
		return (Addr) queryForObject("Addr.selectByPrimaryKey", addressId);
	}

	@Override
	public int countByCondition(AddrQuery addressQuery) {
		return (Integer) queryForObject("Addr.countByCondition", addressQuery);
	}

	@Override
	public List<Addr> selectByCondition(AddrQuery addressQuery) {
		return (List<Addr>)queryForList("Addr.selectByCondition",addressQuery);
	}

}
