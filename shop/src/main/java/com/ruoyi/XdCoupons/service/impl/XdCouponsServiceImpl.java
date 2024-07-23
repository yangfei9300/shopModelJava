package com.ruoyi.XdCoupons.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdCoupons.mapper.XdCouponsMapper;
import com.ruoyi.XdCoupons.domain.XdCoupons;
import com.ruoyi.XdCoupons.service.IXdCouponsService;

/**
 * 优惠券Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdCouponsServiceImpl implements IXdCouponsService 
{
    @Autowired
    private XdCouponsMapper xdCouponsMapper;

    /**
     * 查询优惠券
     * 
     * @param id 优惠券主键
     * @return 优惠券
     */
    @Override
    public XdCoupons selectXdCouponsById(Long id)
    {
        return xdCouponsMapper.selectXdCouponsById(id);
    }

    /**
     * 查询优惠券列表
     * 
     * @param xdCoupons 优惠券
     * @return 优惠券
     */
    @Override
    public List<XdCoupons> selectXdCouponsList(XdCoupons xdCoupons)
    {
        return xdCouponsMapper.selectXdCouponsList(xdCoupons);
    }



    /**
     * 新增优惠券
     * 
     * @param xdCoupons 优惠券
     * @return 结果
     */
    @Override
    public int insertXdCoupons(XdCoupons xdCoupons)
    {
        LoginUser loginUser= SecurityUtils.getLoginUser();
        xdCoupons.setDeptId(loginUser.getDeptId());
        xdCoupons.setUserId(loginUser.getUserId());
        xdCoupons.setCreateTime(DateUtils.getNowDate());
        return xdCouponsMapper.insertXdCoupons(xdCoupons);
    }

    /**
     * 修改优惠券
     * 
     * @param xdCoupons 优惠券
     * @return 结果
     */
    @Override
    public int updateXdCoupons(XdCoupons xdCoupons)
    {
        xdCoupons.setUpdateTime(DateUtils.getNowDate());
        return xdCouponsMapper.updateXdCoupons(xdCoupons);
    }

    /**
     * 批量删除优惠券
     * 
     * @param ids 需要删除的优惠券主键
     * @return 结果
     */
    @Override
    public int deleteXdCouponsByIds(Long[] ids)
    {
        return xdCouponsMapper.deleteXdCouponsByIds(ids);
    }

    /**
     * 删除优惠券信息
     * 
     * @param id 优惠券主键
     * @return 结果
     */
    @Override
    public int deleteXdCouponsById(Long id)
    {
        return xdCouponsMapper.deleteXdCouponsById(id);
    }
}
