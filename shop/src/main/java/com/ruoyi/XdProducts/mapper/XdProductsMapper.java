package com.ruoyi.XdProducts.mapper;

import java.util.List;
import com.ruoyi.XdProducts.domain.XdProducts;

/**
 * 商品Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface XdProductsMapper 
{
    /**
     * 查询商品
     * 
     * @param id 商品主键
     * @return 商品
     */
    public XdProducts selectXdProductsById(Long id);

    /**
     * 查询商品列表
     * 
     * @param xdProducts 商品
     * @return 商品集合
     */
    public List<XdProducts> selectXdProductsList(XdProducts xdProducts);

    /**
     * 新增商品
     * 
     * @param xdProducts 商品
     * @return 结果
     */
    public int insertXdProducts(XdProducts xdProducts);

    /**
     * 修改商品
     * 
     * @param xdProducts 商品
     * @return 结果
     */
    public int updateXdProducts(XdProducts xdProducts);

    /**
     * 删除商品
     * 
     * @param id 商品主键
     * @return 结果
     */
    public int deleteXdProductsById(Long id);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXdProductsByIds(Long[] ids);
}
