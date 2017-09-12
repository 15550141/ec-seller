package com.ec.seller.dao;


import com.ec.seller.domain.ReturnGoodsItem;
import com.ec.seller.domain.query.ReturnGoodsItemQuery;

import java.util.List;

public interface ReturnGoodsItemDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Integer insert(ReturnGoodsItem object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(ReturnGoodsItem object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public ReturnGoodsItem selectById(int id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(ReturnGoodsItemQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<ReturnGoodsItem> selectByCondition(ReturnGoodsItemQuery object);
}