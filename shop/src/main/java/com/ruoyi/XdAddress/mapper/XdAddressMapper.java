package com.ruoyi.XdAddress.mapper;

import java.util.List;
import com.ruoyi.XdAddress.domain.XdAddress;

/**
 * 收货地址Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public interface XdAddressMapper 
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
     * 删除收货地址
     * 
     * @param id 收货地址主键
     * @return 结果
     */
    public int deleteXdAddressById(Long id);

    /**
     * 批量删除收货地址
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXdAddressByIds(Long[] ids);
}
