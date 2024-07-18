package com.ruoyi.XdCarts.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 购物车对象 xd_carts
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class XdCarts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long productId;

    /** 规格ID */
    @Excel(name = "规格ID")
    private Long specsId;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long quantity;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal price;

    /** 部门ID */
    private Long deptId;

    /** 用户ID（系统） */
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
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setSpecsId(Long specsId) 
    {
        this.specsId = specsId;
    }

    public Long getSpecsId() 
    {
        return specsId;
    }
    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
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
            .append("productId", getProductId())
            .append("specsId", getSpecsId())
            .append("quantity", getQuantity())
            .append("price", getPrice())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
