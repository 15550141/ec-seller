package com.ec.seller.dao.impl;

import com.ec.seller.dao.StorageDao;
import com.ec.seller.domain.Storage;
import com.ec.seller.domain.query.StorageQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class StorageDaoImpl extends SqlMapClientTemplate implements StorageDao {
    @Override
    public Integer insert(Storage object) {
        return (Integer) insert("Storage.insert", object);
    }

    @Override
    public void delete(Integer id) {
        delete("Storage.delete", id);
    }

    @Override
    public void modify(Storage object) {
        update("Storage.modify", object);
    }

    @Override
    public Storage selectById(int id) {
        return (Storage) queryForObject("Storage.selectById", id);
    }

    @Override
    public int countByCondition(StorageQuery object) {
        return (Integer) queryForObject("Storage.countByCondition", object);
    }

    @Override
    public List<Storage> selectByCondition(StorageQuery object) {
        return (List<Storage>)queryForList("Storage.selectByCondition",object);
    }
}
