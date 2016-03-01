package com.ec.seller.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/12.
 */
public class DailySalesStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 统计日期 */
    private Date statisticsDate;
    /** 时区1上午，2下午 */
    private Integer timeInterval;
    /** 总现金收入金额 */
    private Integer totalCashPrice;
    /** 总销售金额 */
    private Integer totalSalesPrice;
    /** 现金消费金额 */
    private Integer cashSalesPrice;
    /** 会员卡消费金额 */
    private Integer cardSalesPrice;
    /** pos机消费金额 */
    private Integer posSalesPrice;
    /** 微信消费金额 */
    private Integer wxSalesPrice;
    /** 支付宝消费金额 */
    private Integer zfbSalesPrice;
    /** 其他消费金额 */
    private Integer otherSalesPrice;
    /** 现金办理会员卡金额 */
    private Integer cashBuyCardPrice;
    /** 刷卡办理会员卡金额 */
    private Integer posBuyCardPrice;
    private Integer userId;
    private String userName;
    /** 备注 */
    private String remark;
    private Integer yn;
    private Date created;
    private Date modified;

    /** 店铺名称 */
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStatisticsDate() {
        return statisticsDate;
    }

    public void setStatisticsDate(Date statisticsDate) {
        this.statisticsDate = statisticsDate;
    }

    public Integer getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
    }

    public Integer getTotalCashPrice() {
        return totalCashPrice;
    }

    public void setTotalCashPrice(Integer totalCashPrice) {
        this.totalCashPrice = totalCashPrice;
    }

    public Integer getTotalSalesPrice() {
        return totalSalesPrice;
    }

    public void setTotalSalesPrice(Integer totalSalesPrice) {
        this.totalSalesPrice = totalSalesPrice;
    }

    public Integer getCashSalesPrice() {
        return cashSalesPrice;
    }

    public void setCashSalesPrice(Integer cashSalesPrice) {
        this.cashSalesPrice = cashSalesPrice;
    }

    public Integer getCardSalesPrice() {
        return cardSalesPrice;
    }

    public void setCardSalesPrice(Integer cardSalesPrice) {
        this.cardSalesPrice = cardSalesPrice;
    }

    public Integer getPosSalesPrice() {
        return posSalesPrice;
    }

    public void setPosSalesPrice(Integer posSalesPrice) {
        this.posSalesPrice = posSalesPrice;
    }

    public Integer getWxSalesPrice() {
        return wxSalesPrice;
    }

    public void setWxSalesPrice(Integer wxSalesPrice) {
        this.wxSalesPrice = wxSalesPrice;
    }

    public Integer getOtherSalesPrice() {
        return otherSalesPrice;
    }

    public void setOtherSalesPrice(Integer otherSalesPrice) {
        this.otherSalesPrice = otherSalesPrice;
    }

    public Integer getCashBuyCardPrice() {
        return cashBuyCardPrice;
    }

    public void setCashBuyCardPrice(Integer cashBuyCardPrice) {
        this.cashBuyCardPrice = cashBuyCardPrice;
    }

    public Integer getPosBuyCardPrice() {
        return posBuyCardPrice;
    }

    public void setPosBuyCardPrice(Integer posBuyCardPrice) {
        this.posBuyCardPrice = posBuyCardPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
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

    public Integer getZfbSalesPrice() {
        return zfbSalesPrice;
    }

    public void setZfbSalesPrice(Integer zfbSalesPrice) {
        this.zfbSalesPrice = zfbSalesPrice;
    }
}
