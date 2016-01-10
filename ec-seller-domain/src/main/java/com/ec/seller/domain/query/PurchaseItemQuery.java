package com.ec.seller.domain.query;

import com.ec.seller.domain.common.BaseSearchForMysqlVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/7.
 */
public class PurchaseItemQuery extends BaseSearchForMysqlVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 采购单id */
    private Integer purchaseId;
    private Integer itemId;
    private String itemName;
    /** 当前建议进货价格 */
    private Integer referenceStockPrice;
    /** 进货参考单位 */
    private Integer referenceUnit;
    /** 进货单价 */
    private Integer price;
    /** 进货数量 */
    private Integer num;
    /** 总价 */
    private Integer totalPrice;
    /** 备注 */
    private String remark;
    private Date created;
    private Date modified;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getReferenceStockPrice() {
        return referenceStockPrice;
    }

    public void setReferenceStockPrice(Integer referenceStockPrice) {
        this.referenceStockPrice = referenceStockPrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
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
