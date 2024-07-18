package com.ruoyi.XdIntegralRecord.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 积分记录对象 xd_Integral_record
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class XdIntegralRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    /** 积分数量 */
    @Excel(name = "积分数量")
    private Long num;

    /** 修改类型 */
    @Excel(name = "修改类型")
    private Long updateType;

    /** 修改类型 */
    @Excel(name = "修改类型")
    private Long consumptionType;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

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
    public void setuId(Long uId) 
    {
        this.uId = uId;
    }

    public Long getuId() 
    {
        return uId;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setUpdateType(Long updateType) 
    {
        this.updateType = updateType;
    }

    public Long getUpdateType() 
    {
        return updateType;
    }
    public void setConsumptionType(Long consumptionType) 
    {
        this.consumptionType = consumptionType;
    }

    public Long getConsumptionType() 
    {
        return consumptionType;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId(Long id)
    {
        return orderId;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
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
            .append("uId", getuId())
            .append("num", getNum())
            .append("updateType", getUpdateType())
            .append("consumptionType", getConsumptionType())
            .append("notes", getNotes())
            .append("createTime", getCreateTime())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
