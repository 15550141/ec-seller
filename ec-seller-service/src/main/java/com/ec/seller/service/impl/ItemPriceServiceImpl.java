package com.ec.seller.service.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.ItemPriceDao;
import com.ec.seller.domain.ItemPrice;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.query.ItemPriceQuery;
import com.ec.seller.domain.query.ReserveQuery;
import com.ec.seller.service.ItemPriceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
@Service(value="itemPriceService")
public class ItemPriceServiceImpl implements ItemPriceService {

    private final static Log log = LogFactory.getLog(ItemPriceServiceImpl.class);

    @Autowired
    private ItemPriceDao itemPriceDao;

    @Override
    public PaginatedList<ItemPrice> findPage(ItemPriceQuery query) {
        PaginatedList<ItemPrice> list = new PaginatedArrayList<ItemPrice>(query.getPageNo(),query.getPageSize());
        try{
            int count = itemPriceDao.countByCondition(query);
            list.setTotalItem(count);
            int start = list.getStartRow();
            if(start <= 0){
                start = 1;
            }
            query.setStart(start-1);

            list.addAll(itemPriceDao.selectByCondition(query));
        }catch (Exception e){
            log.error("", e);
        }
        return list;
    }

    @Override
    public List<ItemPrice> findList(ItemPriceQuery query) {
        return null;
    }


    @Override
    public void insert(ItemPrice object) {
        this.itemPriceDao.insert(object);
    }

    @Override
    public void delete(Long id) {
        this.itemPriceDao.delete(id);
    }

    @Override
    public ItemPrice selectById(Long id) {
        return this.itemPriceDao.selectById(id);
    }

    @Override
    public void modify(ItemPrice object) {
        this.itemPriceDao.modify(object);
    }


}
