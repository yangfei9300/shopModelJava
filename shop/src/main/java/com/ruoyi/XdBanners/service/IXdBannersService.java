package com.ruoyi.XdBanners.service;

import java.util.List;
import com.ruoyi.XdBanners.domain.XdBanners;

/**
 * 轮播图Service接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface IXdBannersService 
{
    /**
     * 查询轮播图
     * 
     * @param id 轮播图主键
     * @return 轮播图
     */
    public XdBanners selectXdBannersById(Long id);

    /**
     * 查询轮播图列表
     * 
     * @param xdBanners 轮播图
     * @return 轮播图集合
     */
    public List<XdBanners> selectXdBannersList(XdBanners xdBanners);

    /**
     * 新增轮播图
     * 
     * @param xdBanners 轮播图
     * @return 结果
     */
    public int insertXdBanners(XdBanners xdBanners);

    /**
     * 修改轮播图
     * 
     * @param xdBanners 轮播图
     * @return 结果
     */
    public int updateXdBanners(XdBanners xdBanners);

    /**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的轮播图主键集合
     * @return 结果
     */
    public int deleteXdBannersByIds(Long[] ids);

    /**
     * 删除轮播图信息
     * 
     * @param id 轮播图主键
     * @return 结果
     */
    public int deleteXdBannersById(Long id);
}
