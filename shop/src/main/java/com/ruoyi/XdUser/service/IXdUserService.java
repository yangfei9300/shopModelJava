package com.ruoyi.XdUser.service;

import java.util.List;
import com.ruoyi.XdUser.domain.XdUser;

/**
 * 微信用户Service接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface IXdUserService 
{
    /**
     * 查询微信用户
     * 
     * @param id 微信用户主键
     * @return 微信用户
     */
    public XdUser selectXdUserById(Long id);

    /**
     * 查询微信用户列表
     * 
     * @param xdUser 微信用户
     * @return 微信用户集合
     */
    public List<XdUser> selectXdUserList(XdUser xdUser);

    /**
     * 新增微信用户
     * 
     * @param xdUser 微信用户
     * @return 结果
     */
    public int insertXdUser(XdUser xdUser);

    /**
     * 修改微信用户
     * 
     * @param xdUser 微信用户
     * @return 结果
     */
    public int updateXdUser(XdUser xdUser);
    public int updateIntegral(XdUser xdUser);
    public int updateIntegraljian(XdUser xdUser);
    /**
     * 批量删除微信用户
     * 
     * @param ids 需要删除的微信用户主键集合
     * @return 结果
     */
    public int deleteXdUserByIds(Long[] ids);

    /**
     * 删除微信用户信息
     * 
     * @param id 微信用户主键
     * @return 结果
     */
    public int deleteXdUserById(Long id);
}
