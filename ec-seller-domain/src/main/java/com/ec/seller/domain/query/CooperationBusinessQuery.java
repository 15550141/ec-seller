package com.ec.seller.domain.query;

import com.ec.seller.domain.common.BaseSearchForMysqlVo;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动兑换表
 * Created by yujianming on 2016/12/20.
 */
public class CooperationBusinessQuery extends BaseSearchForMysqlVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    //uid
    private Integer uid;

    private String userName;

    private String userMobile;

    private String company;

    private Integer type;

    private Integer status;

    private Integer agreeUserId;

    private String agreeUserName;

    private Date agreeTime;
    
    private String remark;

    private Date created;

    private Date modified;

    public Date getAgreeTime() {
        return agreeTime;
    }

    public void setAgreeTime(Date agreeTime) {
        this.agreeTime = agreeTime;
    }

    public Integer getAgreeUserId() {
        return agreeUserId;
    }

    public void setAgreeUserId(Integer agreeUserId) {
        this.agreeUserId = agreeUserId;
    }

    public String getAgreeUserName() {
        return agreeUserName;
    }

    public void setAgreeUserName(String agreeUserName) {
        this.agreeUserName = agreeUserName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
