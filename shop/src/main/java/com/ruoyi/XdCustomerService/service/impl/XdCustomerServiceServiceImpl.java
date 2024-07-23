package com.ruoyi.XdCustomerService.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.XdCustomerService.mapper.XdCustomerServiceMapper;
import com.ruoyi.XdCustomerService.domain.XdCustomerService;
import com.ruoyi.XdCustomerService.service.IXdCustomerServiceService;

/**
 * 客服信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
@Service
public class XdCustomerServiceServiceImpl implements IXdCustomerServiceService 
{
    @Autowired
    private XdCustomerServiceMapper xdCustomerServiceMapper;

    /**
     * 查询客服信息
     * 
     * @param id 客服信息主键
     * @return 客服信息
     */
    @Override
    public XdCustomerService selectXdCustomerServiceById(Long id)
    {
        return xdCustomerServiceMapper.selectXdCustomerServiceById(id);
    }

    /**
     * 查询客服信息列表
     * 
     * @param xdCustomerService 客服信息
     * @return 客服信息
     */
    @Override
    public List<XdCustomerService> selectXdCustomerServiceList(XdCustomerService xdCustomerService)
    {
        return xdCustomerServiceMapper.selectXdCustomerServiceList(xdCustomerService);
    }

    /**
     * 新增客服信息
     * 
     * @param xdCustomerService 客服信息
     * @return 结果
     */
    @Override
    public int insertXdCustomerService(XdCustomerService xdCustomerService)
    {
        LoginUser loginUser= SecurityUtils.getLoginUser();
        xdCustomerService.setDeptId(loginUser.getDeptId());
        xdCustomerService.setCreatedTime(new Date());
        return xdCustomerServiceMapper.insertXdCustomerService(xdCustomerService);
    }

    /**
     * 修改客服信息
     * 
     * @param xdCustomerService 客服信息
     * @return 结果
     */
    @Override
    public int updateXdCustomerService(XdCustomerService xdCustomerService)
    {
        return xdCustomerServiceMapper.updateXdCustomerService(xdCustomerService);
    }

    /**
     * 批量删除客服信息
     * 
     * @param ids 需要删除的客服信息主键
     * @return 结果
     */
    @Override
    public int deleteXdCustomerServiceByIds(Long[] ids)
    {
        return xdCustomerServiceMapper.deleteXdCustomerServiceByIds(ids);
    }

    /**
     * 删除客服信息信息
     * 
     * @param id 客服信息主键
     * @return 结果
     */
    @Override
    public int deleteXdCustomerServiceById(Long id)
    {
        return xdCustomerServiceMapper.deleteXdCustomerServiceById(id);
    }
}
