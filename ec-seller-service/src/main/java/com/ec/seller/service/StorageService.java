package com.ec.seller.service;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.Storage;
import com.ec.seller.domain.query.StorageQuery;

public interface StorageService {
    /**
     * 分页查询
     */
    public PaginatedList<Storage> findPage(StorageQuery query);

    public void insert(Storage object);

    public void delete(Integer id);

    public void modify(Storage object);

    public Storage selectById(Integer id);

    public Integer insertByPurchase(Integer purchaseId, Integer userId, String loginName);

}

