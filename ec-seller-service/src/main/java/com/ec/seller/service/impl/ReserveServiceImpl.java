package com.ec.seller.service.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.ReserveDao;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.query.ReserveQuery;
import com.ec.seller.service.ReserveService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yujianming on 2016/1/7.
 */
@Service(value="reserveService")
public class ReserveServiceImpl implements ReserveService {

    private final static Log log = LogFactory.getLog(ReserveServiceImpl.class);

    @Autowired
    private ReserveDao reserveDao;

    @Override
    public PaginatedList<Reserve> findPage(ReserveQuery query) {
        PaginatedList<Reserve> list = new PaginatedArrayList<Reserve>(query.getPageNo(),query.getPageSize());
        try{
            int count = reserveDao.countByCondition(query);
            list.setTotalItem(count);
            int start = list.getStartRow();
            if(start <= 0){
                start = 1;
            }
            query.setStart(start-1);

            list.addAll(reserveDao.selectByCondition(query));
        }catch (Exception e){
            log.error("", e);
        }
        return list;
    }


    @Override
    public void insert(Reserve object) {
        this.reserveDao.insert(object);
    }

    @Override
    public void delete(Long id) {
        this.reserveDao.delete(id);
    }

    @Override
    public void modify(Reserve object) {
        this.reserveDao.modify(object);
    }

    @Override
    public Reserve selectById(Integer id) {
        return this.reserveDao.selectById(id);
    }


}
