package com.ruoyi.XdGoodSpecs.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdGoodSpecs.mapper.XdGoodSpecsMapper;
import com.ruoyi.XdGoodSpecs.domain.XdGoodSpecs;
import com.ruoyi.XdGoodSpecs.service.IXdGoodSpecsService;

/**
 * 规格管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdGoodSpecsServiceImpl implements IXdGoodSpecsService 
{
    @Autowired
    private XdGoodSpecsMapper xdGoodSpecsMapper;

    /**
     * 查询规格管理
     * 
     * @param id 规格管理主键
     * @return 规格管理
     */
    @Override
    public XdGoodSpecs selectXdGoodSpecsById(Long id)
    {
        return xdGoodSpecsMapper.selectXdGoodSpecsById(id);
    }

    /**
     * 查询规格管理列表
     * 
     * @param xdGoodSpecs 规格管理
     * @return 规格管理
     */
    @Override
    public List<XdGoodSpecs> selectXdGoodSpecsList(XdGoodSpecs xdGoodSpecs)
    {
        return xdGoodSpecsMapper.selectXdGoodSpecsList(xdGoodSpecs);
    }

    /**
     * 新增规格管理
     * 
     * @param xdGoodSpecs 规格管理
     * @return 结果
     */
    @Override
    public int insertXdGoodSpecs(XdGoodSpecs xdGoodSpecs)
    {
        LoginUser loginUser= SecurityUtils.getLoginUser();
        xdGoodSpecs.setDeptId(loginUser.getDeptId());
        xdGoodSpecs.setUserId(loginUser.getUserId());
        xdGoodSpecs.setCreateTime(DateUtils.getNowDate());
        return xdGoodSpecsMapper.insertXdGoodSpecs(xdGoodSpecs);
    }

    /**
     * 修改规格管理
     * 
     * @param xdGoodSpecs 规格管理
     * @return 结果
     */
    @Override
    public int updateXdGoodSpecs(XdGoodSpecs xdGoodSpecs)
    {
        xdGoodSpecs.setUpdateTime(DateUtils.getNowDate());
        return xdGoodSpecsMapper.updateXdGoodSpecs(xdGoodSpecs);
    }
    public int updateGoodCount(XdGoodSpecs xdGoodSpecs)
    {
        return xdGoodSpecsMapper.updateGoodCount(xdGoodSpecs);
    }

    /**
     * 批量删除规格管理
     * 
     * @param ids 需要删除的规格管理主键
     * @return 结果
     */
    @Override
    public int deleteXdGoodSpecsByIds(Long[] ids)
    {
        return xdGoodSpecsMapper.deleteXdGoodSpecsByIds(ids);
    }

    /**
     * 删除规格管理信息
     * 
     * @param id 规格管理主键
     * @return 结果
     */
    @Override
    public int deleteXdGoodSpecsById(Long id)
    {
        return xdGoodSpecsMapper.deleteXdGoodSpecsById(id);
    }
}
