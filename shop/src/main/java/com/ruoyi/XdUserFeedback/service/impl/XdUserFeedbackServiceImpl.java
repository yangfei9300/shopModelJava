package com.ruoyi.XdUserFeedback.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdUserFeedback.mapper.XdUserFeedbackMapper;
import com.ruoyi.XdUserFeedback.domain.XdUserFeedback;
import com.ruoyi.XdUserFeedback.service.IXdUserFeedbackService;

/**
 * 意见反馈Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@Service
public class XdUserFeedbackServiceImpl implements IXdUserFeedbackService 
{
    @Autowired
    private XdUserFeedbackMapper xdUserFeedbackMapper;

    /**
     * 查询意见反馈
     * 
     * @param id 意见反馈主键
     * @return 意见反馈
     */
    @Override
    public XdUserFeedback selectXdUserFeedbackById(Long id)
    {
        return xdUserFeedbackMapper.selectXdUserFeedbackById(id);
    }

    /**
     * 查询意见反馈列表
     * 
     * @param xdUserFeedback 意见反馈
     * @return 意见反馈
     */
    @Override
    public List<XdUserFeedback> selectXdUserFeedbackList(XdUserFeedback xdUserFeedback)
    {
        return xdUserFeedbackMapper.selectXdUserFeedbackList(xdUserFeedback);
    }

    /**
     * 新增意见反馈
     * 
     * @param xdUserFeedback 意见反馈
     * @return 结果
     */
    @Override
    public int insertXdUserFeedback(XdUserFeedback xdUserFeedback)
    {
        return xdUserFeedbackMapper.insertXdUserFeedback(xdUserFeedback);
    }

    /**
     * 修改意见反馈
     * 
     * @param xdUserFeedback 意见反馈
     * @return 结果
     */
    @Override
    public int updateXdUserFeedback(XdUserFeedback xdUserFeedback)
    {
        xdUserFeedback.setUpdateTime(DateUtils.getNowDate());
        return xdUserFeedbackMapper.updateXdUserFeedback(xdUserFeedback);
    }

    /**
     * 批量删除意见反馈
     * 
     * @param ids 需要删除的意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteXdUserFeedbackByIds(Long[] ids)
    {
        return xdUserFeedbackMapper.deleteXdUserFeedbackByIds(ids);
    }

    /**
     * 删除意见反馈信息
     * 
     * @param id 意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteXdUserFeedbackById(Long id)
    {
        return xdUserFeedbackMapper.deleteXdUserFeedbackById(id);
    }
}
