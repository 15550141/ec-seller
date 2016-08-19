package com.ec.seller.domain;

import java.util.Date;

/**
 * Created by yujianming on 2016/8/18.
 */
public class DeliverItem {
    private Long id;
    private String itemCode;
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

    private Long deliverId;

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

    public Integer getReserveNum() {
        return reserveNum;
    }

    public void setReserveNum(Integer reserveNum) {
        this.reserveNum = reserveNum;
    }

    public Integer getActualNum() {
        return actualNum;
    }

    public void setActualNum(Integer actualNum) {
        this.actualNum = actualNum;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
