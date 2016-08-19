package com.ec.seller.service;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.Deliver;
import com.ec.seller.domain.query.DeliverQuery;

public interface DeliverService {
    /**
     * 分页查询
     */
    public PaginatedList<Deliver> findPage(DeliverQuery query);

    public Long insert(Deliver object);

    public void delete(Long id);

    public void modify(Deliver object);

    public Deliver selectById(Long id);

}

