package com.ec.seller.service;

import com.ec.seller.domain.ReturnGoodsItem;
import com.ec.seller.domain.query.ReturnGoodsItemQuery;

import java.util.List;

public interface ReturnGoodsItemService {

    public List<ReturnGoodsItem> findList(ReturnGoodsItemQuery query);

    public void insert(ReturnGoodsItem object);

    public void delete(Integer id);

    public ReturnGoodsItem selectById(Integer id);

    /**
     * 修改
     * @param object
     */
    public void modify(ReturnGoodsItem object);
}
