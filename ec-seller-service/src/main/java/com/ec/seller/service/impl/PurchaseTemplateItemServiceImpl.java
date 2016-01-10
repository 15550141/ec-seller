package com.ec.seller.service.impl;

import com.ec.seller.dao.ItemDao;
import com.ec.seller.dao.PurchaseTemplateItemDao;
import com.ec.seller.domain.Item;
import com.ec.seller.domain.PurchaseTemplate;
import com.ec.seller.domain.PurchaseTemplateItem;
import com.ec.seller.domain.query.ItemQuery;
import com.ec.seller.domain.query.PurchaseTemplateItemQuery;
import com.ec.seller.service.ItemService;
import com.ec.seller.service.PurchaseTemplateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="purchaseTemplateItemService")
public class PurchaseTemplateItemServiceImpl implements PurchaseTemplateItemService {

    @Autowired
    private PurchaseTemplateItemDao purchaseTemplateItemDao;

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<PurchaseTemplateItem> findList(PurchaseTemplateItemQuery query) {
        return purchaseTemplateItemDao.selectByCondition(query);
    }

    @Override
    public void insert(PurchaseTemplateItem purchaseTemplateItem) {
        PurchaseTemplateItemQuery templateItemQuery = new PurchaseTemplateItemQuery();
        templateItemQuery.setItemName(purchaseTemplateItem.getItemName());
        templateItemQuery.setPurchaseTemplateId(purchaseTemplateItem.getPurchaseTemplateId());
        List<PurchaseTemplateItem> purchaseTemplateItemList = this.purchaseTemplateItemDao.selectByCondition(templateItemQuery);
        if(purchaseTemplateItemList != null && purchaseTemplateItemList.size() > 0){
            throw new RuntimeException("已添加该商品");
        }

        List<Item> list = itemDao.selectByItemName(purchaseTemplateItem.getItemName());
        if(list == null || list.size() == 0){
            throw new RuntimeException("该商品不存在");
        }
        purchaseTemplateItem.setItemId(list.get(0).getItemId());
        purchaseTemplateItem.setItemName(list.get(0).getItemName());
        purchaseTemplateItemDao.insert(purchaseTemplateItem);
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
