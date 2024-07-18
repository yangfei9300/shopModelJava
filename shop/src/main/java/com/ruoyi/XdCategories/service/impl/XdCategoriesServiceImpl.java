package com.ruoyi.XdCategories.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdCategories.mapper.XdCategoriesMapper;
import com.ruoyi.XdCategories.domain.XdCategories;
import com.ruoyi.XdCategories.service.IXdCategoriesService;

/**
 * 商品分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdCategoriesServiceImpl implements IXdCategoriesService 
{
    @Autowired
    private XdCategoriesMapper xdCategoriesMapper;

    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    @Override
    public XdCategories selectXdCategoriesById(Long id)
    {
        return xdCategoriesMapper.selectXdCategoriesById(id);
    }

    /**
     * 查询商品分类列表
     * 
     * @param xdCategories 商品分类
     * @return 商品分类
     */
    @Override
    public List<XdCategories> selectXdCategoriesList(XdCategories xdCategories)
    {
        return xdCategoriesMapper.selectXdCategoriesList(xdCategories);
    }

    /**
     * 新增商品分类
     * 
     * @param xdCategories 商品分类
     * @return 结果
     */
    @Override
    public int insertXdCategories(XdCategories xdCategories)
    {
        LoginUser loginUser= SecurityUtils.getLoginUser();
        xdCategories.setDeptId(loginUser.getDeptId());
        xdCategories.setUserId(loginUser.getUserId());
        xdCategories.setCreateTime(DateUtils.getNowDate());
        return xdCategoriesMapper.insertXdCategories(xdCategories);
    }

    /**
     * 修改商品分类
     * 
     * @param xdCategories 商品分类
     * @return 结果
     */
    @Override
    public int updateXdCategories(XdCategories xdCategories)
    {
        xdCategories.setUpdateTime(DateUtils.getNowDate());
        return xdCategoriesMapper.updateXdCategories(xdCategories);
    }

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteXdCategoriesByIds(Long[] ids)
    {
        return xdCategoriesMapper.deleteXdCategoriesByIds(ids);
    }

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteXdCategoriesById(Long id)
    {
        return xdCategoriesMapper.deleteXdCategoriesById(id);
    }
}
