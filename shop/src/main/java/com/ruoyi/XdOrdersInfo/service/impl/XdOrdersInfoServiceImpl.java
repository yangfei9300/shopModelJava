package com.ruoyi.XdOrdersInfo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdOrdersInfo.mapper.XdOrdersInfoMapper;
import com.ruoyi.XdOrdersInfo.domain.XdOrdersInfo;
import com.ruoyi.XdOrdersInfo.service.IXdOrdersInfoService;

/**
 * 订单商品详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdOrdersInfoServiceImpl implements IXdOrdersInfoService 
{
    @Autowired
    private XdOrdersInfoMapper xdOrdersInfoMapper;

    /**
     * 查询订单商品详情
     * 
     * @param id 订单商品详情主键
     * @return 订单商品详情
     */
    @Override
    public XdOrdersInfo selectXdOrdersInfoById(Long id)
    {
        return xdOrdersInfoMapper.selectXdOrdersInfoById(id);
    }

    /**
     * 查询订单商品详情列表
     * 
     * @param xdOrdersInfo 订单商品详情
     * @return 订单商品详情
     */
    @Override
    public List<XdOrdersInfo> selectXdOrdersInfoList(XdOrdersInfo xdOrdersInfo)
    {
        return xdOrdersInfoMapper.selectXdOrdersInfoList(xdOrdersInfo);
    }

    /**
     * 新增订单商品详情
     * 
     * @param xdOrdersInfo 订单商品详情
     * @return 结果
     */
    @Override
    public int insertXdOrdersInfo(XdOrdersInfo xdOrdersInfo)
    {
        xdOrdersInfo.setCreateTime(DateUtils.getNowDate());
        return xdOrdersInfoMapper.insertXdOrdersInfo(xdOrdersInfo);
    }

    /**
     * 修改订单商品详情
     * 
     * @param xdOrdersInfo 订单商品详情
     * @return 结果
     */
    @Override
    public int updateXdOrdersInfo(XdOrdersInfo xdOrdersInfo)
    {
        xdOrdersInfo.setUpdateTime(DateUtils.getNowDate());
        return xdOrdersInfoMapper.updateXdOrdersInfo(xdOrdersInfo);
    }

    /**
     * 批量删除订单商品详情
     * 
     * @param ids 需要删除的订单商品详情主键
     * @return 结果
     */
    @Override
    public int deleteXdOrdersInfoByIds(Long[] ids)
    {
        return xdOrdersInfoMapper.deleteXdOrdersInfoByIds(ids);
    }

    /**
     * 删除订单商品详情信息
     * 
     * @param id 订单商品详情主键
     * @return 结果
     */
    @Override
    public int deleteXdOrdersInfoById(Long id)
    {
        return xdOrdersInfoMapper.deleteXdOrdersInfoById(id);
    }
}
