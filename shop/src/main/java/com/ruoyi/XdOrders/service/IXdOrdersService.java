package com.ruoyi.XdOrders.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.XdOrders.domain.XdOrders;

/**
 * 订单Service接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface IXdOrdersService 
{
    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    public XdOrders selectXdOrdersById(Long id);

    /**
     * 查询订单列表
     * 
     * @param xdOrders 订单
     * @return 订单集合
     */
    public List<XdOrders> selectXdOrdersList(XdOrders xdOrders);
    public List<XdOrders> getOrders(XdOrders xdOrders);
    public Map<String,Object> getHomeSum1(Map<String,Object> map);
    public List<Map<String,Object>> getGoodSaleProportion( Map<String,Object> map);
    public  List<Map<String,Object>>   getMonthSales( Map<String,Object> map);
    public  List<Map<String,Object>>   getWeekSales( Map<String,Object> map);

    /**
     * 新增订单
     * 
     * @param xdOrders 订单
     * @return 结果
     */
    public int insertXdOrders(XdOrders xdOrders);

    /**
     * 修改订单
     * 
     * @param xdOrders 订单
     * @return 结果
     */
    public int updateXdOrders(XdOrders xdOrders);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键集合
     * @return 结果
     */
    public int deleteXdOrdersByIds(Long[] ids);

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    public int deleteXdOrdersById(Long id);
}
