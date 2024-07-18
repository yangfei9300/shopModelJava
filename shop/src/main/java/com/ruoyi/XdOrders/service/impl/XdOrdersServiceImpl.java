package com.ruoyi.XdOrders.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdOrders.mapper.XdOrdersMapper;
import com.ruoyi.XdOrders.domain.XdOrders;
import com.ruoyi.XdOrders.service.IXdOrdersService;

/**
 * 订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdOrdersServiceImpl implements IXdOrdersService

{
    @Autowired
    private XdOrdersMapper xdOrdersMapper;

    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    @Override
    public XdOrders selectXdOrdersById(Long id)
    {
        return xdOrdersMapper.selectXdOrdersById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param xdOrders 订单
     * @return 订单
     */
    @Override
    public List<XdOrders> selectXdOrdersList(XdOrders xdOrders)
    {
        return xdOrdersMapper.selectXdOrdersList(xdOrders);
    }

    @Override
    public List<XdOrders> getOrders(XdOrders xdOrders) {
        return xdOrdersMapper.getOrders(xdOrders);
    }

//    @Override
//    public Map<String, Object> getHomeSum1(XdOrders xdOrders) {
//        return null;
//    }

    public Map<String,Object> getHomeSum1( Map<String,Object> map) {
        return xdOrdersMapper.getHomeSum1(map);
    }
    public List<Map<String,Object>> getGoodSaleProportion( Map<String,Object> map) {
        return xdOrdersMapper.getGoodSaleProportion(map);
    }
    public List<Map<String,Object>> getMonthSales( Map<String,Object> map) {
        return xdOrdersMapper.getMonthSales(map);
    }
    public List<Map<String,Object>> getWeekSales( Map<String,Object> map) {
        return xdOrdersMapper.getWeekSales(map);
    }


    /**
     * 新增订单
     * 
     * @param xdOrders 订单
     * @return 结果
     */
    @Override
    public int insertXdOrders(XdOrders xdOrders)
    {
        xdOrders.setCreateTime(DateUtils.getNowDate());
        return xdOrdersMapper.insertXdOrders(xdOrders);
    }

    /**
     * 修改订单
     * 
     * @param xdOrders 订单
     * @return 结果
     */
    @Override
    public int updateXdOrders(XdOrders xdOrders)
    {
        xdOrders.setUpdateTime(DateUtils.getNowDate());
        return xdOrdersMapper.updateXdOrders(xdOrders);
    }

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteXdOrdersByIds(Long[] ids)
    {
        return xdOrdersMapper.deleteXdOrdersByIds(ids);
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    @Override
    public int deleteXdOrdersById(Long id)
    {
        return xdOrdersMapper.deleteXdOrdersById(id);
    }
}
