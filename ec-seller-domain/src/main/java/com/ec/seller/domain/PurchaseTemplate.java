package com.ec.seller.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/7.
 */
public class PurchaseTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 模板名称 */
    private String purchaseTemplateName;
    /** 创建人id */
    private Integer userId;
    /** 创建人名称 */
    private String userName;
    /** 采购地点 */
    private String purchasePlace;
    private Date created;
    private Date modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchaseTemplateName() {
        return purchaseTemplateName;
    }

    public void setPurchaseTemplateName(String purchaseTemplateName) {
        this.purchaseTemplateName = purchaseTemplateName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPurchasePlace() {
        return purchasePlace;
    }

    public void setPurchasePlace(String purchasePlace) {
        this.purchasePlace = purchasePlace;
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
