package com.ruoyi.XdAddress.service;

import java.util.List;
import com.ruoyi.XdAddress.domain.XdAddress;

/**
 * 收货地址Service接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface IXdAddressService 
{
    /**
     * 查询收货地址
     * 
     * @param id 收货地址主键
     * @return 收货地址
     */
    public XdAddress selectXdAddressById(Long id);

    /**
     * 查询收货地址列表
     * 
     * @param xdAddress 收货地址
     * @return 收货地址集合
     */
    public List<XdAddress> selectXdAddressList(XdAddress xdAddress);

    /**
     * 新增收货地址
     * 
     * @param xdAddress 收货地址
     * @return 结果
     */
    public int insertXdAddress(XdAddress xdAddress);

    /**
     * 修改收货地址
     * 
     * @param xdAddress 收货地址
     * @return 结果
     */
    public int updateXdAddress(XdAddress xdAddress);

    /**
     * 批量删除收货地址
     * 
     * @param ids 需要删除的收货地址主键集合
     * @return 结果
     */
    public int deleteXdAddressByIds(Long[] ids);

    /**
     * 删除收货地址信息
     * 
     * @param id 收货地址主键
     * @return 结果
     */
    public int deleteXdAddressById(Long id);
}
