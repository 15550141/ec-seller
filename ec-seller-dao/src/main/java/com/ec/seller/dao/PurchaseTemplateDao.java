package com.ec.seller.dao;

import com.ec.seller.domain.PurchaseTemplate;
import com.ec.seller.domain.query.PurchaseTemplateQuery;

import java.util.List;

public interface PurchaseTemplateDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Integer insert(PurchaseTemplate object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(PurchaseTemplate object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public PurchaseTemplate selectById(int id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(PurchaseTemplateQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<PurchaseTemplate> selectByCondition(PurchaseTemplateQuery object);
}