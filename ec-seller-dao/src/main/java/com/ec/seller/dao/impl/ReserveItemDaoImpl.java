package com.ec.seller.dao.impl;

import com.ec.seller.dao.ReserveDao;
import com.ec.seller.dao.ReserveItemDao;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.ReserveItem;
import com.ec.seller.domain.query.ReserveItemQuery;
import com.ec.seller.domain.query.ReserveQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class ReserveItemDaoImpl extends SqlMapClientTemplate implements ReserveItemDao {
    @Override
    public Long insert(ReserveItem object) {
        return (Long) insert("ReserveItem.insert", object);
    }

    @Override
    public void delete(Long id) {
        delete("ReserveItem.delete", id);
    }

    @Override
    public void modify(ReserveItem object) {
        update("ReserveItem.modify", object);
    }

    @Override
    public ReserveItem selectById(Long id) {
        return (ReserveItem) queryForObject("ReserveItem.selectById", id);
    }

    @Override
    public int countByCondition(ReserveItemQuery object) {
        return (Integer) queryForObject("ReserveItem.countByCondition", object);
    }

    @Override
    public List<ReserveItem> selectByCondition(ReserveItemQuery object) {
        return (List<ReserveItem>)queryForList("ReserveItem.selectByCondition",object);
    }
}
