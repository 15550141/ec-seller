package com.ec.seller.dao.impl;

import com.ec.seller.dao.DeliverItemDao;
import com.ec.seller.dao.ReserveDao;
import com.ec.seller.domain.DeliverItem;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.query.DeliverItemQuery;
import com.ec.seller.domain.query.ReserveQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class ReserveDaoImpl extends SqlMapClientTemplate implements ReserveDao {
    @Override
    public Long insert(Reserve object) {
        return (Long) insert("Reserve.insert", object);
    }

    @Override
    public void delete(Long id) {
        delete("Reserve.delete", id);
    }

    @Override
    public void modify(Reserve object) {
        update("Reserve.modify", object);
    }

    @Override
    public Reserve selectById(Long id) {
        return (Reserve) queryForObject("Reserve.selectById", id);
    }

    @Override
    public int countByCondition(ReserveQuery object) {
        return (Integer) queryForObject("Reserve.countByCondition", object);
    }

    @Override
    public List<Reserve> selectByCondition(ReserveQuery object) {
        return (List<Reserve>)queryForList("Reserve.selectByCondition",object);
    }
}
