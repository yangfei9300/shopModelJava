package com.ruoyi.XdBanners.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 轮播图对象 xd_banners
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class XdBanners extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 图片 */
    @Excel(name = "图片")
    private String img;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 轮播图位置 */
    @Excel(name = "轮播图位置")
    private Long bannerWeizhi;

    /** 跳转类型 */
    @Excel(name = "跳转类型")
    private String type;

    /** 跳转的值 */
    @Excel(name = "跳转的值")
    private String valueId;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

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
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setBannerWeizhi(Long bannerWeizhi)
    {
        this.bannerWeizhi = bannerWeizhi;
    }

    public Long getBannerWeizhi()
    {
        return bannerWeizhi;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setValueId(String valueId) 
    {
        this.valueId = valueId;
    }

    public String getValueId() 
    {
        return valueId;
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
            .append("img", getImg())
            .append("sort", getSort())
            .append("bannerWeizhi", getBannerWeizhi())
            .append("type", getType())
            .append("valueId", getValueId())
            .append("notes", getNotes())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
