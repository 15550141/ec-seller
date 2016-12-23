package com.ec.seller.service.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.CooperationBusinessDao;
import com.ec.seller.domain.CooperationBusiness;
import com.ec.seller.domain.query.CooperationBusinessQuery;
import com.ec.seller.service.CooperationBusinessService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yujianming on 2016/1/7.
 */
@Service(value="cooperationBusinessService")
public class CooperationBusinessServiceImpl implements CooperationBusinessService {

    private final static Log log = LogFactory.getLog(CooperationBusinessServiceImpl.class);

    @Autowired
    private CooperationBusinessDao cooperationBusinessDao;

    @Override
    public PaginatedList<CooperationBusiness> findPage(CooperationBusinessQuery query) {
        PaginatedList<CooperationBusiness> list = new PaginatedArrayList<CooperationBusiness>(query.getPageNo(),query.getPageSize());
        try{
            int count = cooperationBusinessDao.countByCondition(query);
            list.setTotalItem(count);
            int start = list.getStartRow();
            if(start <= 0){
                start = 1;
            }
            query.setStart(start-1);

            list.addAll(cooperationBusinessDao.selectByCondition(query));
        }catch (Exception e){
            log.error("", e);
        }
        return list;
    }


    @Override
    public void insert(CooperationBusiness object) {
        this.cooperationBusinessDao.insert(object);
    }

    @Override
    public void delete(Long id) {
        this.cooperationBusinessDao.delete(id);
    }

    @Override
    public void modify(CooperationBusiness object) {
        this.cooperationBusinessDao.modify(object);
    }

    @Override
    public CooperationBusiness selectById(Long id) {
        return this.cooperationBusinessDao.selectById(id);
    }


}
