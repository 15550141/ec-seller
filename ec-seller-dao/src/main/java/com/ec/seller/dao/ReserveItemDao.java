package com.ec.seller.dao;


import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.ReserveItem;
import com.ec.seller.domain.query.ReserveItemQuery;
import com.ec.seller.domain.query.ReserveQuery;

import java.util.List;

public interface ReserveItemDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Long insert(ReserveItem object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(ReserveItem object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public ReserveItem selectById(Long id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(ReserveItemQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<ReserveItem> selectByCondition(ReserveItemQuery object);
}