package com.ec.seller.domain.query;

import com.ec.seller.domain.common.BaseSearchForMysqlVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yujianming on 2016/8/18.
 */
public class DeliverItemQuery extends BaseSearchForMysqlVo implements Serializable {
    private Long id;
    private Integer itemId;
    private String itemName;
    private String itemCategory;
    private String unit;
    /**
     * 订货数量
     */
    private Integer reserveNum;
    /**
     * 实际配送数量
     */
    private Integer actualNum;
    private Date created;
}
