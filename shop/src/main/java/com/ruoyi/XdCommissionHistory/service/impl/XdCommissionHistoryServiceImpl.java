package com.ruoyi.XdCommissionHistory.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdCommissionHistory.mapper.XdCommissionHistoryMapper;
import com.ruoyi.XdCommissionHistory.domain.XdCommissionHistory;
import com.ruoyi.XdCommissionHistory.service.IXdCommissionHistoryService;

/**
 * 佣金记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@Service
public class XdCommissionHistoryServiceImpl implements IXdCommissionHistoryService 
{
    @Autowired
    private XdCommissionHistoryMapper xdCommissionHistoryMapper;

    /**
     * 查询佣金记录
     * 
     * @param id 佣金记录主键
     * @return 佣金记录
     */
    @Override
    public XdCommissionHistory selectXdCommissionHistoryById(Long id)
    {
        return xdCommissionHistoryMapper.selectXdCommissionHistoryById(id);
    }

    /**
     * 查询佣金记录列表
     * 
     * @param xdCommissionHistory 佣金记录
     * @return 佣金记录
     */
    @Override
    public List<XdCommissionHistory> selectXdCommissionHistoryList(XdCommissionHistory xdCommissionHistory)
    {
        return xdCommissionHistoryMapper.selectXdCommissionHistoryList(xdCommissionHistory);
    }

    @Override
    public List<XdCommissionHistory> getKickbacks(XdCommissionHistory xdCommissionHistory) {
        return xdCommissionHistoryMapper.getKickbacks(xdCommissionHistory);
    }

    /**
     * 新增佣金记录
     * 
     * @param xdCommissionHistory 佣金记录
     * @return 结果
     */
    @Override
    public int insertXdCommissionHistory(XdCommissionHistory xdCommissionHistory)
    {
        return xdCommissionHistoryMapper.insertXdCommissionHistory(xdCommissionHistory);
    }

    /**
     * 修改佣金记录
     * 
     * @param xdCommissionHistory 佣金记录
     * @return 结果
     */
    @Override
    public int updateXdCommissionHistory(XdCommissionHistory xdCommissionHistory)
    {
        return xdCommissionHistoryMapper.updateXdCommissionHistory(xdCommissionHistory);
    }

    /**
     * 批量删除佣金记录
     * 
     * @param ids 需要删除的佣金记录主键
     * @return 结果
     */
    @Override
    public int deleteXdCommissionHistoryByIds(Long[] ids)
    {
        return xdCommissionHistoryMapper.deleteXdCommissionHistoryByIds(ids);
    }

    /**
     * 删除佣金记录信息
     * 
     * @param id 佣金记录主键
     * @return 结果
     */
    @Override
    public int deleteXdCommissionHistoryById(Long id)
    {
        return xdCommissionHistoryMapper.deleteXdCommissionHistoryById(id);
    }
}
