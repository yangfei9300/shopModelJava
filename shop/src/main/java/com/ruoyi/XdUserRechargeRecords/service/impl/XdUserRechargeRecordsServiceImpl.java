package com.ruoyi.XdUserRechargeRecords.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdUserRechargeRecords.mapper.XdUserRechargeRecordsMapper;
import com.ruoyi.XdUserRechargeRecords.domain.XdUserRechargeRecords;
import com.ruoyi.XdUserRechargeRecords.service.IXdUserRechargeRecordsService;

/**
 * 用户充值记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
@Service
public class XdUserRechargeRecordsServiceImpl implements IXdUserRechargeRecordsService 
{
    @Autowired
    private XdUserRechargeRecordsMapper xdUserRechargeRecordsMapper;

    /**
     * 查询用户充值记录
     * 
     * @param id 用户充值记录主键
     * @return 用户充值记录
     */
    @Override
    public XdUserRechargeRecords selectXdUserRechargeRecordsById(Long id)
    {
        return xdUserRechargeRecordsMapper.selectXdUserRechargeRecordsById(id);
    }

    /**
     * 查询用户充值记录列表
     * 
     * @param xdUserRechargeRecords 用户充值记录
     * @return 用户充值记录
     */
    @Override
    public List<XdUserRechargeRecords> selectXdUserRechargeRecordsList(XdUserRechargeRecords xdUserRechargeRecords)
    {
        return xdUserRechargeRecordsMapper.selectXdUserRechargeRecordsList(xdUserRechargeRecords);
    }

    /**
     * 新增用户充值记录
     * 
     * @param xdUserRechargeRecords 用户充值记录
     * @return 结果
     */
    @Override
    public int insertXdUserRechargeRecords(XdUserRechargeRecords xdUserRechargeRecords)
    {
        return xdUserRechargeRecordsMapper.insertXdUserRechargeRecords(xdUserRechargeRecords);
    }

    /**
     * 修改用户充值记录
     * 
     * @param xdUserRechargeRecords 用户充值记录
     * @return 结果
     */
    @Override
    public int updateXdUserRechargeRecords(XdUserRechargeRecords xdUserRechargeRecords)
    {
        xdUserRechargeRecords.setUpdateTime(DateUtils.getNowDate());
        return xdUserRechargeRecordsMapper.updateXdUserRechargeRecords(xdUserRechargeRecords);
    }

    /**
     * 批量删除用户充值记录
     * 
     * @param ids 需要删除的用户充值记录主键
     * @return 结果
     */
    @Override
    public int deleteXdUserRechargeRecordsByIds(Long[] ids)
    {
        return xdUserRechargeRecordsMapper.deleteXdUserRechargeRecordsByIds(ids);
    }

    /**
     * 删除用户充值记录信息
     * 
     * @param id 用户充值记录主键
     * @return 结果
     */
    @Override
    public int deleteXdUserRechargeRecordsById(Long id)
    {
        return xdUserRechargeRecordsMapper.deleteXdUserRechargeRecordsById(id);
    }
}
