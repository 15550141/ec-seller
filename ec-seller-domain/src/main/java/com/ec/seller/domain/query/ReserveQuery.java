package com.ec.seller.domain.query;

import com.ec.seller.domain.common.BaseSearchForMysqlVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yujianming on 2016/8/18.
 */
public class ReserveQuery extends BaseSearchForMysqlVo implements Serializable {
    private Long id;
    private String shopName;
    private String remark;
    private String userName;
    private Integer userId;
    private Date reserveDate;
    private Date created;
    private Integer yn;
    private Integer status;

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

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
