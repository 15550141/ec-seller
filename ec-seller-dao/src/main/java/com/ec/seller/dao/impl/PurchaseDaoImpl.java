package com.ec.seller.dao.impl;

import com.ec.seller.dao.PurchaseDao;
import com.ec.seller.domain.Purchase;
import com.ec.seller.domain.query.PurchaseQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class PurchaseDaoImpl extends SqlMapClientTemplate implements PurchaseDao {
    @Override
    public Integer insert(Purchase object) {
        return (Integer) insert("Purchase.insert", object);
    }

    @Override
    public void delete(Integer id) {
        delete("Purchase.delete", id);
    }

    @Override
    public void modify(Purchase object) {
        update("Purchase.modify", object);
    }

    @Override
    public Purchase selectById(int id) {
        return (Purchase) queryForObject("Purchase.selectById", id);
    }

    @Override
    public int countByCondition(PurchaseQuery object) {
        return (Integer) queryForObject("Purchase.countByCondition", object);
    }

    @Override
    public List<Purchase> selectByCondition(PurchaseQuery object) {
        return (List<Purchase>)queryForList("Purchase.selectByCondition",object);
    }
}
