package com.ec.seller.service.impl;

import com.ec.seller.dao.ItemDao;
import com.ec.seller.dao.PurchaseItemDao;
import com.ec.seller.domain.Item;
import com.ec.seller.domain.PurchaseItem;
import com.ec.seller.domain.query.PurchaseItemQuery;
import com.ec.seller.service.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="purchaseItemService")
public class PurchaseItemServiceImpl implements PurchaseItemService {

    @Autowired
    private PurchaseItemDao purchaseItemDao;

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<PurchaseItem> findList(PurchaseItemQuery query) {
        return purchaseItemDao.selectByCondition(query);
    }

    @Override
    public void insert(PurchaseItem purchaseItem) {
        Item item = itemDao.selectByItemId(purchaseItem.getItemId());
        if(item == null){
            throw new RuntimeException("该商品不存在");
        }
        purchaseItem.setItemId(item.getItemId());
        purchaseItem.setItemName(item.getItemName());
        purchaseItem.setReferenceUnit(item.getReferenceUnit());//参考进价单位
        purchaseItem.setItemCode(item.getItemCode());
        purchaseItemDao.insert(purchaseItem);
    }

    @Override
    public void delete(Integer id) {
        purchaseItemDao.delete(id);
    }

    @Override
    public PurchaseItem selectById(Integer id) {
        return this.purchaseItemDao.selectById(id);
    }

    @Override
    public void modify(PurchaseItem object) {
        this.purchaseItemDao.modify(object);
    }
}
