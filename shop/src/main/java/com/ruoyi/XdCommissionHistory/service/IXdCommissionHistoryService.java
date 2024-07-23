package com.ruoyi.XdCommissionHistory.service;

import java.util.List;
import com.ruoyi.XdCommissionHistory.domain.XdCommissionHistory;

/**
 * 佣金记录Service接口
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public interface IXdCommissionHistoryService 
{
    /**
     * 查询佣金记录
     * 
     * @param id 佣金记录主键
     * @return 佣金记录
     */
    public XdCommissionHistory selectXdCommissionHistoryById(Long id);

    /**
     * 查询佣金记录列表
     * 
     * @param xdCommissionHistory 佣金记录
     * @return 佣金记录集合
     */
    public List<XdCommissionHistory> selectXdCommissionHistoryList(XdCommissionHistory xdCommissionHistory);

    public List<XdCommissionHistory> getKickbacks(XdCommissionHistory xdCommissionHistory);
    /**
     * 新增佣金记录
     * 
     * @param xdCommissionHistory 佣金记录
     * @return 结果
     */
    public int insertXdCommissionHistory(XdCommissionHistory xdCommissionHistory);

    /**
     * 修改佣金记录
     * 
     * @param xdCommissionHistory 佣金记录
     * @return 结果
     */
    public int updateXdCommissionHistory(XdCommissionHistory xdCommissionHistory);

    /**
     * 批量删除佣金记录
     * 
     * @param ids 需要删除的佣金记录主键集合
     * @return 结果
     */
    public int deleteXdCommissionHistoryByIds(Long[] ids);

    /**
     * 删除佣金记录信息
     * 
     * @param id 佣金记录主键
     * @return 结果
     */
    public int deleteXdCommissionHistoryById(Long id);
}
