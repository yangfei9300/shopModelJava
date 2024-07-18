package com.ruoyi.XdCarts.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdCarts.mapper.XdCartsMapper;
import com.ruoyi.XdCarts.domain.XdCarts;
import com.ruoyi.XdCarts.service.IXdCartsService;

/**
 * 购物车Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdCartsServiceImpl implements IXdCartsService 
{
    @Autowired
    private XdCartsMapper xdCartsMapper;

    /**
     * 查询购物车
     * 
     * @param id 购物车主键
     * @return 购物车
     */
    @Override
    public XdCarts selectXdCartsById(Long id)
    {
        return xdCartsMapper.selectXdCartsById(id);
    }

    /**
     * 查询购物车列表
     * 
     * @param xdCarts 购物车
     * @return 购物车
     */
    @Override
    public List<XdCarts> selectXdCartsList(XdCarts xdCarts)
    {
        return xdCartsMapper.selectXdCartsList(xdCarts);
    }

    @Override
    public List<XdCarts> getUserCarts(XdCarts xdCarts) {
        return xdCartsMapper.getUserCarts(xdCarts);
    }

    /**
     * 新增购物车
     * 
     * @param xdCarts 购物车
     * @return 结果
     */
    @Override
    public int insertXdCarts(XdCarts xdCarts)
    {
        xdCarts.setCreateTime(DateUtils.getNowDate());
        return xdCartsMapper.insertXdCarts(xdCarts);
    }

    /**
     * 修改购物车
     * 
     * @param xdCarts 购物车
     * @return 结果
     */
    @Override
    public int updateXdCarts(XdCarts xdCarts)
    {
        xdCarts.setUpdateTime(DateUtils.getNowDate());
        return xdCartsMapper.updateXdCarts(xdCarts);
    }

    /**
     * 批量删除购物车
     * 
     * @param ids 需要删除的购物车主键
     * @return 结果
     */
    @Override
    public int deleteXdCartsByIds(Long[] ids)
    {
        return xdCartsMapper.deleteXdCartsByIds(ids);
    }

    /**
     * 删除购物车信息
     * 
     * @param id 购物车主键
     * @return 结果
     */
    @Override
    public int deleteXdCartsById(Long id)
    {
        return xdCartsMapper.deleteXdCartsById(id);
    }
}
