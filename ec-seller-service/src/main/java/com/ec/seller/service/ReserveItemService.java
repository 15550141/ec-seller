package com.ec.seller.service;

import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.ReserveItem;
import com.ec.seller.domain.query.ReserveItemQuery;
import com.ec.seller.domain.query.ReserveQuery;

import java.util.List;

public interface ReserveItemService {

    public List<ReserveItem> findList(ReserveItemQuery query);

    public void insert(ReserveItem object);

    public void delete(Long id);

    public ReserveItem selectById(Long id);

}

