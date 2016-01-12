package com.ec.seller.service;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.DailySalesStatistics;
import com.ec.seller.domain.Purchase;
import com.ec.seller.domain.query.DailySalesStatisticsQuery;
import com.ec.seller.domain.query.PurchaseQuery;

public interface DailySalesStatisticsService {
    /**
     * 分页查询
     */
    public PaginatedList<DailySalesStatistics> findPage(DailySalesStatisticsQuery query);

    public void insert(DailySalesStatistics sales);

    public void delete(Integer id);

    public void modify(DailySalesStatistics sales);

    public DailySalesStatistics selectById(Integer id);

}

