package com.ec.seller.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/7.
 */
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 采购日期 */
    private Date purchaseTime;
    /** 总金额 */
    private BigDecimal totalPrice;
    /** 采购人id */
    private Integer purchaseUid;
    /** 采购人姓名 */
    private String purchaseName;
    /** 采购所花费用 */
    private BigDecimal purchasePrice;
    /** 采购所花费用明细 */
    private String purchasePriceDetail;
    /** 采购地点 */
    private String purchasePlace;
    /** 采购单状态	0新建，1采购结束 */
    private Integer status;
    /** 0无效，1有效 */
    private Integer yn;
    /** 备注 */
    private String remark;
    private Date created;
    private Date modified;

    //采购商品总费用
    private BigDecimal purchaseTotalPrice;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Integer getPurchaseUid() {
        return purchaseUid;
    }

    public void setPurchaseUid(Integer purchaseUid) {
        this.purchaseUid = purchaseUid;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPurchasePriceDetail() {
        return purchasePriceDetail;
    }

    public void setPurchasePriceDetail(String purchasePriceDetail) {
        this.purchasePriceDetail = purchasePriceDetail;
    }

    public String getPurchasePlace() {
        return purchasePlace;
    }

    public void setPurchasePlace(String purchasePlace) {
        this.purchasePlace = purchasePlace;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
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

    public BigDecimal getPurchaseTotalPrice() {
        return purchaseTotalPrice;
    }

    public void setPurchaseTotalPrice(BigDecimal purchaseTotalPrice) {
        this.purchaseTotalPrice = purchaseTotalPrice;
    }
}
