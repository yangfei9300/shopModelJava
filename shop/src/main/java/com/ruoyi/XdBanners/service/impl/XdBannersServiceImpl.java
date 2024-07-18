package com.ruoyi.XdBanners.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdBanners.mapper.XdBannersMapper;
import com.ruoyi.XdBanners.domain.XdBanners;
import com.ruoyi.XdBanners.service.IXdBannersService;

/**
 * 轮播图Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdBannersServiceImpl implements IXdBannersService 
{
    @Autowired
    private XdBannersMapper xdBannersMapper;

    /**
     * 查询轮播图
     * 
     * @param id 轮播图主键
     * @return 轮播图
     */
    @Override
    public XdBanners selectXdBannersById(Long id)
    {
        return xdBannersMapper.selectXdBannersById(id);
    }

    /**
     * 查询轮播图列表
     * 
     * @param xdBanners 轮播图
     * @return 轮播图
     */
    @Override
    public List<XdBanners> selectXdBannersList(XdBanners xdBanners)
    {
        return xdBannersMapper.selectXdBannersList(xdBanners);
    }

    /**
     * 新增轮播图
     * 
     * @param xdBanners 轮播图
     * @return 结果
     */
    @Override
    public int insertXdBanners(XdBanners xdBanners)
    {
        LoginUser loginUser= SecurityUtils.getLoginUser();
        xdBanners.setDeptId(loginUser.getDeptId());
        xdBanners.setUserId(loginUser.getUserId());
        xdBanners.setCreateTime(DateUtils.getNowDate());
        return xdBannersMapper.insertXdBanners(xdBanners);
    }

    /**
     * 修改轮播图
     * 
     * @param xdBanners 轮播图
     * @return 结果
     */
    @Override
    public int updateXdBanners(XdBanners xdBanners)
    {
        xdBanners.setUpdateTime(DateUtils.getNowDate());
        return xdBannersMapper.updateXdBanners(xdBanners);
    }

    /**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的轮播图主键
     * @return 结果
     */
    @Override
    public int deleteXdBannersByIds(Long[] ids)
    {
        return xdBannersMapper.deleteXdBannersByIds(ids);
    }

    /**
     * 删除轮播图信息
     * 
     * @param id 轮播图主键
     * @return 结果
     */
    @Override
    public int deleteXdBannersById(Long id)
    {
        return xdBannersMapper.deleteXdBannersById(id);
    }
}
