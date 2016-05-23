package com.ec.seller.domain.query;

import com.ec.seller.domain.common.BaseSearchForMysqlVo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yujianming on 2016/5/23.
 */
public class PruductQuery  extends BaseSearchForMysqlVo implements Serializable {
    //id
    private Long id;
    //商品编号
    private Integer productId;
    //商品名称
    private String productName;
    //商品库存
    private Integer stock;
    //进货单位
    private Integer unit;
    //商品入库价格
    private BigDecimal rukuPrice;
    //商品出库价格
    private BigDecimal chukuPrice;

    private Date created;

    private Date modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public BigDecimal getRukuPrice() {
        return rukuPrice;
    }

    public void setRukuPrice(BigDecimal rukuPrice) {
        this.rukuPrice = rukuPrice;
    }

    public BigDecimal getChukuPrice() {
        return chukuPrice;
    }

    public void setChukuPrice(BigDecimal chukuPrice) {
        this.chukuPrice = chukuPrice;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
