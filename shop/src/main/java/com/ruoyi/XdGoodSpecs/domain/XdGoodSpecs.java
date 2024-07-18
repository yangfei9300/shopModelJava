package com.ruoyi.XdGoodSpecs.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规格管理对象 xd_good_specs
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class XdGoodSpecs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long goodId;

    /** 规格名称 */
    @Excel(name = "规格名称")
    private String specsName;
    /** 库存 */
    @Excel(name = "库存")
    private Long count;
    /** 规格图片 */
    @Excel(name = "规格图片")
    private String spaceImg;

    /** 规格原价 */
    @Excel(name = "规格原价")
    private BigDecimal spacePrice;

    /** 规格优惠价 */
    @Excel(name = "规格优惠价")
    private BigDecimal spaceOriginalPrice;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;
    public void setCount(Long count)
    {
        this.count = count;
    }

    public Long getCount()
    {
        return count;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoodId(Long goodId) 
    {
        this.goodId = goodId;
    }

    public Long getGoodId() 
    {
        return goodId;
    }
    public void setSpecsName(String specsName) 
    {
        this.specsName = specsName;
    }

    public String getSpecsName() 
    {
        return specsName;
    }
    public void setSpaceImg(String spaceImg) 
    {
        this.spaceImg = spaceImg;
    }

    public String getSpaceImg() 
    {
        return spaceImg;
    }
    public void setSpacePrice(BigDecimal spacePrice) 
    {
        this.spacePrice = spacePrice;
    }

    public BigDecimal getSpacePrice() 
    {
        return spacePrice;
    }
    public void setSpaceOriginalPrice(BigDecimal spaceOriginalPrice) 
    {
        this.spaceOriginalPrice = spaceOriginalPrice;
    }

    public BigDecimal getSpaceOriginalPrice() 
    {
        return spaceOriginalPrice;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
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
            .append("goodId", getGoodId())
            .append("specsName", getSpecsName())
            .append("spaceImg", getSpaceImg())
            .append("spacePrice", getSpacePrice())
            .append("spaceOriginalPrice", getSpaceOriginalPrice())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
