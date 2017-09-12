package com.ec.seller.dao;

import com.ec.seller.domain.ReturnGoods;
import com.ec.seller.domain.query.ReturnGoodsQuery;

import java.util.List;

public interface ReturnGoodsDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Integer insert(ReturnGoods object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(ReturnGoods object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public ReturnGoods selectById(int id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(ReturnGoodsQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<ReturnGoods> selectByCondition(ReturnGoodsQuery object);
}