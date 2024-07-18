package com.ruoyi.XdIntegralRecord.mapper;

import java.util.List;
import com.ruoyi.XdIntegralRecord.domain.XdIntegralRecord;

/**
 * 积分记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface XdIntegralRecordMapper 
{
    /**
     * 查询积分记录
     * 
     * @param id 积分记录主键
     * @return 积分记录
     */
    public XdIntegralRecord selectXdIntegralRecordById(Long id);

    /**
     * 查询积分记录列表
     * 
     * @param xdIntegralRecord 积分记录
     * @return 积分记录集合
     */
    public List<XdIntegralRecord> selectXdIntegralRecordList(XdIntegralRecord xdIntegralRecord);

    /**
     * 新增积分记录
     * 
     * @param xdIntegralRecord 积分记录
     * @return 结果
     */
    public int insertXdIntegralRecord(XdIntegralRecord xdIntegralRecord);

    /**
     * 修改积分记录
     * 
     * @param xdIntegralRecord 积分记录
     * @return 结果
     */
    public int updateXdIntegralRecord(XdIntegralRecord xdIntegralRecord);

    /**
     * 删除积分记录
     * 
     * @param id 积分记录主键
     * @return 结果
     */
    public int deleteXdIntegralRecordById(Long id);

    /**
     * 批量删除积分记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXdIntegralRecordByIds(Long[] ids);
}
