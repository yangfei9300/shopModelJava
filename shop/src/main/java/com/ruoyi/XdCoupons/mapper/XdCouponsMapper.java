package com.ruoyi.XdCoupons.mapper;

import java.util.List;
import com.ruoyi.XdCoupons.domain.XdCoupons;

/**
 * 优惠券Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface XdCouponsMapper 
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
     * 删除优惠券
     * 
     * @param id 优惠券主键
     * @return 结果
     */
    public int deleteXdCouponsById(Long id);

    /**
     * 批量删除优惠券
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXdCouponsByIds(Long[] ids);
}
