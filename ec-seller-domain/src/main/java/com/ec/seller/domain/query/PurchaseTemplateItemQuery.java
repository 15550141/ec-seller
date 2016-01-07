package com.ec.seller.domain.query;

import com.ec.seller.domain.common.BaseSearchForMysqlVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/7.
 */
public class PurchaseTemplateItemQuery extends BaseSearchForMysqlVo implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 采购单模板id */
    private Integer purchaseTemplateId;
    private Integer itemId;
    private String itemName;
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
