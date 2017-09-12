package com.ec.seller.domain.query;

import com.ec.seller.domain.common.BaseSearchForMysqlVo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yujianming on 2016/1/7.
 */
public class ReturnGoodsQuery extends BaseSearchForMysqlVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /** 采购日期 */
    private Date returnTime;
    /** 退货地点 */
    private String returnPlace;
    /** 总金额 */
    private BigDecimal totalPrice;
    /** 提交uid */
    private Integer uid;
    /** 提交姓名 */
    private String name;
    /** 采购单状态	0新建，1待审核，2审核通过，3审核不通过 */
    private Integer status;
    /** 0无效，1有效 */
    private Integer yn;
    /** 备注 */
    private String remark;
    private Date created;
    private Date modified;
    /** 其他金额 */
    private BigDecimal otherPrice;
    /** 附件 */
    private String fujian;
    /** 退货金额 */
    private BigDecimal returnPrice;
    /** 退货单id */
    private Integer purchaseId;

    private Integer shenheUid;

    private String shenheName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnPlace() {
        return returnPlace;
    }

    public void setReturnPlace(String returnPlace) {
        this.returnPlace = returnPlace;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    public String getFujian() {
        return fujian;
    }

    public void setFujian(String fujian) {
        this.fujian = fujian;
    }

    public BigDecimal getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(BigDecimal returnPrice) {
        this.returnPrice = returnPrice;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getShenheUid() {
        return shenheUid;
    }

    public void setShenheUid(Integer shenheUid) {
        this.shenheUid = shenheUid;
    }

    public String getShenheName() {
        return shenheName;
    }

    public void setShenheName(String shenheName) {
        this.shenheName = shenheName;
    }
}
