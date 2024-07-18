package com.ruoyi.XdOrdersInfo.service;

import java.util.List;
import com.ruoyi.XdOrdersInfo.domain.XdOrdersInfo;

/**
 * 订单商品详情Service接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface IXdOrdersInfoService 
{
    /**
     * 查询订单商品详情
     * 
     * @param id 订单商品详情主键
     * @return 订单商品详情
     */
    public XdOrdersInfo selectXdOrdersInfoById(Long id);

    /**
     * 查询订单商品详情列表
     * 
     * @param xdOrdersInfo 订单商品详情
     * @return 订单商品详情集合
     */
    public List<XdOrdersInfo> selectXdOrdersInfoList(XdOrdersInfo xdOrdersInfo);

    /**
     * 新增订单商品详情
     * 
     * @param xdOrdersInfo 订单商品详情
     * @return 结果
     */
    public int insertXdOrdersInfo(XdOrdersInfo xdOrdersInfo);

    /**
     * 修改订单商品详情
     * 
     * @param xdOrdersInfo 订单商品详情
     * @return 结果
     */
    public int updateXdOrdersInfo(XdOrdersInfo xdOrdersInfo);

    /**
     * 批量删除订单商品详情
     * 
     * @param ids 需要删除的订单商品详情主键集合
     * @return 结果
     */
    public int deleteXdOrdersInfoByIds(Long[] ids);

    /**
     * 删除订单商品详情信息
     * 
     * @param id 订单商品详情主键
     * @return 结果
     */
    public int deleteXdOrdersInfoById(Long id);
}
