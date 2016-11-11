package com.ec.seller.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/7.
 */
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 采购单Id */
    private Integer purchaseId;
    /** 采购日期 */
    private Date storageTime;
    /** 总金额 */
    private BigDecimal totalPrice;
    /** 采购人id */
    private Integer storageUid;
    /** 采购人姓名 */
    private String storageName;
    /** 采购地点 */
    private String place;
    /** 采购单状态	0新建，1采购结束 */
    private Integer status;
    /** 0无效，1有效 */
    private Integer yn;
    /** 备注 */
    private String remark;
    private Date created;
    private Date modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }

    public Integer getStorageUid() {
        return storageUid;
    }

    public void setStorageUid(Integer storageUid) {
        this.storageUid = storageUid;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }
}
