package com.ruoyi.XdUserConsumptionRecords.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdUserConsumptionRecords.mapper.XdUserConsumptionRecordsMapper;
import com.ruoyi.XdUserConsumptionRecords.domain.XdUserConsumptionRecords;
import com.ruoyi.XdUserConsumptionRecords.service.IXdUserConsumptionRecordsService;

/**
 * 用户余额消费记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
@Service
public class XdUserConsumptionRecordsServiceImpl implements IXdUserConsumptionRecordsService 
{
    @Autowired
    private XdUserConsumptionRecordsMapper xdUserConsumptionRecordsMapper;

    /**
     * 查询用户余额消费记录
     * 
     * @param id 用户余额消费记录主键
     * @return 用户余额消费记录
     */
    @Override
    public XdUserConsumptionRecords selectXdUserConsumptionRecordsById(Long id)
    {
        return xdUserConsumptionRecordsMapper.selectXdUserConsumptionRecordsById(id);
    }

    /**
     * 查询用户余额消费记录列表
     * 
     * @param xdUserConsumptionRecords 用户余额消费记录
     * @return 用户余额消费记录
     */
    @Override
    public List<XdUserConsumptionRecords> selectXdUserConsumptionRecordsList(XdUserConsumptionRecords xdUserConsumptionRecords)
    {
        return xdUserConsumptionRecordsMapper.selectXdUserConsumptionRecordsList(xdUserConsumptionRecords);
    }

    /**
     * 新增用户余额消费记录
     * 
     * @param xdUserConsumptionRecords 用户余额消费记录
     * @return 结果
     */
    @Override
    public int insertXdUserConsumptionRecords(XdUserConsumptionRecords xdUserConsumptionRecords)
    {
        return xdUserConsumptionRecordsMapper.insertXdUserConsumptionRecords(xdUserConsumptionRecords);
    }

    /**
     * 修改用户余额消费记录
     * 
     * @param xdUserConsumptionRecords 用户余额消费记录
     * @return 结果
     */
    @Override
    public int updateXdUserConsumptionRecords(XdUserConsumptionRecords xdUserConsumptionRecords)
    {
        return xdUserConsumptionRecordsMapper.updateXdUserConsumptionRecords(xdUserConsumptionRecords);
    }

    /**
     * 批量删除用户余额消费记录
     * 
     * @param ids 需要删除的用户余额消费记录主键
     * @return 结果
     */
    @Override
    public int deleteXdUserConsumptionRecordsByIds(Long[] ids)
    {
        return xdUserConsumptionRecordsMapper.deleteXdUserConsumptionRecordsByIds(ids);
    }

    /**
     * 删除用户余额消费记录信息
     * 
     * @param id 用户余额消费记录主键
     * @return 结果
     */
    @Override
    public int deleteXdUserConsumptionRecordsById(Long id)
    {
        return xdUserConsumptionRecordsMapper.deleteXdUserConsumptionRecordsById(id);
    }
}
