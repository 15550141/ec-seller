package com.ec.seller.service;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.ActivityExchange;
import com.ec.seller.domain.query.ActivityExchangeQuery;

public interface ActivityExchangeService {
    /**
     * 分页查询
     */
    public PaginatedList<ActivityExchange> findPage(ActivityExchangeQuery query);

    public void insert(ActivityExchange object);

    public void delete(Long id);

    public void modify(ActivityExchange object);

    public ActivityExchange selectById(Long id);

}

