package com.ruoyi.XdIntegralRecord.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdIntegralRecord.mapper.XdIntegralRecordMapper;
import com.ruoyi.XdIntegralRecord.domain.XdIntegralRecord;
import com.ruoyi.XdIntegralRecord.service.IXdIntegralRecordService;

/**
 * 积分记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdIntegralRecordServiceImpl implements IXdIntegralRecordService 
{
    @Autowired
    private XdIntegralRecordMapper xdIntegralRecordMapper;

    /**
     * 查询积分记录
     * 
     * @param id 积分记录主键
     * @return 积分记录
     */
    @Override
    public XdIntegralRecord selectXdIntegralRecordById(Long id)
    {
        return xdIntegralRecordMapper.selectXdIntegralRecordById(id);
    }

    /**
     * 查询积分记录列表
     * 
     * @param xdIntegralRecord 积分记录
     * @return 积分记录
     */
    @Override
    public List<XdIntegralRecord> selectXdIntegralRecordList(XdIntegralRecord xdIntegralRecord)
    {
        return xdIntegralRecordMapper.selectXdIntegralRecordList(xdIntegralRecord);
    }

    /**
     * 新增积分记录
     * 
     * @param xdIntegralRecord 积分记录
     * @return 结果
     */
    @Override
    public int insertXdIntegralRecord(XdIntegralRecord xdIntegralRecord)
    {
        xdIntegralRecord.setCreateTime(DateUtils.getNowDate());
        return xdIntegralRecordMapper.insertXdIntegralRecord(xdIntegralRecord);
    }

    /**
     * 修改积分记录
     * 
     * @param xdIntegralRecord 积分记录
     * @return 结果
     */
    @Override
    public int updateXdIntegralRecord(XdIntegralRecord xdIntegralRecord)
    {
        return xdIntegralRecordMapper.updateXdIntegralRecord(xdIntegralRecord);
    }

    /**
     * 批量删除积分记录
     * 
     * @param ids 需要删除的积分记录主键
     * @return 结果
     */
    @Override
    public int deleteXdIntegralRecordByIds(Long[] ids)
    {
        return xdIntegralRecordMapper.deleteXdIntegralRecordByIds(ids);
    }

    /**
     * 删除积分记录信息
     * 
     * @param id 积分记录主键
     * @return 结果
     */
    @Override
    public int deleteXdIntegralRecordById(Long id)
    {
        return xdIntegralRecordMapper.deleteXdIntegralRecordById(id);
    }
}
