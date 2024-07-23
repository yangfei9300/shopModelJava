package com.ruoyi.XdUserRechargeRecords.mapper;

import java.util.List;
import com.ruoyi.XdUserRechargeRecords.domain.XdUserRechargeRecords;

/**
 * 用户充值记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
public interface XdUserRechargeRecordsMapper 
{
    /**
     * 查询用户充值记录
     * 
     * @param id 用户充值记录主键
     * @return 用户充值记录
     */
    public XdUserRechargeRecords selectXdUserRechargeRecordsById(Long id);

    /**
     * 查询用户充值记录列表
     * 
     * @param xdUserRechargeRecords 用户充值记录
     * @return 用户充值记录集合
     */
    public List<XdUserRechargeRecords> selectXdUserRechargeRecordsList(XdUserRechargeRecords xdUserRechargeRecords);

    /**
     * 新增用户充值记录
     * 
     * @param xdUserRechargeRecords 用户充值记录
     * @return 结果
     */
    public int insertXdUserRechargeRecords(XdUserRechargeRecords xdUserRechargeRecords);

    /**
     * 修改用户充值记录
     * 
     * @param xdUserRechargeRecords 用户充值记录
     * @return 结果
     */
    public int updateXdUserRechargeRecords(XdUserRechargeRecords xdUserRechargeRecords);

    /**
     * 删除用户充值记录
     * 
     * @param id 用户充值记录主键
     * @return 结果
     */
    public int deleteXdUserRechargeRecordsById(Long id);

    /**
     * 批量删除用户充值记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXdUserRechargeRecordsByIds(Long[] ids);
}
