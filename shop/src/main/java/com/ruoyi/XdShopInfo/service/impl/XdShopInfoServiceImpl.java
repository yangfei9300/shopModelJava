package com.ruoyi.XdShopInfo.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdShopInfo.mapper.XdShopInfoMapper;
import com.ruoyi.XdShopInfo.domain.XdShopInfo;
import com.ruoyi.XdShopInfo.service.IXdShopInfoService;

/**
 * 商城信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
@Service
public class XdShopInfoServiceImpl implements IXdShopInfoService 
{
    @Autowired
    private XdShopInfoMapper xdShopInfoMapper;

    /**
     * 查询商城信息
     * 
     * @param id 商城信息主键
     * @return 商城信息
     */
    @Override
    public XdShopInfo selectXdShopInfoById(Long id)
    {
        return xdShopInfoMapper.selectXdShopInfoById(id);
    }

    /**
     * 查询商城信息列表
     * 
     * @param xdShopInfo 商城信息
     * @return 商城信息
     */
    @Override
    public List<XdShopInfo> selectXdShopInfoList(XdShopInfo xdShopInfo)
    {
        return xdShopInfoMapper.selectXdShopInfoList(xdShopInfo);
    }

    /**
     * 新增商城信息
     * 
     * @param xdShopInfo 商城信息
     * @return 结果
     */
    @Override
    public int insertXdShopInfo(XdShopInfo xdShopInfo)
    {
        LoginUser loginUser= SecurityUtils.getLoginUser();
        xdShopInfo.setDeptId(loginUser.getDeptId()+"");
        xdShopInfo.setCreateTime(DateUtils.getNowDate());
        return xdShopInfoMapper.insertXdShopInfo(xdShopInfo);
    }

    /**
     * 修改商城信息
     * 
     * @param xdShopInfo 商城信息
     * @return 结果
     */
    @Override
    public int updateXdShopInfo(XdShopInfo xdShopInfo)
    {
        xdShopInfo.setUpdateTime(DateUtils.getNowDate());
        return xdShopInfoMapper.updateXdShopInfo(xdShopInfo);
    }

    /**
     * 批量删除商城信息
     * 
     * @param ids 需要删除的商城信息主键
     * @return 结果
     */
    @Override
    public int deleteXdShopInfoByIds(Long[] ids)
    {
        return xdShopInfoMapper.deleteXdShopInfoByIds(ids);
    }

    /**
     * 删除商城信息信息
     * 
     * @param id 商城信息主键
     * @return 结果
     */
    @Override
    public int deleteXdShopInfoById(Long id)
    {
        return xdShopInfoMapper.deleteXdShopInfoById(id);
    }
}
