package com.ec.seller.service;

import com.ec.seller.domain.PurchaseTemplateItem;
import com.ec.seller.domain.query.PurchaseTemplateItemQuery;

import java.util.List;

public interface PurchaseTemplateItemService {

    public List<PurchaseTemplateItem> findList(PurchaseTemplateItemQuery query);

    public void insert(PurchaseTemplateItem purchaseTemplate);

    public void delete(Integer id);

    public PurchaseTemplateItem selectById(Integer id);
}
