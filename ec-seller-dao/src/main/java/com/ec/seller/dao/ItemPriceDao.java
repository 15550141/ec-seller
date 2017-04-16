package com.ec.seller.dao;


import com.ec.seller.domain.ItemPrice;
import com.ec.seller.domain.query.ItemPriceQuery;

import java.util.List;

public interface ItemPriceDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Long insert(ItemPrice object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(ItemPrice object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public ItemPrice selectById(Long id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(ItemPriceQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<ItemPrice> selectByCondition(ItemPriceQuery object);
}