package com.ruoyi.XdUseCoupons.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdUseCoupons.mapper.XdUseCouponsMapper;
import com.ruoyi.XdUseCoupons.domain.XdUseCoupons;
import com.ruoyi.XdUseCoupons.service.IXdUseCouponsService;

/**
 * 优惠券领取使用记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdUseCouponsServiceImpl implements IXdUseCouponsService 
{
    @Autowired
    private XdUseCouponsMapper xdUseCouponsMapper;

    /**
     * 查询优惠券领取使用记录
     * 
     * @param id 优惠券领取使用记录主键
     * @return 优惠券领取使用记录
     */
    @Override
    public XdUseCoupons selectXdUseCouponsById(Long id)
    {
        return xdUseCouponsMapper.selectXdUseCouponsById(id);
    }

    /**
     * 查询优惠券领取使用记录列表
     * 
     * @param xdUseCoupons 优惠券领取使用记录
     * @return 优惠券领取使用记录
     */
    @Override
    public List<XdUseCoupons> selectXdUseCouponsList(XdUseCoupons xdUseCoupons)
    {
        return xdUseCouponsMapper.selectXdUseCouponsList(xdUseCoupons);
    }

    /**
     * 新增优惠券领取使用记录
     * 
     * @param xdUseCoupons 优惠券领取使用记录
     * @return 结果
     */
    @Override
    public int insertXdUseCoupons(XdUseCoupons xdUseCoupons)
    {
        xdUseCoupons.setCreateTime(DateUtils.getNowDate());
        return xdUseCouponsMapper.insertXdUseCoupons(xdUseCoupons);
    }

    /**
     * 修改优惠券领取使用记录
     * 
     * @param xdUseCoupons 优惠券领取使用记录
     * @return 结果
     */
    @Override
    public int updateXdUseCoupons(XdUseCoupons xdUseCoupons)
    {
        xdUseCoupons.setUpdateTime(DateUtils.getNowDate());
        return xdUseCouponsMapper.updateXdUseCoupons(xdUseCoupons);
    }

    /**
     * 批量删除优惠券领取使用记录
     * 
     * @param ids 需要删除的优惠券领取使用记录主键
     * @return 结果
     */
    @Override
    public int deleteXdUseCouponsByIds(Long[] ids)
    {
        return xdUseCouponsMapper.deleteXdUseCouponsByIds(ids);
    }

    /**
     * 删除优惠券领取使用记录信息
     * 
     * @param id 优惠券领取使用记录主键
     * @return 结果
     */
    @Override
    public int deleteXdUseCouponsById(Long id)
    {
        return xdUseCouponsMapper.deleteXdUseCouponsById(id);
    }
}
