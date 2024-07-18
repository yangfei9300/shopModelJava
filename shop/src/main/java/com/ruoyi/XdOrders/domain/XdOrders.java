package com.ruoyi.XdOrders.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.XdOrdersInfo.domain.XdOrdersInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单对象 xd_orders
 *
 * @author ruoyi
 * @date 2024-07-11
 */
public class XdOrders extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 用户ID
     */
    @Excel(name = "用户ID")
    private Long uId;

    /**
     * 订单编号
     */
    @Excel(name = "订单编号")
    private String orderNumber;

    /**
     * 订单创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderDate;

    /**
     * 支付时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /**
     * 发货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendTime;

    /**
     * 收货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date putTime;

    /**
     * 评价时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评价时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commTime;

    /**
     * 订单状态
     */
    @Excel(name = "订单状态")
    private Long status;

    /**
     * 地址ID
     */
    @Excel(name = "地址ID")
    private Long addressId;

    /**
     * 收货地址（省市区）
     */
    @Excel(name = "收货地址", readConverterExp = "省=市区")
    private String address;


    /**
     * 收件人姓名
     */
    @Excel(name = "收件人姓名")
    private String addressName;
    /**
     * 收件人电话
     */
    @Excel(name = "收件人电话")
    private String addressPhone;
    /**
     * 详细地址
     */
    @Excel(name = "详细地址")
    private String addressInfo;

    /**
     * 配送方式
     */
    @Excel(name = "配送方式")
    private String shippingMethod;

    /**
     * 物流名称
     */
    @Excel(name = "物流名称")
    private String logisticsName;

    /**
     * 物流编号
     */
    @Excel(name = "物流编号")
    private String logisticsCode;

    /**
     * 支付方式
     */
    @Excel(name = "支付方式")
    private Long paymentMethod;

    /**
     * 订单总价
     */
    @Excel(name = "订单总价")
    private BigDecimal totalAmount;

    /**
     * 优惠券优惠的金额
     */
    @Excel(name = "优惠券优惠的金额")
    private BigDecimal couponMoney;
    /** 总积分 */
    @Excel(name = "总积分")
    private Long totalInteger;

    /**
     * 最终价格
     */
    @Excel(name = "最终价格")
    private BigDecimal endMoney;

    /**
     * 优惠券ID
     */
    @Excel(name = "优惠券ID")
    private Long couponId;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String notes;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 用户ID
     */
    private Long userId;

    private List<XdOrdersInfo> orderItems;

    public List<XdOrdersInfo> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<XdOrdersInfo> orderItems) {
        this.orderItems = orderItems;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getuId() {
        return uId;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setPutTime(Date putTime) {
        this.putTime = putTime;
    }

    public Date getPutTime() {
        return putTime;
    }

    public void setCommTime(Date commTime) {
        this.commTime = commTime;
    }

    public Date getCommTime() {
        return commTime;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setPaymentMethod(Long paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public Long getPaymentMethod() {
        return paymentMethod;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalInteger(Long totalInteger)
    {
        this.totalInteger = totalInteger;
    }

    public Long getTotalInteger()
    {
        return totalInteger;
    }

    public void setCouponMoney(BigDecimal couponMoney) {
        this.couponMoney = couponMoney;
    }

    public BigDecimal getCouponMoney() {
        return couponMoney;
    }

    public void setEndMoney(BigDecimal endMoney) {
        this.endMoney = endMoney;
    }

    public BigDecimal getEndMoney() {
        return endMoney;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("uId", getuId())
                .append("orderNumber", getOrderNumber())
                .append("orderDate", getOrderDate())
                .append("payTime", getPayTime())
                .append("sendTime", getSendTime())
                .append("putTime", getPutTime())
                .append("commTime", getCommTime())
                .append("status", getStatus())
                .append("addressId", getAddressId())
                .append("address", getAddress())
                .append("addressName", getAddressName())
                .append("addressPhone", getAddressPhone())
                .append("addressInfo", getAddressInfo())
                .append("shippingMethod", getShippingMethod())
                .append("logisticsName", getLogisticsName())
                .append("logisticsCode", getLogisticsCode())
                .append("paymentMethod", getPaymentMethod())
                .append("totalAmount", getTotalAmount())
                .append("couponMoney", getCouponMoney())
                .append("endMoney", getEndMoney())
                .append("couponId", getCouponId())
                .append("notes", getNotes())
                .append("updateTime", getUpdateTime())
                .append("createTime", getCreateTime())
                .append("deptId", getDeptId())
                .append("userId", getUserId())
                .toString();
    }
}
