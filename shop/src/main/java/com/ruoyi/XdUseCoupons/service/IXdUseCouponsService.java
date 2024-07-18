package com.ruoyi.XdUseCoupons.service;

import java.util.List;
import com.ruoyi.XdUseCoupons.domain.XdUseCoupons;

/**
 * 优惠券领取使用记录Service接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface IXdUseCouponsService 
{
    /**
     * 查询优惠券领取使用记录
     * 
     * @param id 优惠券领取使用记录主键
     * @return 优惠券领取使用记录
     */
    public XdUseCoupons selectXdUseCouponsById(Long id);

    /**
     * 查询优惠券领取使用记录列表
     * 
     * @param xdUseCoupons 优惠券领取使用记录
     * @return 优惠券领取使用记录集合
     */
    public List<XdUseCoupons> selectXdUseCouponsList(XdUseCoupons xdUseCoupons);

    /**
     * 新增优惠券领取使用记录
     * 
     * @param xdUseCoupons 优惠券领取使用记录
     * @return 结果
     */
    public int insertXdUseCoupons(XdUseCoupons xdUseCoupons);

    /**
     * 修改优惠券领取使用记录
     * 
     * @param xdUseCoupons 优惠券领取使用记录
     * @return 结果
     */
    public int updateXdUseCoupons(XdUseCoupons xdUseCoupons);

    /**
     * 批量删除优惠券领取使用记录
     * 
     * @param ids 需要删除的优惠券领取使用记录主键集合
     * @return 结果
     */
    public int deleteXdUseCouponsByIds(Long[] ids);

    /**
     * 删除优惠券领取使用记录信息
     * 
     * @param id 优惠券领取使用记录主键
     * @return 结果
     */
    public int deleteXdUseCouponsById(Long id);
}
