package com.ec.seller.dao.impl;

import com.ec.seller.dao.DeliverDao;
import com.ec.seller.dao.DeliverItemDao;
import com.ec.seller.domain.Deliver;
import com.ec.seller.domain.DeliverItem;
import com.ec.seller.domain.query.DeliverItemQuery;
import com.ec.seller.domain.query.DeliverQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class DeliverItemDaoImpl extends SqlMapClientTemplate implements DeliverItemDao {
    @Override
    public Integer insert(DeliverItem object) {
        return (Integer) insert("DeliverItem.insert", object);
    }

    @Override
    public void delete(Integer id) {
        delete("DeliverItem.delete", id);
    }

    @Override
    public void modify(DeliverItem object) {
        update("DeliverItem.modify", object);
    }

    @Override
    public DeliverItem selectById(int id) {
        return (DeliverItem) queryForObject("DeliverItem.selectById", id);
    }

    @Override
    public int countByCondition(DeliverItemQuery object) {
        return (Integer) queryForObject("DeliverItem.countByCondition", object);
    }

    @Override
    public List<DeliverItem> selectByCondition(DeliverItemQuery object) {
        return (List<DeliverItem>)queryForList("DeliverItem.selectByCondition",object);
    }
}
