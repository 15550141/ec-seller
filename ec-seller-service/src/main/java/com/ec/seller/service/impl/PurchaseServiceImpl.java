package com.ec.seller.service.impl;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.common.utils.impl.PaginatedArrayList;
import com.ec.seller.dao.*;
import com.ec.seller.domain.*;
import com.ec.seller.domain.query.PurchaseQuery;
import com.ec.seller.domain.query.PurchaseTemplateItemQuery;
import com.ec.seller.service.PurchaseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
@Service(value="purchaseService")
public class PurchaseServiceImpl implements PurchaseService {

    private final static Log log = LogFactory.getLog(PurchaseServiceImpl.class);

    @Autowired
    private PurchaseDao purchaseDao;
    @Autowired
    private PurchaseTemplateDao purchaseTemplateDao;
    @Autowired
    private PurchaseTemplateItemDao purchaseTemplateItemDao;
    @Autowired
    private PurchaseItemDao purchaseItemDao;
    @Autowired
    private ItemDao itemDao;

    @Override
    public PaginatedList<Purchase> findPage(PurchaseQuery query) {
        query.setYn(1);
        PaginatedList<Purchase> list = new PaginatedArrayList<Purchase>(query.getPageNo(),query.getPageSize());
        try{
            int count = purchaseDao.countByCondition(query);
            list.setTotalItem(count);
            int start = list.getStartRow();
            if(start <= 0){
                start = 1;
            }
            query.setStart(start-1);

            list.addAll(purchaseDao.selectByCondition(query));
        }catch (Exception e){
            log.error("", e);
        }
        return list;
    }

    @Override
    public Integer insertByTemplate(Integer purchaseTemplateId, Integer userId, String loginName) {
        //根据模板id获取模板
        PurchaseTemplate template = purchaseTemplateDao.selectById(purchaseTemplateId);
        if(template == null){
            throw new RuntimeException("模板不存在");
        }
        //查询模板对应的采购商品列表
        PurchaseTemplateItemQuery query = new PurchaseTemplateItemQuery();
        query.setPurchaseTemplateId(purchaseTemplateId);
        List<PurchaseTemplateItem> list = purchaseTemplateItemDao.selectByCondition(query);
        //创建采购单
        Purchase purchase = new Purchase();
        purchase.setPurchaseUid(userId);
        purchase.setPurchaseName(loginName);
        purchase.setPurchaseTime(new Date());
        purchase.setPurchasePlace(template.getPurchasePlace());
        purchase.setStatus(0);//新建状态
        purchase.setYn(1);

        purchaseDao.insert(purchase);

        for (PurchaseTemplateItem templateItem : list ) {
            Item item = itemDao.selectByItemId(templateItem.getItemId());
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setPurchaseId(purchase.getId());
            purchaseItem.setItemId(templateItem.getItemId());
            purchaseItem.setItemName(templateItem.getItemName());
            purchaseItem.setReferenceUnit(item.getReferenceUnit());
            purchaseItem.setPrice(BigDecimal.ZERO);
            purchaseItem.setNum(0d);
            purchaseItem.setTotalPrice(BigDecimal.ZERO);
            purchaseItemDao.insert(purchaseItem);
        }

        return purchase.getId();
    }

    @Override
    public void insert(Purchase purchase) {
        try{
            this.purchaseDao.insert(purchase);
        }catch (Exception e){
            log.error("", e);
        }
    }

    @Override
    public void delete(Integer id) {
        try{
            Purchase p = new Purchase();
            p.setId(id);
            p.setYn(0);
            this.purchaseDao.modify(p);
        }catch (Exception e){
            log.error("", e);
        }
    }

    @Override
    public void modify(Purchase purchase) {
        this.purchaseDao.modify(purchase);
    }

    @Override
    public Purchase selectById(Integer id) {
        return this.purchaseDao.selectById(id);
    }


}
