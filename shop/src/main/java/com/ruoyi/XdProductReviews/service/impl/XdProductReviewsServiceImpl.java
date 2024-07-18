package com.ruoyi.XdProductReviews.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdProductReviews.mapper.XdProductReviewsMapper;
import com.ruoyi.XdProductReviews.domain.XdProductReviews;
import com.ruoyi.XdProductReviews.service.IXdProductReviewsService;

/**
 * 用户评价Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdProductReviewsServiceImpl implements IXdProductReviewsService 
{
    @Autowired
    private XdProductReviewsMapper xdProductReviewsMapper;

    /**
     * 查询用户评价
     * 
     * @param id 用户评价主键
     * @return 用户评价
     */
    @Override
    public XdProductReviews selectXdProductReviewsById(Long id)
    {
        return xdProductReviewsMapper.selectXdProductReviewsById(id);
    }

    /**
     * 查询用户评价列表
     * 
     * @param xdProductReviews 用户评价
     * @return 用户评价
     */
    @Override
    public List<XdProductReviews> selectXdProductReviewsList(XdProductReviews xdProductReviews)
    {
        return xdProductReviewsMapper.selectXdProductReviewsList(xdProductReviews);
    }

    /**
     * 新增用户评价
     * 
     * @param xdProductReviews 用户评价
     * @return 结果
     */
    @Override
    public int insertXdProductReviews(XdProductReviews xdProductReviews)
    {
        xdProductReviews.setCreateTime(DateUtils.getNowDate());
        return xdProductReviewsMapper.insertXdProductReviews(xdProductReviews);
    }

    /**
     * 修改用户评价
     * 
     * @param xdProductReviews 用户评价
     * @return 结果
     */
    @Override
    public int updateXdProductReviews(XdProductReviews xdProductReviews)
    {
        xdProductReviews.setUpdateTime(DateUtils.getNowDate());
        return xdProductReviewsMapper.updateXdProductReviews(xdProductReviews);
    }

    /**
     * 批量删除用户评价
     * 
     * @param ids 需要删除的用户评价主键
     * @return 结果
     */
    @Override
    public int deleteXdProductReviewsByIds(Long[] ids)
    {
        return xdProductReviewsMapper.deleteXdProductReviewsByIds(ids);
    }

    /**
     * 删除用户评价信息
     * 
     * @param id 用户评价主键
     * @return 结果
     */
    @Override
    public int deleteXdProductReviewsById(Long id)
    {
        return xdProductReviewsMapper.deleteXdProductReviewsById(id);
    }
}
