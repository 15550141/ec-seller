package com.ec.seller.dao.impl;

import com.ec.seller.dao.PurchaseTemplateDao;
import com.ec.seller.domain.PurchaseTemplate;
import com.ec.seller.domain.query.PurchaseTemplateQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class PurchaseTemplateDaoImpl extends SqlMapClientTemplate implements PurchaseTemplateDao {
    @Override
    public Integer insert(PurchaseTemplate object) {
        return (Integer) insert("PurchaseTemplate.insert", object);
    }

    @Override
    public void delete(Integer id) {
        delete("PurchaseTemplate.delete", id);
    }

    @Override
    public void modify(PurchaseTemplate object) {
        update("PurchaseTemplate.modify", object);
    }

    @Override
    public PurchaseTemplate selectById(int id) {
        return (PurchaseTemplate) queryForObject("PurchaseTemplate.selectById", id);
    }

    @Override
    public int countByCondition(PurchaseTemplateQuery object) {
        return (Integer) queryForObject("PurchaseTemplateQuery.countByCondition", object);
    }

    @Override
    public List<PurchaseTemplate> selectByCondition(PurchaseTemplateQuery object) {
        return (List<PurchaseTemplate>)queryForList("PurchaseTemplate.selectByCondition",object);
    }
}
