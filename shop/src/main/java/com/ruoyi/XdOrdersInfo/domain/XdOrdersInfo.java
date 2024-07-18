package com.ruoyi.XdOrdersInfo.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单商品详情对象 xd_orders_info
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class XdOrdersInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private Long orderId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long productId;
    /** 规格ID */
    @Excel(name = "规格ID")
    private Long spaceId;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String productImg;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 规格图片 */
    @Excel(name = "规格图片")
    private String specsImg;

    /** 规格名称 */
    @Excel(name = "规格名称")
    private String specsName;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal productPrice;

    /** 规格价格 */
    @Excel(name = "规格价格")
    private BigDecimal specsPrice;

    /** 数量 */
    @Excel(name = "数量")
    private Long quantity;

    /** 子总价 */
    @Excel(name = "子总价")
    private Long subtotal;

    /** 优惠券ID（单商品促销） */
    @Excel(name = "优惠券ID", readConverterExp = "单=商品促销")
    private Long couponId;

    /** 折扣金额（用于单商品促销） */
    @Excel(name = "折扣金额", readConverterExp = "用=于单商品促销")
    private Long discountAmount;

    /** 最终子价格 */
    @Excel(name = "最终子价格")
    private BigDecimal finalPrice;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 部门ID */
    private Long deptId;

    /** 用户ID */
    private Long userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductImg(String productImg) 
    {
        this.productImg = productImg;
    }

    public void setSpaceId(Long spaceId)
    {
        this.spaceId = spaceId;
    }

    public Long getSpaceId()
    {
        return spaceId;
    }

    public String getProductImg() 
    {
        return productImg;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setSpecsImg(String specsImg) 
    {
        this.specsImg = specsImg;
    }

    public String getSpecsImg() 
    {
        return specsImg;
    }
    public void setSpecsName(String specsName) 
    {
        this.specsName = specsName;
    }

    public String getSpecsName() 
    {
        return specsName;
    }
    public void setProductPrice(BigDecimal productPrice) 
    {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPrice() 
    {
        return productPrice;
    }
    public void setSpecsPrice(BigDecimal specsPrice) 
    {
        this.specsPrice = specsPrice;
    }

    public BigDecimal getSpecsPrice() 
    {
        return specsPrice;
    }
    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }
    public void setSubtotal(Long subtotal) 
    {
        this.subtotal = subtotal;
    }

    public Long getSubtotal() 
    {
        return subtotal;
    }
    public void setCouponId(Long couponId) 
    {
        this.couponId = couponId;
    }

    public Long getCouponId() 
    {
        return couponId;
    }
    public void setDiscountAmount(Long discountAmount) 
    {
        this.discountAmount = discountAmount;
    }

    public Long getDiscountAmount() 
    {
        return discountAmount;
    }
    public void setFinalPrice(BigDecimal finalPrice) 
    {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getFinalPrice() 
    {
        return finalPrice;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("productId", getProductId())
                .append("spaceId", getSpaceId())
            .append("productImg", getProductImg())
            .append("productName", getProductName())
            .append("specsImg", getSpecsImg())
            .append("specsName", getSpecsName())
            .append("productPrice", getProductPrice())
            .append("specsPrice", getSpecsPrice())
            .append("quantity", getQuantity())
            .append("subtotal", getSubtotal())
            .append("couponId", getCouponId())
            .append("discountAmount", getDiscountAmount())
            .append("finalPrice", getFinalPrice())
            .append("note", getNote())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
