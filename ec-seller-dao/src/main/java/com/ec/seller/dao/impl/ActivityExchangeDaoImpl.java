package com.ec.seller.dao.impl;

import com.ec.seller.dao.ActivityExchangeDao;
import com.ec.seller.domain.ActivityExchange;
import com.ec.seller.domain.query.ActivityExchangeQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class ActivityExchangeDaoImpl extends SqlMapClientTemplate implements ActivityExchangeDao {

    @Override
    public Long insert(ActivityExchange object) {
        return (Long) insert("ActivityExchange.insert", object);
    }

    @Override
    public void delete(Long id) {
        delete("ActivityExchange.delete", id);
    }

    @Override
    public void modify(ActivityExchange object) {
        update("ActivityExchange.modify", object);
    }

    @Override
    public ActivityExchange selectById(Long id) {
        return (ActivityExchange) queryForObject("ActivityExchange.selectById", id);
    }

    @Override
    public int countByCondition(ActivityExchangeQuery object) {
        return (Integer) queryForObject("ActivityExchange.countByCondition", object);
    }

    @Override
    public List<ActivityExchange> selectByCondition(ActivityExchangeQuery object) {
        return (List<ActivityExchange>)queryForList("ActivityExchange.selectByCondition",object);
    }
}
