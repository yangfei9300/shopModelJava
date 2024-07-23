package com.ruoyi.XdUserConsumptionRecords.service;

import java.util.List;
import com.ruoyi.XdUserConsumptionRecords.domain.XdUserConsumptionRecords;

/**
 * 用户余额消费记录Service接口
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
public interface IXdUserConsumptionRecordsService 
{
    /**
     * 查询用户余额消费记录
     * 
     * @param id 用户余额消费记录主键
     * @return 用户余额消费记录
     */
    public XdUserConsumptionRecords selectXdUserConsumptionRecordsById(Long id);

    /**
     * 查询用户余额消费记录列表
     * 
     * @param xdUserConsumptionRecords 用户余额消费记录
     * @return 用户余额消费记录集合
     */
    public List<XdUserConsumptionRecords> selectXdUserConsumptionRecordsList(XdUserConsumptionRecords xdUserConsumptionRecords);

    /**
     * 新增用户余额消费记录
     * 
     * @param xdUserConsumptionRecords 用户余额消费记录
     * @return 结果
     */
    public int insertXdUserConsumptionRecords(XdUserConsumptionRecords xdUserConsumptionRecords);

    /**
     * 修改用户余额消费记录
     * 
     * @param xdUserConsumptionRecords 用户余额消费记录
     * @return 结果
     */
    public int updateXdUserConsumptionRecords(XdUserConsumptionRecords xdUserConsumptionRecords);

    /**
     * 批量删除用户余额消费记录
     * 
     * @param ids 需要删除的用户余额消费记录主键集合
     * @return 结果
     */
    public int deleteXdUserConsumptionRecordsByIds(Long[] ids);

    /**
     * 删除用户余额消费记录信息
     * 
     * @param id 用户余额消费记录主键
     * @return 结果
     */
    public int deleteXdUserConsumptionRecordsById(Long id);
}
