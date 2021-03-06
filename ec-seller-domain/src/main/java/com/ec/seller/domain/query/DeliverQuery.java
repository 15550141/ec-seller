package com.ec.seller.domain.query;

import com.ec.seller.domain.common.BaseSearchForMysqlVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yujianming on 2016/8/18.
 */
public class DeliverQuery extends BaseSearchForMysqlVo implements Serializable {
    private Long id;
    private String shopName;
    private String remark;
    private String userName;
    private Integer userId;
    private Date deliverDate;
    private Date created;
    private Integer yn;
    private Integer status;
    //订货人id
    private Integer reserveUserId;
    //订货人名称
    private String reserveUserName;

    public Integer getReserveUserId() {
        return reserveUserId;
    }

    public void setReserveUserId(Integer reserveUserId) {
        this.reserveUserId = reserveUserId;
    }

    public String getReserveUserName() {
        return reserveUserName;
    }

    public void setReserveUserName(String reserveUserName) {
        this.reserveUserName = reserveUserName;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
