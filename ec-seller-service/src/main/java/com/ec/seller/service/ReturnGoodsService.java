package com.ec.seller.service;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.ReturnGoods;
import com.ec.seller.domain.query.ReturnGoodsQuery;

public interface ReturnGoodsService {
    /**
     * 分页查询
     */
    public PaginatedList<ReturnGoods> findPage(ReturnGoodsQuery query);

    public void insert(ReturnGoods object);

    public void delete(Integer id);

    public void modify(ReturnGoods object);

    public ReturnGoods selectById(Integer id);

}

