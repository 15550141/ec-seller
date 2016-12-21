package com.ec.seller.service.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.ActivityExchangeDao;
import com.ec.seller.domain.ActivityExchange;
import com.ec.seller.domain.query.ActivityExchangeQuery;
import com.ec.seller.service.ActivityExchangeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yujianming on 2016/1/7.
 */
@Service(value="activityExchangeService")
public class ActivityExchangeServiceImpl implements ActivityExchangeService {

    private final static Log log = LogFactory.getLog(ActivityExchangeServiceImpl.class);

    @Autowired
    private ActivityExchangeDao activityExchangeDao;

    @Override
    public PaginatedList<ActivityExchange> findPage(ActivityExchangeQuery query) {
        PaginatedList<ActivityExchange> list = new PaginatedArrayList<ActivityExchange>(query.getPageNo(),query.getPageSize());
        try{
            int count = activityExchangeDao.countByCondition(query);
            list.setTotalItem(count);
            int start = list.getStartRow();
            if(start <= 0){
                start = 1;
            }
            query.setStart(start-1);

            list.addAll(activityExchangeDao.selectByCondition(query));
        }catch (Exception e){
            log.error("", e);
        }
        return list;
    }


    @Override
    public void insert(ActivityExchange object) {
        this.activityExchangeDao.insert(object);
    }

    @Override
    public void delete(Long id) {
        this.activityExchangeDao.delete(id);
    }

    @Override
    public void modify(ActivityExchange object) {
        this.activityExchangeDao.modify(object);
    }

    @Override
    public ActivityExchange selectById(Long id) {
        return this.activityExchangeDao.selectById(id);
    }


}
