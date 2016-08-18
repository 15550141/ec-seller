package com.ec.seller.dao;


import com.ec.seller.domain.Deliver;
import com.ec.seller.domain.DeliverItem;
import com.ec.seller.domain.query.DeliverItemQuery;
import com.ec.seller.domain.query.DeliverQuery;

import java.util.List;

public interface DeliverItemDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Integer insert(DeliverItem object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(DeliverItem object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public DeliverItem selectById(int id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(DeliverItemQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<DeliverItem> selectByCondition(DeliverItemQuery object);
}