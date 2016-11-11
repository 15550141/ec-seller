package com.ec.seller.dao.impl;

import com.ec.seller.dao.StorageItemDao;
import com.ec.seller.domain.StorageItem;
import com.ec.seller.domain.query.StorageItemQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class StorageItemDaoImpl extends SqlMapClientTemplate implements StorageItemDao {
    @Override
    public Integer insert(StorageItem object) {
        return (Integer) insert("StorageItem.insert", object);
    }

    @Override
    public void delete(Integer id) {
        delete("StorageItem.delete", id);
    }

    @Override
    public void modify(StorageItem object) {
        update("StorageItem.modify", object);
    }

    @Override
    public StorageItem selectById(int id) {
        return (StorageItem) queryForObject("StorageItem.selectById", id);
    }

    @Override
    public int countByCondition(StorageItemQuery object) {
        return (Integer) queryForObject("StorageItem.countByCondition", object);
    }

    @Override
    public List<StorageItem> selectByCondition(StorageItemQuery object) {
        return (List<StorageItem>)queryForList("StorageItem.selectByCondition",object);
    }
}
