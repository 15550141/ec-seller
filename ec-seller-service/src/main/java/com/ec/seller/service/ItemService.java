package com.ec.seller.service;

import com.ec.seller.domain.Item;
import com.ec.seller.domain.query.ItemQuery;

import java.util.List;
import java.util.Map;

public interface ItemService {
	public List<Item> selectByConditionForPage(ItemQuery itemQuery);

	public Map<String, Object> queryItemList(ItemQuery itemQuery);
	
	public Integer insert(Item item);

	public void modify(Item item);

	public void delete(Item item);
	
	public Item selectByItemId(int itemId);

	/** 根据itemName模糊查询 */
	public List<String> vagueQueryItemName(String itemName);
}
