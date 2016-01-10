package com.ec.seller.service;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.Purchase;
import com.ec.seller.domain.PurchaseTemplate;
import com.ec.seller.domain.query.PurchaseQuery;
import com.ec.seller.domain.query.PurchaseTemplateQuery;

public interface PurchaseService {
    /**
     * 分页查询
     */
    public PaginatedList<Purchase> findPage(PurchaseQuery query);

    public void insert(Purchase purchase);

    public void delete(Integer id);

    public void modify(Purchase purchase);

    public Purchase selectById(Integer id);

    public Integer insertByTemplate(Integer purchaseTemplateId, Integer userId, String loginName);

}

