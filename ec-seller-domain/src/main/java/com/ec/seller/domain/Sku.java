package com.ec.seller.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * SKU信息
 *
 */
public class Sku implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /** SKU_ID */
    private Integer skuId;

    /** 商品ID */
    private Integer itemId;

    /** 销售属性 {"销售属性id"，"销售属性值id"}*/
    private String salesProperty;
    
    private String salesPropertyName;
    
    /** 起买量 */
    private Integer leastBuy;
    
    /** 条形码 */
    private String barCode;

    /** 成本价 */
    private Integer costPrice;

    /** 销售价 */
    private Integer salePrice;
    
    /**
     * 原价
     */
    private Integer originalPrice;

    /** 成本价 */
    private BigDecimal costBigDecimalPrice;

    /** 销售价 */
    private BigDecimal saleBigDecimalPrice;

    /**
     * 原价
     */
    private BigDecimal originalBigDecimalPrice;
    

    /** 库存数量 */
    private Integer stock;

    /** 创建时间 */
    private Date created;

    /** 修改时间 */
    private Date modified;
    
    private Integer yn;

    private Integer properties;
    /** 1级优惠价格 */
    private Integer fxPrice;
    /** 更优惠的分销价格 */
    private Integer fxPrice2;

    public Integer getFxPrice() {
        return fxPrice;
    }

    public void setFxPrice(Integer fxPrice) {
        this.fxPrice = fxPrice;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getSalesProperty() {
		return salesProperty;
	}

	public void setSalesProperty(String salesProperty) {
		this.salesProperty = salesProperty;
	}

	public Integer getLeastBuy() {
		return leastBuy;
	}

	public void setLeastBuy(Integer leastBuy) {
		this.leastBuy = leastBuy;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}


    public Integer getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Integer salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

	public String getSalesPropertyName() {
		return salesPropertyName;
	}

	public void setSalesPropertyName(String salesPropertyName) {
		this.salesPropertyName = salesPropertyName;
	}

	public Integer getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}

    public BigDecimal getCostBigDecimalPrice() {
        return costBigDecimalPrice;
    }

    public void setCostBigDecimalPrice(BigDecimal costBigDecimalPrice) {
        this.costBigDecimalPrice = costBigDecimalPrice;
    }

    public BigDecimal getSaleBigDecimalPrice() {
        return saleBigDecimalPrice;
    }

    public void setSaleBigDecimalPrice(BigDecimal saleBigDecimalPrice) {
        this.saleBigDecimalPrice = saleBigDecimalPrice;
    }

    public BigDecimal getOriginalBigDecimalPrice() {
        return originalBigDecimalPrice;
    }

    public void setOriginalBigDecimalPrice(BigDecimal originalBigDecimalPrice) {
        this.originalBigDecimalPrice = originalBigDecimalPrice;
    }

    public Integer getProperties() {
        return properties;
    }

    public void setProperties(Integer properties) {
        this.properties = properties;
    }

    public Integer getFxPrice2() {
        return fxPrice2;
    }

    public void setFxPrice2(Integer fxPrice2) {
        this.fxPrice2 = fxPrice2;
    }
}