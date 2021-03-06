package com.ec.seller.dao;


import com.ec.seller.domain.DailySalesStatistics;
import com.ec.seller.domain.query.DailySalesStatisticsQuery;

import java.util.List;

public interface DailySalesStatisticsDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Integer insert(DailySalesStatistics object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(DailySalesStatistics object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public DailySalesStatistics selectById(int id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(DailySalesStatisticsQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<DailySalesStatistics> selectByCondition(DailySalesStatisticsQuery object);
}