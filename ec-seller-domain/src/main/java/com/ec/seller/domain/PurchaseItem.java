package com.ec.seller.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/7.
 */
public class PurchaseItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 采购单id */
    private Integer purchase_id;
    private Integer item_id;
    private String item_name;
    /** 当前建议进货价格 */
    private Integer reference_stock_price;
    /** 进货单价 */
    private Integer price;
    /** 进货数量 */
    private Integer num;
    /** 总价 */
    private Integer total_price;
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

    public Integer getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Integer purchase_id) {
        this.purchase_id = purchase_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getReference_stock_price() {
        return reference_stock_price;
    }

    public void setReference_stock_price(Integer reference_stock_price) {
        this.reference_stock_price = reference_stock_price;
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

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
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
