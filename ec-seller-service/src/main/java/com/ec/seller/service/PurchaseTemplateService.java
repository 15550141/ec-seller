package com.ec.seller.service;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.PurchaseTemplate;
import com.ec.seller.domain.query.PurchaseTemplateQuery;

public interface PurchaseTemplateService {
    /** 分页查询 */
    public PaginatedList<PurchaseTemplate> findPage(PurchaseTemplateQuery query);

    public void insert(PurchaseTemplate purchaseTemplate);

    public void delete(Integer id);

    public PurchaseTemplate selectById(Integer id);
}
