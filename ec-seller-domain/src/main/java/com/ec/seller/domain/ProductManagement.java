package com.ec.seller.domain;

import java.math.BigDecimal;

/**
 * Created by yujianming on 2016/5/23.
 */
public class ProductManagement {
    private Integer id;
    private Integer productId;
    private String productName;
    /**
     * 类型，1、入库，2、出库
     */
    private Integer type;
    //商品库存
    private Integer stock;
    //进货单位
    private Integer unit;
    //商品入库价格
    private BigDecimal rukuPrice;
    //商品出库价格
    private BigDecimal chukuPrice;
}
