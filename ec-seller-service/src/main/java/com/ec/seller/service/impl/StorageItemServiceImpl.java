package com.ec.seller.service.impl;

import com.ec.seller.dao.ItemDao;
import com.ec.seller.dao.PurchaseItemDao;
import com.ec.seller.dao.StorageItemDao;
import com.ec.seller.domain.Item;
import com.ec.seller.domain.PurchaseItem;
import com.ec.seller.domain.StorageItem;
import com.ec.seller.domain.query.PurchaseItemQuery;
import com.ec.seller.domain.query.StorageItemQuery;
import com.ec.seller.service.PurchaseItemService;
import com.ec.seller.service.StorageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="storageItemService")
public class StorageItemServiceImpl implements StorageItemService {

    @Autowired
    private PurchaseItemDao purchaseItemDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private StorageItemDao storageItemDao;

    @Override
    public List<StorageItem> findList(StorageItemQuery query) {
        return storageItemDao.selectByCondition(query);
    }

    @Override
    public void insert(StorageItem storageItem) {
        Item item = itemDao.selectByItemId(storageItem.getItemId());
        if(item == null){
            throw new RuntimeException("该商品不存在");
        }
        storageItem.setItemId(item.getItemId());
        storageItem.setItemName(item.getItemName());
        storageItem.setItemCode(item.getItemCode());
        storageItemDao.insert(storageItem);
    }

    @Override
    public void delete(Integer id) {
        storageItemDao.delete(id);
    }

    @Override
    public StorageItem selectById(Integer id) {
        return this.storageItemDao.selectById(id);
    }

    @Override
    public void modify(StorageItem object) {
        this.storageItemDao.modify(object);
    }
}
