package com.ec.seller.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/7.
 */
public class PurchaseItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 采购单id */
    private Integer purchaseId;
    private Integer itemId;
    private String itemCode;
    private String itemName;
    /** 当前建议进货价格 */
    private BigDecimal referenceStockPrice;
    /** 参考进货单位 */
    private Integer referenceUnit;
    /** 进货单价 */
    private BigDecimal price;
    /** 进货数量 */
    private Double num;
    /** 总价 */
    private BigDecimal totalPrice;
    /** 备注 */
    private String remark;
    private Date created;
    private Date modified;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public BigDecimal getReferenceStockPrice() {
        return referenceStockPrice;
    }

    public void setReferenceStockPrice(BigDecimal referenceStockPrice) {
        this.referenceStockPrice = referenceStockPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getReferenceUnit() {
        return referenceUnit;
    }

    public void setReferenceUnit(Integer referenceUnit) {
        this.referenceUnit = referenceUnit;
    }
}
