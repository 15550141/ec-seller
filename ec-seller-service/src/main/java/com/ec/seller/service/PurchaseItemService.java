package com.ec.seller.service;

import com.ec.seller.domain.PurchaseItem;
import com.ec.seller.domain.query.PurchaseItemQuery;

import java.util.List;

public interface PurchaseItemService {

    public List<PurchaseItem> findList(PurchaseItemQuery query);

    public void insert(PurchaseItem purchaseItem);

    public void delete(Integer id);

    public PurchaseItem selectById(Integer id);

    /**
     * 修改
     * @param object
     */
    public void modify(PurchaseItem object);
}
