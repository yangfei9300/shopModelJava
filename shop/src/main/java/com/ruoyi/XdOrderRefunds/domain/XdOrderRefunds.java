package com.ruoyi.XdOrderRefunds.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单退款对象 xd_order_refunds
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public class XdOrderRefunds extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 用户ID */
    private Long userId;

    /** 退款金额 */
    @Excel(name = "退款金额")
    private BigDecimal refundAmount;

    /** 退款状态 */
    @Excel(name = "退款状态")
    private String refundStatus;
    /** 处理结果 */
    @Excel(name = "处理结果")
    private String returnResult;
    /** 退款原因 */
    @Excel(name = "退款原因")
    private String refundReason;

    /** 退款方式 */
    @Excel(name = "退款方式")
    private String refundMethod;

    /** 转账账号 */
    @Excel(name = "转账账号")
    private String refundAccount;

    /** 用户ID */
    private Long uId;

    /** 部门ID */
    private Long deptId;

    /** 退款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date refundDate;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

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
    public void setReturnResult(String returnResult)
    {
        this.returnResult = returnResult;
    }

    public String getReturnResult()
    {
        return returnResult;
    }
    public Long getOrderId() 
    {
        return orderId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setRefundAmount(BigDecimal refundAmount) 
    {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getRefundAmount() 
    {
        return refundAmount;
    }
    public void setRefundStatus(String refundStatus) 
    {
        this.refundStatus = refundStatus;
    }

    public String getRefundStatus() 
    {
        return refundStatus;
    }
    public void setRefundReason(String refundReason) 
    {
        this.refundReason = refundReason;
    }

    public String getRefundReason() 
    {
        return refundReason;
    }
    public void setRefundMethod(String refundMethod) 
    {
        this.refundMethod = refundMethod;
    }

    public String getRefundMethod() 
    {
        return refundMethod;
    }
    public void setRefundAccount(String refundAccount) 
    {
        this.refundAccount = refundAccount;
    }

    public String getRefundAccount() 
    {
        return refundAccount;
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
    public void setRefundDate(Date refundDate) 
    {
        this.refundDate = refundDate;
    }

    public Date getRefundDate() 
    {
        return refundDate;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("userId", getUserId())
            .append("refundAmount", getRefundAmount())
            .append("refundStatus", getRefundStatus())
            .append("refundReason", getRefundReason())
            .append("refundMethod", getRefundMethod())
            .append("refundAccount", getRefundAccount())
            .append("uId", getuId())
            .append("deptId", getDeptId())
            .append("refundDate", getRefundDate())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
