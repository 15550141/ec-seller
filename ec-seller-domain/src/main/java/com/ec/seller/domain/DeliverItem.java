package com.ec.seller.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yujianming on 2016/8/18.
 */
public class DeliverItem {
    private Long id;
    private Integer itemId;
    private String itemCode;
    private String itemName;
    private String itemCategory;
    private String unit;
    /**
     * 订货数量
     */
    private BigDecimal reserveNum;
    /**
     * 实际配送数量
     */
    private BigDecimal actualNum;
    private Date created;

    private Long deliverId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Long getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getReserveNum() {
        return reserveNum;
    }

    public void setReserveNum(BigDecimal reserveNum) {
        this.reserveNum = reserveNum;
    }

    public BigDecimal getActualNum() {
        return actualNum;
    }

    public void setActualNum(BigDecimal actualNum) {
        this.actualNum = actualNum;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
