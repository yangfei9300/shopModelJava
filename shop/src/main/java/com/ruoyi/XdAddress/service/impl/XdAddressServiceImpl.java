package com.ruoyi.XdAddress.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdAddress.mapper.XdAddressMapper;
import com.ruoyi.XdAddress.domain.XdAddress;
import com.ruoyi.XdAddress.service.IXdAddressService;

/**
 * 收货地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class XdAddressServiceImpl implements IXdAddressService 
{
    @Autowired
    private XdAddressMapper xdAddressMapper;

    /**
     * 查询收货地址
     * 
     * @param id 收货地址主键
     * @return 收货地址
     */
    @Override
    public XdAddress selectXdAddressById(Long id)
    {
        return xdAddressMapper.selectXdAddressById(id);
    }

    /**
     * 查询收货地址列表
     * 
     * @param xdAddress 收货地址
     * @return 收货地址
     */
    @Override
    public List<XdAddress> selectXdAddressList(XdAddress xdAddress)
    {
        return xdAddressMapper.selectXdAddressList(xdAddress);
    }

    /**
     * 新增收货地址
     * 
     * @param xdAddress 收货地址
     * @return 结果
     */
    @Override
    public int insertXdAddress(XdAddress xdAddress)
    {
        xdAddress.setCreateTime(DateUtils.getNowDate());
        return xdAddressMapper.insertXdAddress(xdAddress);
    }

    /**
     * 修改收货地址
     * 
     * @param xdAddress 收货地址
     * @return 结果
     */
    @Override
    public int updateXdAddress(XdAddress xdAddress)
    {
        xdAddress.setUpdateTime(DateUtils.getNowDate());
        return xdAddressMapper.updateXdAddress(xdAddress);
    }

    /**
     * 批量删除收货地址
     * 
     * @param ids 需要删除的收货地址主键
     * @return 结果
     */
    @Override
    public int deleteXdAddressByIds(Long[] ids)
    {
        return xdAddressMapper.deleteXdAddressByIds(ids);
    }

    /**
     * 删除收货地址信息
     * 
     * @param id 收货地址主键
     * @return 结果
     */
    @Override
    public int deleteXdAddressById(Long id)
    {
        return xdAddressMapper.deleteXdAddressById(id);
    }
}
