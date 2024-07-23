package com.ruoyi.XdShopInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商城信息对象 xd_shop_info
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
public class XdShopInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 商城名称 */
    @Excel(name = "商城名称")
    private String shopName;

    /** LOGO  */
    @Excel(name = "LOGO ")
    private String logo;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String userName;

    /** 商城描述 */
    @Excel(name = "商城描述")
    private String description;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String contactEmail;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 营业时间 */
    @Excel(name = "营业时间")
    private String openingHours;

    /** 状态（1激活2未激活） */
    @Excel(name = "状态", readConverterExp = "1=激活2未激活")
    private String status;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 部门ID */
    @Excel(name = "部门ID")
    private String deptId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }
    public void setLogo(String logo) 
    {
        this.logo = logo;
    }

    public String getLogo() 
    {
        return logo;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setContactEmail(String contactEmail) 
    {
        this.contactEmail = contactEmail;
    }

    public String getContactEmail() 
    {
        return contactEmail;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setOpeningHours(String openingHours) 
    {
        this.openingHours = openingHours;
    }

    public String getOpeningHours() 
    {
        return openingHours;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(String deptId) 
    {
        this.deptId = deptId;
    }

    public String getDeptId() 
    {
        return deptId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopName", getShopName())
            .append("logo", getLogo())
            .append("phone", getPhone())
            .append("userName", getUserName())
            .append("description", getDescription())
            .append("contactEmail", getContactEmail())
            .append("address", getAddress())
            .append("openingHours", getOpeningHours())
            .append("status", getStatus())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
