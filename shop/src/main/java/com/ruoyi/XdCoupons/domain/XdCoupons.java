package com.ruoyi.XdCoupons.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 优惠券对象 xd_coupons
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class XdCoupons extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 优惠券名称 */
    @Excel(name = "优惠券名称")
    private String name;

    /** 优惠券编号 */
    private String code;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal money;

    /** 折扣 */
    @Excel(name = "折扣")
    private BigDecimal discount;

    /** 最低消费 */
    @Excel(name = "最低消费")
    private BigDecimal minimumAmount;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 优惠券库存 */
    @Excel(name = "优惠券库存")
    private Long usageLimit;

    /** 优惠券已使用次数 */
    @Excel(name = "优惠券已使用次数")
    private Long usedCount;

    /** 限定商品ID（先不用） */
    private String productId;

    /** 限定分类ID（先不用） */
    private String categoryId;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 部门ID */
    private Long deptId;

    /** 用户ID（系统用户） */
    private Long userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setMoney(BigDecimal money)
    {
        this.money = money;
    }

    public BigDecimal getMoney()
    {
        return money;
    }
    public void setDiscount(BigDecimal discount)
    {
        this.discount = discount;
    }

    public BigDecimal getDiscount()
    {
        return discount;
    }
    public void setMinimumAmount(BigDecimal minimumAmount)
    {
        this.minimumAmount = minimumAmount;
    }

    public BigDecimal getMinimumAmount()
    {
        return minimumAmount;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setUsageLimit(Long usageLimit) 
    {
        this.usageLimit = usageLimit;
    }

    public Long getUsageLimit() 
    {
        return usageLimit;
    }
    public void setUsedCount(Long usedCount) 
    {
        this.usedCount = usedCount;
    }

    public Long getUsedCount() 
    {
        return usedCount;
    }
    public void setProductId(String productId) 
    {
        this.productId = productId;
    }

    public String getProductId() 
    {
        return productId;
    }
    public void setCategoryId(String categoryId) 
    {
        this.categoryId = categoryId;
    }

    public String getCategoryId() 
    {
        return categoryId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
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
            .append("name", getName())
            .append("code", getCode())
            .append("type", getType())
            .append("money", getMoney())
            .append("discount", getDiscount())
            .append("minimumAmount", getMinimumAmount())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("usageLimit", getUsageLimit())
            .append("usedCount", getUsedCount())
            .append("productId", getProductId())
            .append("categoryId", getCategoryId())
            .append("status", getStatus())
            .append("notes", getNotes())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
