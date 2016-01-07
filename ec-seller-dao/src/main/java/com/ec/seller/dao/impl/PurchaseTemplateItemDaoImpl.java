package com.ec.seller.dao.impl;

import com.ec.seller.dao.PurchaseTemplateItemDao;
import com.ec.seller.domain.PurchaseTemplateItem;
import com.ec.seller.domain.query.PurchaseTemplateItemQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class PurchaseTemplateItemDaoImpl extends SqlMapClientTemplate implements PurchaseTemplateItemDao {
    @Override
    public Integer insert(PurchaseTemplateItem object) {
        return (Integer) insert("PurchaseTemplateItem.insert", object);
    }

    @Override
    public void delete(Integer id) {
        delete("PurchaseTemplateItem.delete", id);
    }

    @Override
    public void modify(PurchaseTemplateItem object) {
        update("PurchaseTemplateItem.modify", object);
    }

    @Override
    public PurchaseTemplateItem selectById(int id) {
        return (PurchaseTemplateItem) queryForObject("PurchaseTemplateItem.selectById", id);
    }

    @Override
    public int countByCondition(PurchaseTemplateItemQuery object) {
        return (Integer) queryForObject("PurchaseTemplateItem.countByCondition", object);
    }

    @Override
    public List<PurchaseTemplateItem> selectByCondition(PurchaseTemplateItemQuery object) {
        return (List<PurchaseTemplateItem>)queryForList("PurchaseTemplateItem.selectByCondition",object);
    }
}
