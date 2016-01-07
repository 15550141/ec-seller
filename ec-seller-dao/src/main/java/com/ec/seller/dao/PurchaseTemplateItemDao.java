package com.ec.seller.dao;

import com.ec.seller.domain.PurchaseTemplateItem;
import com.ec.seller.domain.query.PurchaseTemplateItemQuery;

import java.util.List;

public interface PurchaseTemplateItemDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Integer insert(PurchaseTemplateItem object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(PurchaseTemplateItem object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public PurchaseTemplateItem selectById(int id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(PurchaseTemplateItemQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<PurchaseTemplateItem> selectByCondition(PurchaseTemplateItemQuery object);
}