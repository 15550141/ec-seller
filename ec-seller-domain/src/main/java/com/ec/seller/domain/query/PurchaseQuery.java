package com.ec.seller.domain.query;

import com.ec.seller.domain.common.BaseSearchForMysqlVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/7.
 */
public class PurchaseQuery extends BaseSearchForMysqlVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 采购日期 */
    private Date purchaseTime;
    /** 总金额 */
    private Integer total_price;
    /** 采购人id */
    private Integer purchase_uid;
    /** 采购人姓名 */
    private String purchase_name;
    /** 采购所花费用 */
    private Integer purchase_price;
    /** 采购所花费用明细 */
    private String purchase_price_detail;
    /** 采购地点 */
    private String purchase_place;
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

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    public Integer getPurchase_uid() {
        return purchase_uid;
    }

    public void setPurchase_uid(Integer purchase_uid) {
        this.purchase_uid = purchase_uid;
    }

    public String getPurchase_name() {
        return purchase_name;
    }

    public void setPurchase_name(String purchase_name) {
        this.purchase_name = purchase_name;
    }

    public Integer getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(Integer purchase_price) {
        this.purchase_price = purchase_price;
    }

    public String getPurchase_price_detail() {
        return purchase_price_detail;
    }

    public void setPurchase_price_detail(String purchase_price_detail) {
        this.purchase_price_detail = purchase_price_detail;
    }

    public String getPurchase_place() {
        return purchase_place;
    }

    public void setPurchase_place(String purchase_place) {
        this.purchase_place = purchase_place;
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
}
