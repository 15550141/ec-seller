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
        PurchaseItemQuery ItemQuery = new PurchaseItemQuery();
        ItemQuery.setItemName(purchaseItem.getItemName());
        List<PurchaseItem> purchaseItemList = this.purchaseItemDao.selectByCondition(ItemQuery);
        if(purchaseItemList != null && purchaseItemList.size() > 0){
            throw new RuntimeException("已添加该商品");
        }

        List<Item> list = itemDao.selectByItemName(purchaseItem.getItemName());
        if(list == null || list.size() == 0){
            throw new RuntimeException("该商品不存在");
        }
        purchaseItem.setItemId(list.get(0).getItemId());
        purchaseItem.setItemName(list.get(0).getItemName());
        purchaseItem.setReferenceStockPrice(list.get(0).getReferenceStockPrice());//参考进价
        purchaseItem.setReferenceUnit(list.get(0).getReferenceUnit());//参考进价单位
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
