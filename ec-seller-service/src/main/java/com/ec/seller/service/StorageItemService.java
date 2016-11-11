package com.ec.seller.service;

import com.ec.seller.domain.StorageItem;
import com.ec.seller.domain.query.StorageItemQuery;

import java.util.List;

public interface StorageItemService {

    public List<StorageItem> findList(StorageItemQuery query);

    public void insert(StorageItem object);

    public void delete(Integer id);

    public StorageItem selectById(Integer id);

    /**
     * 修改
     * @param object
     */
    public void modify(StorageItem object);
}
