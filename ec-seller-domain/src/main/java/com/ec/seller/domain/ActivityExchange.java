package com.ec.seller.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动兑换表
 * Created by yujianming on 2016/12/20.
 */
public class ActivityExchange implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long activityExchangeId;
    //活动id
    private Long activityId;
    //活动名称
    private String activityName;

    //uid
    private Integer uid;

    private String userName;

    private String userMobile;

    private Long activityGiftId;

    private String activityGiftName;

    private Integer activityGiftNum;

    private Date applyTime;

    private Date sendTime;

    private Date created;

    private Date modified;

    private String remark;

    private Integer status;

    private Integer sendUserId;

    private String sendUserName;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getActivityExchangeId() {
        return activityExchangeId;
    }

    public void setActivityExchangeId(Long activityExchangeId) {
        this.activityExchangeId = activityExchangeId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Long getActivityGiftId() {
        return activityGiftId;
    }

    public void setActivityGiftId(Long activityGiftId) {
        this.activityGiftId = activityGiftId;
    }

    public String getActivityGiftName() {
        return activityGiftName;
    }

    public void setActivityGiftName(String activityGiftName) {
        this.activityGiftName = activityGiftName;
    }

    public Integer getActivityGiftNum() {
        return activityGiftNum;
    }

    public void setActivityGiftNum(Integer activityGiftNum) {
        this.activityGiftNum = activityGiftNum;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
