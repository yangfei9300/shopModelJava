package com.ruoyi.XdShopInfo.mapper;

import java.util.List;
import com.ruoyi.XdShopInfo.domain.XdShopInfo;

/**
 * 商城信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
public interface XdShopInfoMapper 
{
    /**
     * 查询商城信息
     * 
     * @param id 商城信息主键
     * @return 商城信息
     */
    public XdShopInfo selectXdShopInfoById(Long id);

    /**
     * 查询商城信息列表
     * 
     * @param xdShopInfo 商城信息
     * @return 商城信息集合
     */
    public List<XdShopInfo> selectXdShopInfoList(XdShopInfo xdShopInfo);

    /**
     * 新增商城信息
     * 
     * @param xdShopInfo 商城信息
     * @return 结果
     */
    public int insertXdShopInfo(XdShopInfo xdShopInfo);

    /**
     * 修改商城信息
     * 
     * @param xdShopInfo 商城信息
     * @return 结果
     */
    public int updateXdShopInfo(XdShopInfo xdShopInfo);

    /**
     * 删除商城信息
     * 
     * @param id 商城信息主键
     * @return 结果
     */
    public int deleteXdShopInfoById(Long id);

    /**
     * 批量删除商城信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXdShopInfoByIds(Long[] ids);
}
