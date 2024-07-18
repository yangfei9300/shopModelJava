package com.ruoyi.XdProductReviews.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户评价对象 xd_product_reviews
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class XdProductReviews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long productId;

    /** 规格ID */
    @Excel(name = "规格ID")
    private Long specsId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 规格名称 */
    @Excel(name = "规格名称")
    private String specsName;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    /** 打分 */
    @Excel(name = "打分")
    private Long rating;

    /** 评价文本 */
    @Excel(name = "评价文本")
    private String reviewText;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 图片集合 */
    @Excel(name = "图片集合")
    private String images;

    /** 部门ID */
    private Long deptId;

    /** 用户ID（ */
    private Long userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setSpecsName(String specsName) 
    {
        this.specsName = specsName;
    }

    public String getSpecsName() 
    {
        return specsName;
    }
    public void setuId(Long uId) 
    {
        this.uId = uId;
    }

    public Long getuId() 
    {
        return uId;
    }
    public void setRating(Long rating) 
    {
        this.rating = rating;
    }

    public Long getRating() 
    {
        return rating;
    }
    public void setReviewText(String reviewText) 
    {
        this.reviewText = reviewText;
    }

    public String getReviewText() 
    {
        return reviewText;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setImages(String images) 
    {
        this.images = images;
    }

    public String getImages() 
    {
        return images;
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
            .append("productId", getProductId())
            .append("specsId", getSpecsId())
            .append("productName", getProductName())
            .append("specsName", getSpecsName())
            .append("uId", getuId())
            .append("rating", getRating())
            .append("reviewText", getReviewText())
            .append("status", getStatus())
            .append("images", getImages())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
