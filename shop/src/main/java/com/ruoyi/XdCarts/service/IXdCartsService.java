package com.ruoyi.XdCarts.service;

import java.util.List;
import com.ruoyi.XdCarts.domain.XdCarts;

/**
 * 购物车Service接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface IXdCartsService 
{
    /**
     * 查询购物车
     * 
     * @param id 购物车主键
     * @return 购物车
     */
    public XdCarts selectXdCartsById(Long id);

    /**
     * 查询购物车列表
     * 
     * @param xdCarts 购物车
     * @return 购物车集合
     */
    public List<XdCarts> selectXdCartsList(XdCarts xdCarts);
    public List<XdCarts> getUserCarts(XdCarts xdCarts);

    /**
     * 新增购物车
     * 
     * @param xdCarts 购物车
     * @return 结果
     */
    public int insertXdCarts(XdCarts xdCarts);

    /**
     * 修改购物车
     * 
     * @param xdCarts 购物车
     * @return 结果
     */
    public int updateXdCarts(XdCarts xdCarts);

    /**
     * 批量删除购物车
     * 
     * @param ids 需要删除的购物车主键集合
     * @return 结果
     */
    public int deleteXdCartsByIds(Long[] ids);

    /**
     * 删除购物车信息
     * 
     * @param id 购物车主键
     * @return 结果
     */
    public int deleteXdCartsById(Long id);
}
