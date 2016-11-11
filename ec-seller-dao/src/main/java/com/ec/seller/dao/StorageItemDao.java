package com.ec.seller.dao;


import com.ec.seller.domain.StorageItem;
import com.ec.seller.domain.query.StorageItemQuery;

import java.util.List;

public interface StorageItemDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Integer insert(StorageItem object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(StorageItem object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public StorageItem selectById(int id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(StorageItemQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<StorageItem> selectByCondition(StorageItemQuery object);
}