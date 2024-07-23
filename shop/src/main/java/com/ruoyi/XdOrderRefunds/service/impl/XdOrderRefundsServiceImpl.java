package com.ruoyi.XdOrderRefunds.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdOrderRefunds.mapper.XdOrderRefundsMapper;
import com.ruoyi.XdOrderRefunds.domain.XdOrderRefunds;
import com.ruoyi.XdOrderRefunds.service.IXdOrderRefundsService;

/**
 * 订单退款Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@Service
public class XdOrderRefundsServiceImpl implements IXdOrderRefundsService 
{
    @Autowired
    private XdOrderRefundsMapper xdOrderRefundsMapper;

    /**
     * 查询订单退款
     * 
     * @param id 订单退款主键
     * @return 订单退款
     */
    @Override
    public XdOrderRefunds selectXdOrderRefundsById(Long id)
    {
        return xdOrderRefundsMapper.selectXdOrderRefundsById(id);
    }

    /**
     * 查询订单退款列表
     * 
     * @param xdOrderRefunds 订单退款
     * @return 订单退款
     */
    @Override
    public List<XdOrderRefunds> selectXdOrderRefundsList(XdOrderRefunds xdOrderRefunds)
    {
        return xdOrderRefundsMapper.selectXdOrderRefundsList(xdOrderRefunds);
    }

    /**
     * 新增订单退款
     * 
     * @param xdOrderRefunds 订单退款
     * @return 结果
     */
    @Override
    public int insertXdOrderRefunds(XdOrderRefunds xdOrderRefunds)
    {
        return xdOrderRefundsMapper.insertXdOrderRefunds(xdOrderRefunds);
    }

    /**
     * 修改订单退款
     * 
     * @param xdOrderRefunds 订单退款
     * @return 结果
     */
    @Override
    public int updateXdOrderRefunds(XdOrderRefunds xdOrderRefunds)
    {
        return xdOrderRefundsMapper.updateXdOrderRefunds(xdOrderRefunds);
    }

    /**
     * 批量删除订单退款
     * 
     * @param ids 需要删除的订单退款主键
     * @return 结果
     */
    @Override
    public int deleteXdOrderRefundsByIds(Long[] ids)
    {
        return xdOrderRefundsMapper.deleteXdOrderRefundsByIds(ids);
    }

    /**
     * 删除订单退款信息
     * 
     * @param id 订单退款主键
     * @return 结果
     */
    @Override
    public int deleteXdOrderRefundsById(Long id)
    {
        return xdOrderRefundsMapper.deleteXdOrderRefundsById(id);
    }
}
