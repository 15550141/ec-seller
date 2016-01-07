package com.ec.seller.dao;


import com.ec.seller.domain.PurchaseItem;
import com.ec.seller.domain.query.PurchaseItemQuery;
import com.ec.seller.domain.query.PurchaseQuery;

import java.util.List;

public interface PurchaseItemDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Integer insert(PurchaseItem object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(PurchaseItem object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public PurchaseItem selectById(int id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(PurchaseItemQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<PurchaseItem> selectByCondition(PurchaseItemQuery object);
}