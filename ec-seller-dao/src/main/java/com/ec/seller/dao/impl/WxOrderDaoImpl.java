package com.ec.seller.dao.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.WxOrderDao;
import com.ec.seller.domain.DailySalesStatistics;
import com.ec.seller.domain.WxOrder;
import com.ec.seller.domain.query.DailySalesStatisticsQuery;
import com.ec.seller.domain.query.WxOrderQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/5/28.
 */
public class WxOrderDaoImpl  extends SqlMapClientTemplate implements WxOrderDao {
    @Override
    public Long insert(WxOrder object) {
        return (Long) insert("WxOrder.insert", object);
    }

    @Override
    public WxOrder selectById(Long id) {
        return (WxOrder) queryForObject("WxOrder.selectById", id);
    }

    @Override
    public void modify(WxOrder object) {
        update("WxOrder.modify", object);
    }

    @Override
    public int countByCondition(WxOrderQuery object) {
        return (Integer) queryForObject("WxOrder.countByCondition", object);
    }

    @Override
    public PaginatedList<WxOrder> findPage(WxOrderQuery query) {
        query.setYn(1);
        PaginatedList<WxOrder> list = new PaginatedArrayList<WxOrder>(query.getPageNo(),query.getPageSize());
        try{
            int count = this.countByCondition(query);
            list.setTotalItem(count);
            int start = list.getStartRow();
            if(start <= 0){
                start = 1;
            }
            query.setStart(start-1);

            list.addAll(this.selectByCondition(query));
        }catch (Exception e){
            logger.error("", e);
        }
        return list;
    }

    @Override
    public List<WxOrder> getNonePayWxOrder(WxOrderQuery query) {
        return (List<WxOrder>)queryForList("WxOrder.getNonePayWxOrder", query);
    }

    @Override
    public List<WxOrder> selectByCondition(WxOrderQuery object) {
        return (List<WxOrder>)queryForList("WxOrder.selectByCondition",object);
    }
}