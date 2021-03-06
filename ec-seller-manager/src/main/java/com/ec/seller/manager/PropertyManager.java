package com.ec.seller.manager;

import java.util.List;
import com.ec.seller.domain.Property;
import com.ec.seller.domain.query.PropertyQuery;

public interface PropertyManager {
	public List<Property> selectByCondition(PropertyQuery propertyQuery);
	
	/**
	 * 依据类目属性ID查询类目属性信息
	 * @param propertyId
	 * @return
	 */
	public Property selectByPropertyId(int propertyId);

	public Integer insert(Property property);

}
