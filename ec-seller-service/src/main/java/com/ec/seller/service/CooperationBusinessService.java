package com.ec.seller.service;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.CooperationBusiness;
import com.ec.seller.domain.query.CooperationBusinessQuery;

public interface CooperationBusinessService {
    /**
     * 分页查询
     */
    public PaginatedList<CooperationBusiness> findPage(CooperationBusinessQuery query);

    public void insert(CooperationBusiness object);

    public void delete(Long id);

    public void modify(CooperationBusiness object);

    public CooperationBusiness selectById(Long id);

}

