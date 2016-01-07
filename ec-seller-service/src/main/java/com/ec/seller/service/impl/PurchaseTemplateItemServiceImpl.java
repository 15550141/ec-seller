package com.ec.seller.service.impl;

import com.ec.seller.dao.PurchaseTemplateItemDao;
import com.ec.seller.domain.PurchaseTemplate;
import com.ec.seller.domain.PurchaseTemplateItem;
import com.ec.seller.domain.query.PurchaseTemplateItemQuery;
import com.ec.seller.service.PurchaseTemplateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="purchaseTemplateItemService")
public class PurchaseTemplateItemServiceImpl implements PurchaseTemplateItemService {

    @Autowired
    private PurchaseTemplateItemDao purchaseTemplateItemDao;

    @Override
    public List<PurchaseTemplateItem> findList(PurchaseTemplateItemQuery query) {
        return purchaseTemplateItemDao.selectByCondition(query);
    }

    @Override
    public void insert(PurchaseTemplateItem purchaseTemplate) {
        purchaseTemplateItemDao.insert(purchaseTemplate);
    }

    @Override
    public void delete(Integer id) {
        purchaseTemplateItemDao.delete(id);
    }

    @Override
    public PurchaseTemplateItem selectById(Integer id) {
        return this.purchaseTemplateItemDao.selectById(id);
    }
}
