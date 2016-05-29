package com.ec.seller.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yujianming on 2016/5/28.
 */
public class WxOrder {
    /**
     * 订单号
     */
    private Long orderId ;
    /**
     * 微信用户条形码
     */
    private String authCode;
    /**
     * 会显示到用户订单完成页面
     */
    private String body = "鲜果味道微信支付订单";
    /**
     * 原样返回
     */
    private String attach = "tingshuoyuanyangfanhui";
    /**
     * 总消费金额，单位是分
     */
    private Integer totalFee;

    /**
     * 收款店铺信息
     */
    private String deviceInfo;
    /**
     * 暂时为空
     */
    private String goodsTag;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 修改时间
     */
    private Date modified;
    /**
     * 是否有效，0 无效，1有效
     */
    private Integer yn = 1;
    /**
     * 订单状态，0是新建订单，1是支付完成
     */
    private Integer status = 0;

    /**
     * 添加人姓名
     */
    private String userName;

    /**
     * 添加人id
     */
    private Integer userId;

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
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

    public void setTotalFeePrice(BigDecimal bigDecimal){
        if(bigDecimal != null && bigDecimal.compareTo(BigDecimal.ZERO) > 0){
            this.totalFee = bigDecimal.multiply(new BigDecimal(100)).intValue();
        }
    }
}
