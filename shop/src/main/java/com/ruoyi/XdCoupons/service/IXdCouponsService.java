package com.ruoyi.XdCoupons.service;

import java.util.List;
import com.ruoyi.XdCoupons.domain.XdCoupons;

/**
 * 优惠券Service接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface IXdCouponsService 
{
    /**
     * 查询优惠券
     * 
     * @param id 优惠券主键
     * @return 优惠券
     */
    public XdCoupons selectXdCouponsById(Long id);

    /**
     * 查询优惠券列表
     * 
     * @param xdCoupons 优惠券
     * @return 优惠券集合
     */
    public List<XdCoupons> selectXdCouponsList(XdCoupons xdCoupons);

    /**
     * 新增优惠券
     * 
     * @param xdCoupons 优惠券
     * @return 结果
     */
    public int insertXdCoupons(XdCoupons xdCoupons);

    /**
     * 修改优惠券
     * 
     * @param xdCoupons 优惠券
     * @return 结果
     */
    public int updateXdCoupons(XdCoupons xdCoupons);

    /**
     * 批量删除优惠券
     * 
     * @param ids 需要删除的优惠券主键集合
     * @return 结果
     */
    public int deleteXdCouponsByIds(Long[] ids);

    /**
     * 删除优惠券信息
     * 
     * @param id 优惠券主键
     * @return 结果
     */
    public int deleteXdCouponsById(Long id);
}
