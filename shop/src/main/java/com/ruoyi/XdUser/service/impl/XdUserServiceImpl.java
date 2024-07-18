package com.ruoyi.XdUser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdUser.mapper.XdUserMapper;
import com.ruoyi.XdUser.domain.XdUser;
import com.ruoyi.XdUser.service.IXdUserService;

/**
 * 微信用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdUserServiceImpl implements IXdUserService 
{
    @Autowired
    private XdUserMapper xdUserMapper;

    /**
     * 查询微信用户
     * 
     * @param id 微信用户主键
     * @return 微信用户
     */
    @Override
    public XdUser selectXdUserById(Long id)
    {
        return xdUserMapper.selectXdUserById(id);
    }

    /**
     * 查询微信用户列表
     * 
     * @param xdUser 微信用户
     * @return 微信用户
     */
    @Override
    public List<XdUser> selectXdUserList(XdUser xdUser)
    {
        return xdUserMapper.selectXdUserList(xdUser);
    }

    /**
     * 新增微信用户
     * 
     * @param xdUser 微信用户
     * @return 结果
     */
    @Override
    public int insertXdUser(XdUser xdUser)
    {
        xdUser.setCreateTime(DateUtils.getNowDate());
        return xdUserMapper.insertXdUser(xdUser);
    }

    /**
     * 修改微信用户
     * 
     * @param xdUser 微信用户
     * @return 结果
     */
    @Override
    public int updateXdUser(XdUser xdUser)
    {
        xdUser.setUpdateTime(DateUtils.getNowDate());
        return xdUserMapper.updateXdUser(xdUser);
    }

    @Override
    public int updateIntegral(XdUser xdUser) {
        return xdUserMapper.updateIntegral(xdUser);
    }
    public int updateIntegraljian(XdUser xdUser) {
        return xdUserMapper.updateIntegraljian(xdUser);
    }
    /**
     * 批量删除微信用户
     * 
     * @param ids 需要删除的微信用户主键
     * @return 结果
     */
    @Override
    public int deleteXdUserByIds(Long[] ids)
    {
        return xdUserMapper.deleteXdUserByIds(ids);
    }

    /**
     * 删除微信用户信息
     * 
     * @param id 微信用户主键
     * @return 结果
     */
    @Override
    public int deleteXdUserById(Long id)
    {
        return xdUserMapper.deleteXdUserById(id);
    }
}
