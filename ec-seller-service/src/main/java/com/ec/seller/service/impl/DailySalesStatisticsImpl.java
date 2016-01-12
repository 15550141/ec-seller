package com.ec.seller.service.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.DailySalesStatisticsDao;
import com.ec.seller.domain.DailySalesStatistics;
import com.ec.seller.domain.query.DailySalesStatisticsQuery;
import com.ec.seller.service.DailySalesStatisticsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yujianming on 2016/1/7.
 */
@Service(value="dailySalesStatistics")
public class DailySalesStatisticsImpl implements DailySalesStatisticsService {

    private final static Log log = LogFactory.getLog(DailySalesStatisticsImpl.class);

    @Autowired
    private DailySalesStatisticsDao dailySalesStatisticsDao;

    @Override
    public PaginatedList<DailySalesStatistics> findPage(DailySalesStatisticsQuery query) {
        query.setYn(1);
        PaginatedList<DailySalesStatistics> list = new PaginatedArrayList<DailySalesStatistics>(query.getPageNo(),query.getPageSize());
        try{
            int count = dailySalesStatisticsDao.countByCondition(query);
            list.setTotalItem(count);
            int start = list.getStartRow();
            if(start <= 0){
                start = 1;
            }
            query.setStart(start-1);

            list.addAll(dailySalesStatisticsDao.selectByCondition(query));
        }catch (Exception e){
            log.error("", e);
        }
        return list;
    }


    @Override
    public void insert(DailySalesStatistics dailySalesStatistics) {
        this.dailySalesStatisticsDao.insert(dailySalesStatistics);
    }

    @Override
    public void delete(Integer id) {
        this.dailySalesStatisticsDao.delete(id);
    }

    @Override
    public void modify(DailySalesStatistics dailySalesStatistics) {
        this.dailySalesStatisticsDao.modify(dailySalesStatistics);
    }

    @Override
    public DailySalesStatistics selectById(Integer id) {
        return this.dailySalesStatisticsDao.selectById(id);
    }


}
