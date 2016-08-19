package com.ec.seller.service.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.DeliverDao;
import com.ec.seller.dao.ReserveDao;
import com.ec.seller.domain.Deliver;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.query.DeliverQuery;
import com.ec.seller.domain.query.ReserveQuery;
import com.ec.seller.service.DeliverService;
import com.ec.seller.service.ReserveService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yujianming on 2016/1/7.
 */
@Service(value="deliverService")
public class DeliverServiceImpl implements DeliverService {

    private final static Log log = LogFactory.getLog(DeliverServiceImpl.class);

    @Autowired
    private DeliverDao DeliverDao;

    @Override
    public PaginatedList<Deliver> findPage(DeliverQuery query) {
        PaginatedList<Deliver> list = new PaginatedArrayList<Deliver>(query.getPageNo(),query.getPageSize());
        try{
            int count = DeliverDao.countByCondition(query);
            list.setTotalItem(count);
            int start = list.getStartRow();
            if(start <= 0){
                start = 1;
            }
            query.setStart(start-1);

            list.addAll(DeliverDao.selectByCondition(query));
        }catch (Exception e){
            log.error("", e);
        }
        return list;
    }


    @Override
    public Long insert(Deliver object) {
        return this.DeliverDao.insert(object);
    }

    @Override
    public void delete(Long id) {
        this.DeliverDao.delete(id);
    }

    @Override
    public void modify(Deliver object) {
        this.DeliverDao.modify(object);
    }

    @Override
    public Deliver selectById(Long id) {
        return this.DeliverDao.selectById(id);
    }


}
