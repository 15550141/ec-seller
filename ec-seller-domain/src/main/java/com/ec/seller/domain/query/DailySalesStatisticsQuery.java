package com.ec.seller.domain.query;

import com.ec.seller.domain.common.BaseSearchForMysqlVo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/12.
 */
public class DailySalesStatisticsQuery extends BaseSearchForMysqlVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 统计日期 */
    private Date statisticsDate;
    /** 时区1上午，2下午 */
    private String timeInterval;
    /** 总现金收入金额 */
    private BigDecimal totalCashPrice;
    /** 总销售金额 */
    private BigDecimal totalSalesPrice;
    /** 现金消费金额 */
    private BigDecimal cashSalesPrice;
    /** 会员卡消费金额 */
    private BigDecimal cardSalesPrice;
    /** pos机消费金额 */
    private BigDecimal posSalesPrice;
    /** 微信消费金额 */
    private BigDecimal wxSalesPrice;
    /** 其他消费金额 */
    private BigDecimal otherSalesPrice;
    /** 现金办理会员卡金额 */
    private BigDecimal cashBuyCardPrice;
    /** 刷卡办理会员卡金额 */
    private BigDecimal posBuyCardPrice;
    /** 备注 */
    private String remark;
    private Integer userId;
    private String userName;
    private Integer yn;
    private Date created;
    private Date modified;

    /** 店铺名称 */
    private String shopName;

    /** 最后修改人 */
    private String lastUpdateUserName;

    /** 支付宝办卡金额 */
    private BigDecimal zfbBuyCardPrice;

    /** 支付宝办卡金额 */
    private BigDecimal wxBuyCardPrice;

    public BigDecimal getWxBuyCardPrice() {
        return wxBuyCardPrice;
    }

    public void setWxBuyCardPrice(BigDecimal wxBuyCardPrice) {
        this.wxBuyCardPrice = wxBuyCardPrice;
    }

    public BigDecimal getZfbBuyCardPrice() {
        return zfbBuyCardPrice;
    }

    public void setZfbBuyCardPrice(BigDecimal zfbBuyCardPrice) {
        this.zfbBuyCardPrice = zfbBuyCardPrice;
    }

    public String getLastUpdateUserName() {
        return lastUpdateUserName;
    }

    public void setLastUpdateUserName(String lastUpdateUserName) {
        this.lastUpdateUserName = lastUpdateUserName;
    }

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

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public BigDecimal getTotalCashPrice() {
        return totalCashPrice;
    }

    public void setTotalCashPrice(BigDecimal totalCashPrice) {
        this.totalCashPrice = totalCashPrice;
    }

    public BigDecimal getTotalSalesPrice() {
        return totalSalesPrice;
    }

    public void setTotalSalesPrice(BigDecimal totalSalesPrice) {
        this.totalSalesPrice = totalSalesPrice;
    }

    public BigDecimal getCashSalesPrice() {
        return cashSalesPrice;
    }

    public void setCashSalesPrice(BigDecimal cashSalesPrice) {
        this.cashSalesPrice = cashSalesPrice;
    }

    public BigDecimal getCardSalesPrice() {
        return cardSalesPrice;
    }

    public void setCardSalesPrice(BigDecimal cardSalesPrice) {
        this.cardSalesPrice = cardSalesPrice;
    }

    public BigDecimal getPosSalesPrice() {
        return posSalesPrice;
    }

    public void setPosSalesPrice(BigDecimal posSalesPrice) {
        this.posSalesPrice = posSalesPrice;
    }

    public BigDecimal getWxSalesPrice() {
        return wxSalesPrice;
    }

    public void setWxSalesPrice(BigDecimal wxSalesPrice) {
        this.wxSalesPrice = wxSalesPrice;
    }

    public BigDecimal getOtherSalesPrice() {
        return otherSalesPrice;
    }

    public void setOtherSalesPrice(BigDecimal otherSalesPrice) {
        this.otherSalesPrice = otherSalesPrice;
    }

    public BigDecimal getCashBuyCardPrice() {
        return cashBuyCardPrice;
    }

    public void setCashBuyCardPrice(BigDecimal cashBuyCardPrice) {
        this.cashBuyCardPrice = cashBuyCardPrice;
    }

    public BigDecimal getPosBuyCardPrice() {
        return posBuyCardPrice;
    }

    public void setPosBuyCardPrice(BigDecimal posBuyCardPrice) {
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
}
