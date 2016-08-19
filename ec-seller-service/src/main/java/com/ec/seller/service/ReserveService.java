package com.ec.seller.service;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.DailySalesStatistics;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.query.DailySalesStatisticsQuery;
import com.ec.seller.domain.query.ReserveQuery;

public interface ReserveService {
    /**
     * 分页查询
     */
    public PaginatedList<Reserve> findPage(ReserveQuery query);

    public void insert(Reserve object);

    public void delete(Long id);

    public void modify(Reserve object);

    public Reserve selectById(Long id);

}

