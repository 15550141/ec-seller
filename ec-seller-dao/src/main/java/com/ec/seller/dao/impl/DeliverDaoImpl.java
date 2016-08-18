package com.ec.seller.dao.impl;

import com.ec.seller.dao.DeliverDao;
import com.ec.seller.domain.Deliver;
import com.ec.seller.domain.query.DeliverQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class DeliverDaoImpl extends SqlMapClientTemplate implements DeliverDao {
    @Override
    public Long insert(Deliver object) {
        return (Long) insert("Deliver.insert", object);
    }

    @Override
    public void delete(Integer id) {
        delete("Deliver.delete", id);
    }

    @Override
    public void modify(Deliver object) {
        update("Deliver.modify", object);
    }

    @Override
    public Deliver selectById(int id) {
        return (Deliver) queryForObject("Deliver.selectById", id);
    }

    @Override
    public int countByCondition(DeliverQuery object) {
        return (Integer) queryForObject("Deliver.countByCondition", object);
    }

    @Override
    public List<Deliver> selectByCondition(DeliverQuery object) {
        return (List<Deliver>)queryForList("Deliver.selectByCondition",object);
    }
}
