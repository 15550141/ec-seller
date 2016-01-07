package com.ec.seller.dao.impl;

import com.ec.seller.dao.PurchaseItemDao;
import com.ec.seller.domain.PurchaseItem;
import com.ec.seller.domain.query.PurchaseItemQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class PurchaseItemDaoImpl extends SqlMapClientTemplate implements PurchaseItemDao {
    @Override
    public Integer insert(PurchaseItem object) {
        return (Integer) insert("PurchaseItem.insert", object);
    }

    @Override
    public void delete(Integer id) {
        delete("PurchaseItem.delete", id);
    }

    @Override
    public void modify(PurchaseItem object) {
        update("PurchaseItem.modify", object);
    }

    @Override
    public PurchaseItem selectById(int id) {
        return (PurchaseItem) queryForObject("PurchaseItem.selectById", id);
    }

    @Override
    public int countByCondition(PurchaseItemQuery object) {
        return (Integer) queryForObject("PurchaseItem.countByCondition", object);
    }

    @Override
    public List<PurchaseItem> selectByCondition(PurchaseItemQuery object) {
        return (List<PurchaseItem>)queryForList("PurchaseItem.selectByCondition",object);
    }
}
