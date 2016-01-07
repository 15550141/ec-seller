package com.ec.seller.service.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.PurchaseTemplateDao;
import com.ec.seller.domain.PurchaseTemplate;
import com.ec.seller.domain.query.PurchaseTemplateQuery;
import com.ec.seller.service.PurchaseTemplateService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yujianming on 2016/1/7.
 */
@Service(value="purchaseTemplateService")
public class PurchaseTemplateServiceImpl implements PurchaseTemplateService {

    private final static Log log = LogFactory.getLog(PurchaseTemplateServiceImpl.class);

    @Autowired
    private PurchaseTemplateDao purchaseTemplateDao;

    @Override
    public PaginatedList<PurchaseTemplate> findPage(PurchaseTemplateQuery query) {
        PaginatedList<PurchaseTemplate> list = new PaginatedArrayList<PurchaseTemplate>(query.getPageNo(),query.getPageSize());
        try{
            int count = purchaseTemplateDao.countByCondition(query);
            list.setTotalItem(count);
            int start = list.getStartRow();
            if(start <= 0){
                start = 1;
            }
            query.setStart(start-1);

            list.addAll(purchaseTemplateDao.selectByCondition(query));
        }catch (Exception e){
            log.error("", e);
        }
        return list;
    }

    @Override
    public void insert(PurchaseTemplate purchaseTemplate) {
        try{
            this.purchaseTemplateDao.insert(purchaseTemplate);
        }catch (Exception e){
            log.error("", e);
        }

    }

    @Override
    public void delete(Integer id) {
        try{
            this.purchaseTemplateDao.delete(id);
        }catch (Exception e){
            log.error("", e);
        }
    }

    @Override
    public PurchaseTemplate selectById(Integer id) {
        return this.purchaseTemplateDao.selectById(id);
    }


}
