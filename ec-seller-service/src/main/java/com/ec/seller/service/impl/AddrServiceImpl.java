package com.ec.seller.service.impl;

import com.ec.seller.domain.Addr;
import com.ec.seller.domain.query.AddrQuery;
import com.ec.seller.manager.AddrManager;
import com.ec.seller.service.AddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "addressService")
public class AddrServiceImpl implements AddrService {
	@Autowired
	private AddrManager addrManager;

	@Override
	public List<Addr> selectByCondition(AddrQuery addressQuery) {
		return addrManager.selectByCondition(addressQuery);
	}

	@Override
	public String getDetailConsigneeAddress(int province, int city, int county,
			String address) {
		AddrQuery query1 = new AddrQuery();
		query1.setAddressLevel(1);
		query1.setAddressId(province);
		
		List<Addr> list1 = addrManager.selectByCondition(query1);
		if(list1 == null || list1.size() == 0){
			return null;
		}
		
		AddrQuery query2 = new AddrQuery();
		query2.setAddressLevel(2);
		query2.setAddressId(city);
		
		List<Addr> list2 = addrManager.selectByCondition(query2);
		if(list2 == null || list2.size() == 0){
			return null;
		}
		
		AddrQuery query3 = new AddrQuery();
		query3.setAddressLevel(3);
		query3.setAddressId(county);
		
		List<Addr> list3 = addrManager.selectByCondition(query3);
		if(list3 == null || list3.size() == 0){
			return null;
		}
		
		return list1.get(0).getAddressName() + list2.get(0).getAddressName() + list3.get(0).getAddressName() + address;
	}


}
