package com.ec.seller.dao;


import com.ec.seller.domain.Purchase;
import com.ec.seller.domain.query.PurchaseQuery;

import java.util.List;

public interface PurchaseDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Integer insert(Purchase object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(Purchase object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Purchase selectById(int id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(PurchaseQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<Purchase> selectByCondition(PurchaseQuery object);
}