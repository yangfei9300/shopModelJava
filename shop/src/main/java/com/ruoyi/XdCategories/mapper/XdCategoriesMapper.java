package com.ruoyi.XdCategories.mapper;

import java.util.List;
import com.ruoyi.XdCategories.domain.XdCategories;

/**
 * 商品分类Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface XdCategoriesMapper 
{
    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    public XdCategories selectXdCategoriesById(Long id);

    /**
     * 查询商品分类列表
     * 
     * @param xdCategories 商品分类
     * @return 商品分类集合
     */
    public List<XdCategories> selectXdCategoriesList(XdCategories xdCategories);

    /**
     * 新增商品分类
     * 
     * @param xdCategories 商品分类
     * @return 结果
     */
    public int insertXdCategories(XdCategories xdCategories);

    /**
     * 修改商品分类
     * 
     * @param xdCategories 商品分类
     * @return 结果
     */
    public int updateXdCategories(XdCategories xdCategories);

    /**
     * 删除商品分类
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    public int deleteXdCategoriesById(Long id);

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXdCategoriesByIds(Long[] ids);
}
