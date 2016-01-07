package com.ec.seller.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/7.
 */
public class PurchaseTemplateItem implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 采购单模板id */
    private Integer purchaseTemplateId;
    private Integer item_id;
    private String item_name;
    private Date created;
    private Date modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaseTemplateId() {
        return purchaseTemplateId;
    }

    public void setPurchaseTemplateId(Integer purchaseTemplateId) {
        this.purchaseTemplateId = purchaseTemplateId;
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
