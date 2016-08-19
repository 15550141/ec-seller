package com.ec.seller.dao;


import com.ec.seller.domain.Deliver;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.query.DeliverQuery;
import com.ec.seller.domain.query.ReserveQuery;

import java.util.List;

public interface ReserveDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Long insert(Reserve object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(Reserve object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Reserve selectById(Long id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(ReserveQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<Reserve> selectByCondition(ReserveQuery object);
}