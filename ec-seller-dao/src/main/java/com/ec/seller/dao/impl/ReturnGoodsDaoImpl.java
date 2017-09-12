package com.ec.seller.dao.impl;

import com.ec.seller.dao.PurchaseDao;
import com.ec.seller.dao.ReturnGoodsDao;
import com.ec.seller.domain.Purchase;
import com.ec.seller.domain.ReturnGoods;
import com.ec.seller.domain.query.PurchaseQuery;
import com.ec.seller.domain.query.ReturnGoodsQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class ReturnGoodsDaoImpl extends SqlMapClientTemplate implements ReturnGoodsDao {
    @Override
    public Integer insert(ReturnGoods object) {
        return (Integer) insert("ReturnGoods.insert", object);
    }

    @Override
    public void delete(Integer id) {
        delete("ReturnGoods.delete", id);
    }

    @Override
    public void modify(ReturnGoods object) {
        update("ReturnGoods.modify", object);
    }

    @Override
    public ReturnGoods selectById(int id) {
        return (ReturnGoods) queryForObject("ReturnGoods.selectById", id);
    }

    @Override
    public int countByCondition(ReturnGoodsQuery object) {
        return (Integer) queryForObject("ReturnGoods.countByCondition", object);
    }

    @Override
    public List<ReturnGoods> selectByCondition(ReturnGoodsQuery object) {
        return (List<ReturnGoods>)queryForList("ReturnGoods.selectByCondition",object);
    }
}
