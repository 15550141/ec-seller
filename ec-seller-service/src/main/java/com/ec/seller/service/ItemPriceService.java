package com.ec.seller.service;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.ItemPrice;
import com.ec.seller.domain.query.ItemPriceQuery;

import java.util.List;

public interface ItemPriceService {

    /**
     * 分页查询
     */
    public PaginatedList<ItemPrice> findPage(ItemPriceQuery query);

    public List<ItemPrice> findList(ItemPriceQuery query);

    public void insert(ItemPrice object);

    public void delete(Long id);

    public ItemPrice selectById(Long id);

    public void modify(ItemPrice object);
}

