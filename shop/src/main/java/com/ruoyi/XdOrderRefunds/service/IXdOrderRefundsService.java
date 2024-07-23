package com.ruoyi.XdOrderRefunds.service;

import java.util.List;
import com.ruoyi.XdOrderRefunds.domain.XdOrderRefunds;

/**
 * 订单退款Service接口
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public interface IXdOrderRefundsService 
{
    /**
     * 查询订单退款
     * 
     * @param id 订单退款主键
     * @return 订单退款
     */
    public XdOrderRefunds selectXdOrderRefundsById(Long id);

    /**
     * 查询订单退款列表
     * 
     * @param xdOrderRefunds 订单退款
     * @return 订单退款集合
     */
    public List<XdOrderRefunds> selectXdOrderRefundsList(XdOrderRefunds xdOrderRefunds);

    /**
     * 新增订单退款
     * 
     * @param xdOrderRefunds 订单退款
     * @return 结果
     */
    public int insertXdOrderRefunds(XdOrderRefunds xdOrderRefunds);

    /**
     * 修改订单退款
     * 
     * @param xdOrderRefunds 订单退款
     * @return 结果
     */
    public int updateXdOrderRefunds(XdOrderRefunds xdOrderRefunds);

    /**
     * 批量删除订单退款
     * 
     * @param ids 需要删除的订单退款主键集合
     * @return 结果
     */
    public int deleteXdOrderRefundsByIds(Long[] ids);

    /**
     * 删除订单退款信息
     * 
     * @param id 订单退款主键
     * @return 结果
     */
    public int deleteXdOrderRefundsById(Long id);
}
