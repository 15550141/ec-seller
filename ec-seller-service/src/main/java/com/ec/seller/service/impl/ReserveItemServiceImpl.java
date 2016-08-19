package com.ec.seller.service.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.ReserveDao;
import com.ec.seller.dao.ReserveItemDao;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.ReserveItem;
import com.ec.seller.domain.query.ReserveItemQuery;
import com.ec.seller.domain.query.ReserveQuery;
import com.ec.seller.service.ReserveItemService;
import com.ec.seller.service.ReserveService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
@Service(value="reserveItemService")
public class ReserveItemServiceImpl implements ReserveItemService {

    private final static Log log = LogFactory.getLog(ReserveItemServiceImpl.class);

    @Autowired
    private ReserveItemDao reserveItemDao;

    @Override
    public List<ReserveItem> findList(ReserveItemQuery query) {
        return null;
    }


    @Override
    public void insert(ReserveItem object) {
        this.reserveItemDao.insert(object);
    }

    @Override
    public void delete(Long id) {
        this.reserveItemDao.delete(id);
    }

    @Override
    public ReserveItem selectById(Long id) {
        return this.reserveItemDao.selectById(id);
    }


}
