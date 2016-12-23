package com.ec.seller.dao;


import com.ec.seller.domain.CooperationBusiness;
import com.ec.seller.domain.query.CooperationBusinessQuery;

import java.util.List;

public interface CooperationBusinessDao {
	
	/**
	 * 添加
	 * @param object
	 * @return
	 */
	public Long insert(CooperationBusiness object);

	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * 修改
	 * @param object
	 */
	public void modify(CooperationBusiness object);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public CooperationBusiness selectById(Long id);
	
	/**
	 * 根据条件查询总数
	 * @param object
	 * @return
	 */
	public int countByCondition(CooperationBusinessQuery object);
	
	/**
	 * 根据条件查询列表
	 * @param object
	 * @return
	 */
	public List<CooperationBusiness> selectByCondition(CooperationBusinessQuery object);
}