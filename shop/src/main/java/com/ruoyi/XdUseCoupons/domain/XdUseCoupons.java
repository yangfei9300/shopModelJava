package com.ruoyi.XdUseCoupons.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 优惠券领取使用记录对象 xd_use_coupons
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class XdUseCoupons extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 优惠券ID */
    @Excel(name = "优惠券ID")
    private Long cId;

    /** 优惠券编号 */
    @Excel(name = "优惠券编号")
    private String cCode;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 获取时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "获取时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date getTime;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private Long usedOrderId;

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
    public void setcId(Long cId) 
    {
        this.cId = cId;
    }

    public Long getcId() 
    {
        return cId;
    }
    public void setcCode(String cCode) 
    {
        this.cCode = cCode;
    }

    public String getcCode() 
    {
        return cCode;
    }
    public void setuId(Long uId) 
    {
        this.uId = uId;
    }

    public Long getuId() 
    {
        return uId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setGetTime(Date getTime) 
    {
        this.getTime = getTime;
    }

    public Date getGetTime() 
    {
        return getTime;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
    }
    public void setUsedOrderId(Long usedOrderId) 
    {
        this.usedOrderId = usedOrderId;
    }

    public Long getUsedOrderId() 
    {
        return usedOrderId;
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
            .append("cId", getcId())
            .append("cCode", getcCode())
            .append("uId", getuId())
            .append("status", getStatus())
            .append("getTime", getGetTime())
            .append("notes", getNotes())
            .append("usedOrderId", getUsedOrderId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
