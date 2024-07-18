package com.ruoyi.XdAddress.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.XdAddress.domain.XdAddress;
import com.ruoyi.XdAddress.service.IXdAddressService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收货地址Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdAddress/XdAddress")
public class XdAddressController extends BaseController
{
    @Autowired
    private IXdAddressService xdAddressService;

    /**
     * 查询收货地址列表
     */
    @PreAuthorize("@ss.hasPermi('XdAddress:XdAddress:list')")
    @GetMapping("/list")
    @DataScope(deptAlias = "xa", userAlias = "xa")
    public TableDataInfo list(XdAddress xdAddress)
    {
        startPage();
        List<XdAddress> list = xdAddressService.selectXdAddressList(xdAddress);
        return getDataTable(list);
    }

    /**
     * 导出收货地址列表
     */
    @PreAuthorize("@ss.hasPermi('XdAddress:XdAddress:export')")
    @Log(title = "收货地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdAddress xdAddress)
    {
        List<XdAddress> list = xdAddressService.selectXdAddressList(xdAddress);
        ExcelUtil<XdAddress> util = new ExcelUtil<XdAddress>(XdAddress.class);
        util.exportExcel(response, list, "收货地址数据");
    }

    /**
     * 获取收货地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdAddress:XdAddress:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdAddressService.selectXdAddressById(id));
    }

    /**
     * 新增收货地址
     */
    @PreAuthorize("@ss.hasPermi('XdAddress:XdAddress:add')")
    @Log(title = "收货地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdAddress xdAddress)
    {
        return toAjax(xdAddressService.insertXdAddress(xdAddress));
    }

    /**
     * 修改收货地址
     */
    @PreAuthorize("@ss.hasPermi('XdAddress:XdAddress:edit')")
    @Log(title = "收货地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdAddress xdAddress)
    {
        return toAjax(xdAddressService.updateXdAddress(xdAddress));
    }

    /**
     * 删除收货地址
     */
    @PreAuthorize("@ss.hasPermi('XdAddress:XdAddress:remove')")
    @Log(title = "收货地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdAddressService.deleteXdAddressByIds(ids));
    }
}
