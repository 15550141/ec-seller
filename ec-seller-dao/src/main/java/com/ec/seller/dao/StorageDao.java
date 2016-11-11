package com.ec.seller.dao;


import com.ec.seller.domain.Storage;
import com.ec.seller.domain.query.StorageQuery;

import java.util.List;

public interface StorageDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Integer insert(Storage object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(Storage object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Storage selectById(int id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(StorageQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<Storage> selectByCondition(StorageQuery object);
}