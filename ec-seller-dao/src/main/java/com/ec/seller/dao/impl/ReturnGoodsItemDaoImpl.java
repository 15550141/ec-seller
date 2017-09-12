package com.ec.seller.dao.impl;

import com.ec.seller.dao.ReturnGoodsItemDao;
import com.ec.seller.domain.ReturnGoodsItem;
import com.ec.seller.domain.query.ReturnGoodsItemQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class ReturnGoodsItemDaoImpl extends SqlMapClientTemplate implements ReturnGoodsItemDao {
    @Override
    public Integer insert(ReturnGoodsItem object) {
        return (Integer) insert("ReturnGoodsItem.insert", object);
    }

    @Override
    public void delete(Integer id) {
        delete("ReturnGoodsItem.delete", id);
    }

    @Override
    public void modify(ReturnGoodsItem object) {
        update("ReturnGoodsItem.modify", object);
    }

    @Override
    public ReturnGoodsItem selectById(int id) {
        return (ReturnGoodsItem) queryForObject("ReturnGoodsItem.selectById", id);
    }

    @Override
    public int countByCondition(ReturnGoodsItemQuery object) {
        return (Integer) queryForObject("ReturnGoodsItem.countByCondition", object);
    }

    @Override
    public List<ReturnGoodsItem> selectByCondition(ReturnGoodsItemQuery object) {
        return (List<ReturnGoodsItem>)queryForList("ReturnGoodsItem.selectByCondition",object);
    }
}
