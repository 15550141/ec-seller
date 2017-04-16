package com.ec.seller.dao.impl;

import com.ec.seller.dao.ItemPriceDao;
import com.ec.seller.domain.ItemPrice;
import com.ec.seller.domain.query.ItemPriceQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class ItemPriceDaoImpl extends SqlMapClientTemplate implements ItemPriceDao {
    @Override
    public Long insert(ItemPrice object) {
        return (Long) insert("ItemPrice.insert", object);
    }

    @Override
    public void delete(Long id) {
        delete("ItemPrice.delete", id);
    }

    @Override
    public void modify(ItemPrice object) {
        update("ItemPrice.modify", object);
    }

    @Override
    public ItemPrice selectById(Long id) {
        return (ItemPrice) queryForObject("ItemPrice.selectById", id);
    }

    @Override
    public int countByCondition(ItemPriceQuery object) {
        return (Integer) queryForObject("ItemPrice.countByCondition", object);
    }

    @Override
    public List<ItemPrice> selectByCondition(ItemPriceQuery object) {
        return (List<ItemPrice>)queryForList("ItemPrice.selectByCondition",object);
    }
}
