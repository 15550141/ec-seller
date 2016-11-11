package com.ec.seller.service.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.*;
import com.ec.seller.domain.*;
import com.ec.seller.domain.query.PurchaseItemQuery;
import com.ec.seller.domain.query.PurchaseQuery;
import com.ec.seller.domain.query.PurchaseTemplateItemQuery;
import com.ec.seller.domain.query.StorageQuery;
import com.ec.seller.service.PurchaseService;
import com.ec.seller.service.StorageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
@Service(value="storageService")
public class StorageServiceImpl implements StorageService {

    private final static Log log = LogFactory.getLog(StorageServiceImpl.class);

    @Autowired
    private PurchaseDao purchaseDao;
    @Autowired
    private PurchaseTemplateDao purchaseTemplateDao;
    @Autowired
    private PurchaseTemplateItemDao purchaseTemplateItemDao;
    @Autowired
    private PurchaseItemDao purchaseItemDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private StorageDao storageDao;
    @Autowired
    private StorageItemDao storageItemDao;

    @Override
    public PaginatedList<Storage> findPage(StorageQuery query) {
        query.setYn(1);
        PaginatedList<Storage> list = new PaginatedArrayList<Storage>(query.getPageNo(),query.getPageSize());
        try{
            int count = storageDao.countByCondition(query);
            list.setTotalItem(count);
            int start = list.getStartRow();
            if(start <= 0){
                start = 1;
            }
            query.setStart(start-1);

            list.addAll(storageDao.selectByCondition(query));
        }catch (Exception e){
            log.error("", e);
        }
        return list;
    }

    @Override
    public Integer insertByPurchase(Integer purchaseId, Integer userId, String loginName) {
        //根据模板id获取模板
        Purchase purchase = purchaseDao.selectById(purchaseId);
        if(purchase == null){
            throw new RuntimeException("采购单不存在");
        }
        //查询模板对应的采购商品列表
        PurchaseItemQuery query = new PurchaseItemQuery();
        query.setPurchaseId(purchaseId);
        List<PurchaseItem> list = purchaseItemDao.selectByCondition(query);
        //创建入库单
        Storage storage = new Storage();
        storage.setPurchaseId(purchaseId);
        storage.setYn(1);
        storage.setPlace("库房1");
        storage.setStatus(0);
        storage.setStorageName(loginName);
        storage.setStorageUid(userId);
        storage.setStorageTime(new Date());

        Integer storageId = storageDao.insert(storage);

        for (PurchaseItem purchaseItem : list ) {
            Item item = itemDao.selectByItemId(purchaseItem.getItemId());
            StorageItem storageItem = new StorageItem();
            storageItem.setItemCode(item.getItemCode());
            storageItem.setItemId(item.getItemId());
            storageItem.setItemName(item.getItemName());
            storageItem.setUnit(item.getUnit());
            storageItem.setStorageId(storageId);
            storageItemDao.insert(storageItem);
        }

        return storageId;
    }

    @Override
    public void insert(Storage object) {
        try{
            this.storageDao.insert(object);
        }catch (Exception e){
            log.error("", e);
        }
    }

    @Override
    public void delete(Integer id) {
        try{
            Storage object = new Storage();
            object.setId(id);
            object.setYn(0);
            this.storageDao.modify(object);
        }catch (Exception e){
            log.error("", e);
        }
    }

    @Override
    public void modify(Storage object) {
        this.storageDao.modify(object);
    }

    @Override
    public Storage selectById(Integer id) {
        return this.storageDao.selectById(id);
    }


}
