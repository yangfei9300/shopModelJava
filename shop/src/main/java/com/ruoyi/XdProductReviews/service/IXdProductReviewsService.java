package com.ruoyi.XdProductReviews.service;

import java.util.List;
import com.ruoyi.XdProductReviews.domain.XdProductReviews;

/**
 * 用户评价Service接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface IXdProductReviewsService 
{
    /**
     * 查询用户评价
     * 
     * @param id 用户评价主键
     * @return 用户评价
     */
    public XdProductReviews selectXdProductReviewsById(Long id);

    /**
     * 查询用户评价列表
     * 
     * @param xdProductReviews 用户评价
     * @return 用户评价集合
     */
    public List<XdProductReviews> selectXdProductReviewsList(XdProductReviews xdProductReviews);

    /**
     * 新增用户评价
     * 
     * @param xdProductReviews 用户评价
     * @return 结果
     */
    public int insertXdProductReviews(XdProductReviews xdProductReviews);

    /**
     * 修改用户评价
     * 
     * @param xdProductReviews 用户评价
     * @return 结果
     */
    public int updateXdProductReviews(XdProductReviews xdProductReviews);

    /**
     * 批量删除用户评价
     * 
     * @param ids 需要删除的用户评价主键集合
     * @return 结果
     */
    public int deleteXdProductReviewsByIds(Long[] ids);

    /**
     * 删除用户评价信息
     * 
     * @param id 用户评价主键
     * @return 结果
     */
    public int deleteXdProductReviewsById(Long id);
}
