package com.ruoyi.XdProducts.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 xd_products
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class XdProducts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 商品主图 */
    @Excel(name = "商品主图")
    private String img;

    /** 商品轮播图 */
    @Excel(name = "商品轮播图")
    private String banners;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String description;

    /** 商品描述富文本 */
    @Excel(name = "商品描述富文本")
    private String descriptionHtml;

    /** 分类ID */
    @Excel(name = "分类ID")
    private Long categoryId;

    /** 商品原价 */
    @Excel(name = "商品原价")
    private BigDecimal price;

    /** 优惠价格 */
    @Excel(name = "优惠价格")
    private BigDecimal preferentialPrice;

    /** 库存 */
    @Excel(name = "库存")
    private Long inventory;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 标签 */
    @Excel(name = "标签")
    private String tag;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 是否可使用优惠券 */
    @Excel(name = "是否可使用优惠券")
    private Long isCoupon;

    /** 是否是新品 */
    @Excel(name = "是否是新品")
    private Long isNew;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private String isRecommend;

    /** 部门表 */
    private Long deptId;

    /** 用户表（系统用户表） */
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
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setBanners(String banners) 
    {
        this.banners = banners;
    }

    public String getBanners() 
    {
        return banners;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setDescriptionHtml(String descriptionHtml) 
    {
        this.descriptionHtml = descriptionHtml;
    }

    public String getDescriptionHtml() 
    {
        return descriptionHtml;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setPreferentialPrice(BigDecimal preferentialPrice) 
    {
        this.preferentialPrice = preferentialPrice;
    }

    public BigDecimal getPreferentialPrice() 
    {
        return preferentialPrice;
    }
    public void setInventory(Long inventory) 
    {
        this.inventory = inventory;
    }

    public Long getInventory() 
    {
        return inventory;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setTag(String tag) 
    {
        this.tag = tag;
    }

    public String getTag() 
    {
        return tag;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setIsCoupon(Long isCoupon) 
    {
        this.isCoupon = isCoupon;
    }

    public Long getIsCoupon() 
    {
        return isCoupon;
    }
    public void setIsNew(Long isNew) 
    {
        this.isNew = isNew;
    }

    public Long getIsNew() 
    {
        return isNew;
    }
    public void setIsRecommend(String isRecommend) 
    {
        this.isRecommend = isRecommend;
    }

    public String getIsRecommend() 
    {
        return isRecommend;
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
            .append("img", getImg())
            .append("banners", getBanners())
            .append("description", getDescription())
            .append("descriptionHtml", getDescriptionHtml())
            .append("categoryId", getCategoryId())
            .append("price", getPrice())
            .append("preferentialPrice", getPreferentialPrice())
            .append("inventory", getInventory())
            .append("sort", getSort())
            .append("tag", getTag())
            .append("notes", getNotes())
            .append("status", getStatus())
            .append("isCoupon", getIsCoupon())
            .append("isNew", getIsNew())
            .append("isRecommend", getIsRecommend())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
