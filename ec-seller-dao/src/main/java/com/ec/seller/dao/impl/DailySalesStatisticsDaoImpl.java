package com.ec.seller.dao.impl;

import com.ec.seller.dao.DailySalesStatisticsDao;
import com.ec.seller.dao.PurchaseDao;
import com.ec.seller.domain.DailySalesStatistics;
import com.ec.seller.domain.Purchase;
import com.ec.seller.domain.query.DailySalesStatisticsQuery;
import com.ec.seller.domain.query.PurchaseQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class DailySalesStatisticsDaoImpl extends SqlMapClientTemplate implements DailySalesStatisticsDao {
    @Override
    public Integer insert(DailySalesStatistics object) {
        return (Integer) insert("DailySalesStatistics.insert", object);
    }

    @Override
    public void delete(Integer id) {
        delete("DailySalesStatistics.delete", id);
    }

    @Override
    public void modify(DailySalesStatistics object) {
        update("DailySalesStatistics.modify", object);
    }

    @Override
    public DailySalesStatistics selectById(int id) {
        return (DailySalesStatistics) queryForObject("DailySalesStatistics.selectById", id);
    }

    @Override
    public int countByCondition(DailySalesStatisticsQuery object) {
        return (Integer) queryForObject("DailySalesStatistics.countByCondition", object);
    }

    @Override
    public List<DailySalesStatistics> selectByCondition(DailySalesStatisticsQuery object) {
        return (List<DailySalesStatistics>)queryForList("DailySalesStatistics.selectByCondition",object);
    }
}
