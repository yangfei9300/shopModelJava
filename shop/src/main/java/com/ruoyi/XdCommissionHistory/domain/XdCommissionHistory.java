package com.ruoyi.XdCommissionHistory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 佣金记录对象 xd_commission_history
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public class XdCommissionHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    /** 下级ID */
    @Excel(name = "下级ID")
    private Long belowId;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal money;
    /** 商品个数 */
    @Excel(name = "商品个数")
    private Long goodCount;
    /** 用户ID（系统） */
    @Excel(name = "用户ID", readConverterExp = "系=统")
    private Long userId;

    /** 状态（1.冷却中2.已收入） */
    @Excel(name = "状态", readConverterExp = "1=.冷却中2.已收入")
    private String status;


    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;

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
    public void setBelowId(Long belowId) 
    {
        this.belowId = belowId;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public Long getBelowId() 
    {
        return belowId;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setMoney(BigDecimal money)
    {
        this.money = money;
    }
    /** 佣金类型：1.购物，2充值 */
    @Excel(name = "佣金类型：1.购物，2充值")
    private Long type;
    public void setGoodCount(Long goodCount)
    {
        this.goodCount = goodCount;
    }

    public Long getGoodCount()
    {
        return goodCount;
    }
    public BigDecimal getMoney()
    {
        return money;
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

    public void setType(Long type)
    {
        this.type = type;
    }

    public Long getType()
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uId", getuId())
            .append("belowId", getBelowId())
            .append("orderId", getOrderId())
            .append("money", getMoney())
            .append("remark", getRemark())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
             .append("goodCount", getGoodCount())
            .toString();
    }
}
