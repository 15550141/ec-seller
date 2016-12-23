package com.ec.seller.dao.impl;

import com.ec.seller.dao.CooperationBusinessDao;
import com.ec.seller.domain.CooperationBusiness;
import com.ec.seller.domain.query.CooperationBusinessQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by yujianming on 2016/1/7.
 */
public class CooperationBusinessDaoImpl extends SqlMapClientTemplate implements CooperationBusinessDao {

    @Override
    public Long insert(CooperationBusiness object) {
        return (Long) insert("CooperationBusiness.insert", object);
    }

    @Override
    public void delete(Long id) {
        delete("CooperationBusiness.delete", id);
    }

    @Override
    public void modify(CooperationBusiness object) {
        update("CooperationBusiness.modify", object);
    }

    @Override
    public CooperationBusiness selectById(Long id) {
        return (CooperationBusiness) queryForObject("CooperationBusiness.selectById", id);
    }

    @Override
    public int countByCondition(CooperationBusinessQuery object) {
        return (Integer) queryForObject("CooperationBusiness.countByCondition", object);
    }

    @Override
    public List<CooperationBusiness> selectByCondition(CooperationBusinessQuery object) {
        return (List<CooperationBusiness>)queryForList("CooperationBusiness.selectByCondition",object);
    }
}
