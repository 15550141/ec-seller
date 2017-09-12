package com.ec.seller.service.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.ItemDao;
import com.ec.seller.dao.ReturnGoodsDao;
import com.ec.seller.domain.ReturnGoods;
import com.ec.seller.domain.query.ReturnGoodsQuery;
import com.ec.seller.service.ReturnGoodsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yujianming on 2016/1/7.
 */
@Service(value="returnGoodsService")
public class ReturnGoodsServiceImpl implements ReturnGoodsService {

    private final static Log log = LogFactory.getLog(ReturnGoodsServiceImpl.class);

    @Autowired
    private ReturnGoodsDao returnGoodsDao;
    @Autowired
    private ItemDao itemDao;

    @Override
    public PaginatedList<ReturnGoods> findPage(ReturnGoodsQuery query) {
        query.setYn(1);
        PaginatedList<ReturnGoods> list = new PaginatedArrayList<ReturnGoods>(query.getPageNo(),query.getPageSize());
        try{
            int count = returnGoodsDao.countByCondition(query);
            list.setTotalItem(count);
            int start = list.getStartRow();
            if(start <= 0){
                start = 1;
            }
            query.setStart(start-1);

            list.addAll(returnGoodsDao.selectByCondition(query));
        }catch (Exception e){
            log.error("", e);
        }
        return list;
    }


    @Override
    public void insert(ReturnGoods object) {
        try{
            this.returnGoodsDao.insert(object);
        }catch (Exception e){
            log.error("", e);
        }
    }

    @Override
    public void delete(Integer id) {
        try{
            ReturnGoods p = new ReturnGoods();
            p.setId(id);
            p.setYn(0);
            this.returnGoodsDao.modify(p);
        }catch (Exception e){
            log.error("", e);
        }
    }

    @Override
    public void modify(ReturnGoods object) {
        this.returnGoodsDao.modify(object);
    }

    @Override
    public ReturnGoods selectById(Integer id) {
        return this.returnGoodsDao.selectById(id);
    }


}
