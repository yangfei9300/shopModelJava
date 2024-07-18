package com.ruoyi.XdProducts.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdProducts.mapper.XdProductsMapper;
import com.ruoyi.XdProducts.domain.XdProducts;
import com.ruoyi.XdProducts.service.IXdProductsService;

/**
 * 商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdProductsServiceImpl implements IXdProductsService 
{
    @Autowired
    private XdProductsMapper xdProductsMapper;

    /**
     * 查询商品
     * 
     * @param id 商品主键
     * @return 商品
     */
    @Override
    public XdProducts selectXdProductsById(Long id)
    {
        return xdProductsMapper.selectXdProductsById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param xdProducts 商品
     * @return 商品
     */
    @Override
    public List<XdProducts> selectXdProductsList(XdProducts xdProducts)
    {
        return xdProductsMapper.selectXdProductsList(xdProducts);
    }

    /**
     * 新增商品
     * 
     * @param xdProducts 商品
     * @return 结果
     */
    @Override
    public int insertXdProducts(XdProducts xdProducts)
    {
        LoginUser loginUser= SecurityUtils.getLoginUser();
        xdProducts.setDeptId(loginUser.getDeptId());
        xdProducts.setUserId(loginUser.getUserId());
        xdProducts.setCreateTime(DateUtils.getNowDate());
        return xdProductsMapper.insertXdProducts(xdProducts);
    }

    /**
     * 修改商品
     * 
     * @param xdProducts 商品
     * @return 结果
     */
    @Override
    public int updateXdProducts(XdProducts xdProducts)
    {
        xdProducts.setUpdateTime(DateUtils.getNowDate());
        return xdProductsMapper.updateXdProducts(xdProducts);
    }

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteXdProductsByIds(Long[] ids)
    {
        return xdProductsMapper.deleteXdProductsByIds(ids);
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品主键
     * @return 结果
     */
    @Override
    public int deleteXdProductsById(Long id)
    {
        return xdProductsMapper.deleteXdProductsById(id);
    }
}
