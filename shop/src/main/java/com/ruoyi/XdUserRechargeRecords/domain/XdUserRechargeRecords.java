package com.ruoyi.XdUserRechargeRecords.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户充值记录对象 xd_user_recharge_records
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
public class XdUserRechargeRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    /** 用户ID(系统) */
    @Excel(name = "用户ID(系统)")
    private Long userId;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;

    /** 充值金额（元） */
    @Excel(name = "充值金额", readConverterExp = "元=")
    private BigDecimal rechargeAmount;

    /** 支付方式（如：支付宝、微信、银行卡等） */
    @Excel(name = "支付方式", readConverterExp = "如=：支付宝、微信、银行卡等")
    private String paymentMethod;

    /** 支付状态（待支付、成功、失败、已退款） */
    @Excel(name = "支付状态", readConverterExp = "待=支付、成功、失败、已退款")
    private String paymentStatus;

    /** 交易ID（如支付平台返回的订单号） */
    @Excel(name = "交易ID", readConverterExp = "如=支付平台返回的订单号")
    private String transactionId;

    /** 充值时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "充值时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date rechargeTime;

    /** 记录创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "记录创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setuId(Long uId) 
    {
        this.uId = uId;
    }

    public Long getuId() 
    {
        return uId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setRechargeAmount(BigDecimal rechargeAmount) 
    {
        this.rechargeAmount = rechargeAmount;
    }

    public BigDecimal getRechargeAmount() 
    {
        return rechargeAmount;
    }
    public void setPaymentMethod(String paymentMethod) 
    {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() 
    {
        return paymentMethod;
    }
    public void setPaymentStatus(String paymentStatus) 
    {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() 
    {
        return paymentStatus;
    }
    public void setTransactionId(String transactionId) 
    {
        this.transactionId = transactionId;
    }

    public String getTransactionId() 
    {
        return transactionId;
    }
    public void setRechargeTime(Date rechargeTime) 
    {
        this.rechargeTime = rechargeTime;
    }

    public Date getRechargeTime() 
    {
        return rechargeTime;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uId", getuId())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("rechargeAmount", getRechargeAmount())
            .append("paymentMethod", getPaymentMethod())
            .append("paymentStatus", getPaymentStatus())
            .append("transactionId", getTransactionId())
            .append("rechargeTime", getRechargeTime())
            .append("createdTime", getCreatedTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
