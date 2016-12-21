package com.ec.seller.dao;


import com.ec.seller.domain.ActivityExchange;
import com.ec.seller.domain.query.ActivityExchangeQuery;

import java.util.List;

public interface ActivityExchangeDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Long insert(ActivityExchange object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(ActivityExchange object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public ActivityExchange selectById(Long id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(ActivityExchangeQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<ActivityExchange> selectByCondition(ActivityExchangeQuery object);
}