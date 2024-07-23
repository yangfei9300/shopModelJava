package com.ruoyi.XdUseCoupons.mapper;

import java.util.List;
import com.ruoyi.XdUseCoupons.domain.XdUseCoupons;

/**
 * 优惠券领取使用记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface XdUseCouponsMapper 
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
    public List<XdUseCoupons> getCouponByUid(XdUseCoupons xdUseCoupons);

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
     * 删除优惠券领取使用记录
     * 
     * @param id 优惠券领取使用记录主键
     * @return 结果
     */
    public int deleteXdUseCouponsById(Long id);

    /**
     * 批量删除优惠券领取使用记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXdUseCouponsByIds(Long[] ids);
}
