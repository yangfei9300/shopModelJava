package com.ruoyi.XdCustomerService.service;

import java.util.List;
import com.ruoyi.XdCustomerService.domain.XdCustomerService;

/**
 * 客服信息Service接口
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
public interface IXdCustomerServiceService 
{
    /**
     * 查询客服信息
     * 
     * @param id 客服信息主键
     * @return 客服信息
     */
    public XdCustomerService selectXdCustomerServiceById(Long id);

    /**
     * 查询客服信息列表
     * 
     * @param xdCustomerService 客服信息
     * @return 客服信息集合
     */
    public List<XdCustomerService> selectXdCustomerServiceList(XdCustomerService xdCustomerService);

    /**
     * 新增客服信息
     * 
     * @param xdCustomerService 客服信息
     * @return 结果
     */
    public int insertXdCustomerService(XdCustomerService xdCustomerService);

    /**
     * 修改客服信息
     * 
     * @param xdCustomerService 客服信息
     * @return 结果
     */
    public int updateXdCustomerService(XdCustomerService xdCustomerService);

    /**
     * 批量删除客服信息
     * 
     * @param ids 需要删除的客服信息主键集合
     * @return 结果
     */
    public int deleteXdCustomerServiceByIds(Long[] ids);

    /**
     * 删除客服信息信息
     * 
     * @param id 客服信息主键
     * @return 结果
     */
    public int deleteXdCustomerServiceById(Long id);
}
