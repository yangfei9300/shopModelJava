package com.ruoyi.XdCommissionHistory.mapper;

import java.util.List;
import com.ruoyi.XdCommissionHistory.domain.XdCommissionHistory;

/**
 * 佣金记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public interface XdCommissionHistoryMapper 
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
     * 删除佣金记录
     * 
     * @param id 佣金记录主键
     * @return 结果
     */
    public int deleteXdCommissionHistoryById(Long id);

    /**
     * 批量删除佣金记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXdCommissionHistoryByIds(Long[] ids);
}
