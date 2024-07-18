package com.ruoyi.XdUser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 微信用户对象 xd_user
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class XdUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 微信openid */
    @Excel(name = "微信openid")
    private Long openid;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String name;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 电话 */
    @Excel(name = "电话")
    private String phoneNumber;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 用户等级 */
    @Excel(name = "用户等级")
    private Long level;

    /** 用户身份（1.普通用户2.管理员） */
    @Excel(name = "用户身份", readConverterExp = "1=.普通用户2.管理员")
    private Long useType;

    /** 来源 */
    @Excel(name = "来源")
    private String source;

    /** 积分 */
    @Excel(name = "积分")
    private Long integral;

    /** 余额 */
    @Excel(name = "余额")
    private Long money;
    /** 上级电话 */
    @Excel(name = "上级电话")
    private String superiorPhone;
    /** 默认地址ID */
    @Excel(name = "默认地址ID")
    private Long addressId;

    /** 是否使用过 */
    @Excel(name = "是否使用过")
    private Long isUse;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

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
    public void setOpenid(Long openid) 
    {
        this.openid = openid;
    }

    public Long getOpenid() 
    {
        return openid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setLevel(Long level) 
    {
        this.level = level;
    }
    public void setSuperiorPhone(String superiorPhone)
    {
        this.superiorPhone = superiorPhone;
    }

    public String getSuperiorPhone()
    {
        return superiorPhone;
    }
    public Long getLevel() 
    {
        return level;
    }
    public void setUseType(Long useType) 
    {
        this.useType = useType;
    }

    public Long getUseType() 
    {
        return useType;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setIntegral(Long integral) 
    {
        this.integral = integral;
    }

    public Long getIntegral() 
    {
        return integral;
    }
    public void setMoney(Long money) 
    {
        this.money = money;
    }

    public Long getMoney() 
    {
        return money;
    }
    public void setAddressId(Long addressId) 
    {
        this.addressId = addressId;
    }

    public Long getAddressId() 
    {
        return addressId;
    }
    public void setIsUse(Long isUse) 
    {
        this.isUse = isUse;
    }

    public Long getIsUse() 
    {
        return isUse;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
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
            .append("openid", getOpenid())
            .append("name", getName())
            .append("nickName", getNickName())
            .append("avatar", getAvatar())
            .append("phoneNumber", getPhoneNumber())
            .append("password", getPassword())
            .append("level", getLevel())
            .append("useType", getUseType())
            .append("source", getSource())
            .append("integral", getIntegral())
            .append("money", getMoney())
            .append("addressId", getAddressId())
            .append("isUse", getIsUse())
            .append("email", getEmail())
            .append("status", getStatus())
            .append("notes", getNotes())
                .append("superiorPhone", getSuperiorPhone())
                .append("superiorPhone", getSuperiorPhone())
                .append("superiorPhone", getSuperiorPhone())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
