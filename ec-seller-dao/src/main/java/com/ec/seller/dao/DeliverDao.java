package com.ec.seller.dao;


import com.ec.seller.domain.DailySalesStatistics;
import com.ec.seller.domain.Deliver;
import com.ec.seller.domain.query.DailySalesStatisticsQuery;
import com.ec.seller.domain.query.DeliverQuery;

import java.util.List;

public interface DeliverDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Long insert(Deliver object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(Deliver object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Deliver selectById(Long id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(DeliverQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<Deliver> selectByCondition(DeliverQuery object);
}