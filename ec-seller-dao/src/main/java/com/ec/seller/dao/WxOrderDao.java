package com.ec.seller.dao;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.WxOrder;
import com.ec.seller.domain.query.WxOrderQuery;

import java.util.List;

/**
 * Created by yujianming on 2016/5/28.
 */
public interface WxOrderDao {
    /**
     * 添加
     * @param object
     * @return
     */
    public Long insert(WxOrder object);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public WxOrder selectById(Long id);

    /**
     * 修改
     * @param object
     */
    public void modify(WxOrder object);


    /**
     * 根据条件查询总数
     * @param object
     * @return
     */
    public int countByCondition(WxOrderQuery object);

    /**
     * 根据条件查询列表
     * @param object
     * @return
     */
    public List<WxOrder> selectByCondition(WxOrderQuery object);

    public PaginatedList<WxOrder> findPage(WxOrderQuery query);

    public List<WxOrder> getNonePayWxOrder(WxOrderQuery query);

    public List<WxOrder> selectAll(WxOrderQuery object);
}
