package com.ruoyi.XdUserConsumptionRecords.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户余额消费记录对象 xd_user_consumption_records
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
public class XdUserConsumptionRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 购买数量 */
    @Excel(name = "购买数量")
    private Long quantity;

    /** 单价（元） */
    @Excel(name = "单价", readConverterExp = "元=")
    private BigDecimal unitPrice;

    /** 总价（元） */
    @Excel(name = "总价", readConverterExp = "元=")
    private BigDecimal totalPrice;

    /** 消费时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "消费时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date consumptionTime;

    /** 支付状态（待支付、已支付、已退款） */
    @Excel(name = "支付状态", readConverterExp = "待=支付、已支付、已退款")
    private String paymentStatus;

    /** 记录创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "记录创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    /** 记录更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "记录更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setuId(Long uId) 
    {
        this.uId = uId;
    }

    public Long getuId() 
    {
        return uId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setConsumptionTime(Date consumptionTime) 
    {
        this.consumptionTime = consumptionTime;
    }

    public Date getConsumptionTime() 
    {
        return consumptionTime;
    }
    public void setPaymentStatus(String paymentStatus) 
    {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() 
    {
        return paymentStatus;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("uId", getuId())
            .append("deptId", getDeptId())
            .append("orderId", getOrderId())
            .append("productName", getProductName())
            .append("quantity", getQuantity())
            .append("unitPrice", getUnitPrice())
            .append("totalPrice", getTotalPrice())
            .append("consumptionTime", getConsumptionTime())
            .append("paymentStatus", getPaymentStatus())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
