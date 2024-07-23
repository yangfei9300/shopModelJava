package com.ruoyi.XdCustomerService.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.XdCustomerService.domain.XdCustomerService;
import com.ruoyi.XdCustomerService.service.IXdCustomerServiceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客服信息Controller
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
@RestController
@RequestMapping("/XdCustomerService/XdCustomerService")
public class XdCustomerServiceController extends BaseController
{
    @Autowired
    private IXdCustomerServiceService xdCustomerServiceService;

    /**
     * 查询客服信息列表
     */
    @PreAuthorize("@ss.hasPermi('XdCustomerService:XdCustomerService:list')")
    @GetMapping("/list")
    public TableDataInfo list(XdCustomerService xdCustomerService)
    {
        startPage();
        List<XdCustomerService> list = xdCustomerServiceService.selectXdCustomerServiceList(xdCustomerService);
        return getDataTable(list);
    }

    /**
     * 导出客服信息列表
     */
    @PreAuthorize("@ss.hasPermi('XdCustomerService:XdCustomerService:export')")
    @Log(title = "客服信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdCustomerService xdCustomerService)
    {
        List<XdCustomerService> list = xdCustomerServiceService.selectXdCustomerServiceList(xdCustomerService);
        ExcelUtil<XdCustomerService> util = new ExcelUtil<XdCustomerService>(XdCustomerService.class);
        util.exportExcel(response, list, "客服信息数据");
    }

    /**
     * 获取客服信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdCustomerService:XdCustomerService:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdCustomerServiceService.selectXdCustomerServiceById(id));
    }

    /**
     * 新增客服信息
     */
    @PreAuthorize("@ss.hasPermi('XdCustomerService:XdCustomerService:add')")
    @Log(title = "客服信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdCustomerService xdCustomerService)
    {
        return toAjax(xdCustomerServiceService.insertXdCustomerService(xdCustomerService));
    }

    /**
     * 修改客服信息
     */
    @PreAuthorize("@ss.hasPermi('XdCustomerService:XdCustomerService:edit')")
    @Log(title = "客服信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdCustomerService xdCustomerService)
    {
        return toAjax(xdCustomerServiceService.updateXdCustomerService(xdCustomerService));
    }

    /**
     * 删除客服信息
     */
    @PreAuthorize("@ss.hasPermi('XdCustomerService:XdCustomerService:remove')")
    @Log(title = "客服信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdCustomerServiceService.deleteXdCustomerServiceByIds(ids));
    }
}
