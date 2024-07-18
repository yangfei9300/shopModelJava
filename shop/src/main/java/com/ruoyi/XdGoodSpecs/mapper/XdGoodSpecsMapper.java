package com.ruoyi.XdGoodSpecs.mapper;

import java.util.List;
import com.ruoyi.XdGoodSpecs.domain.XdGoodSpecs;

/**
 * 规格管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface XdGoodSpecsMapper 
{
    /**
     * 查询规格管理
     * 
     * @param id 规格管理主键
     * @return 规格管理
     */
    public XdGoodSpecs selectXdGoodSpecsById(Long id);

    /**
     * 查询规格管理列表
     * 
     * @param xdGoodSpecs 规格管理
     * @return 规格管理集合
     */
    public List<XdGoodSpecs> selectXdGoodSpecsList(XdGoodSpecs xdGoodSpecs);

    /**
     * 新增规格管理
     * 
     * @param xdGoodSpecs 规格管理
     * @return 结果
     */
    public int insertXdGoodSpecs(XdGoodSpecs xdGoodSpecs);

    /**
     * 修改规格管理
     * 
     * @param xdGoodSpecs 规格管理
     * @return 结果
     */
    public int updateXdGoodSpecs(XdGoodSpecs xdGoodSpecs);
    public int updateGoodCount(XdGoodSpecs xdGoodSpecs);

    /**
     * 删除规格管理
     * 
     * @param id 规格管理主键
     * @return 结果
     */
    public int deleteXdGoodSpecsById(Long id);

    /**
     * 批量删除规格管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXdGoodSpecsByIds(Long[] ids);
}
