package com.ruoyi.XdUserFeedback.service;

import java.util.List;
import com.ruoyi.XdUserFeedback.domain.XdUserFeedback;

/**
 * 意见反馈Service接口
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public interface IXdUserFeedbackService 
{
    /**
     * 查询意见反馈
     * 
     * @param id 意见反馈主键
     * @return 意见反馈
     */
    public XdUserFeedback selectXdUserFeedbackById(Long id);

    /**
     * 查询意见反馈列表
     * 
     * @param xdUserFeedback 意见反馈
     * @return 意见反馈集合
     */
    public List<XdUserFeedback> selectXdUserFeedbackList(XdUserFeedback xdUserFeedback);

    /**
     * 新增意见反馈
     * 
     * @param xdUserFeedback 意见反馈
     * @return 结果
     */
    public int insertXdUserFeedback(XdUserFeedback xdUserFeedback);

    /**
     * 修改意见反馈
     * 
     * @param xdUserFeedback 意见反馈
     * @return 结果
     */
    public int updateXdUserFeedback(XdUserFeedback xdUserFeedback);

    /**
     * 批量删除意见反馈
     * 
     * @param ids 需要删除的意见反馈主键集合
     * @return 结果
     */
    public int deleteXdUserFeedbackByIds(Long[] ids);

    /**
     * 删除意见反馈信息
     * 
     * @param id 意见反馈主键
     * @return 结果
     */
    public int deleteXdUserFeedbackById(Long id);
}
