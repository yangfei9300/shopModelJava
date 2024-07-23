package com.ruoyi.XdOrderRefunds.controller;

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
import com.ruoyi.XdOrderRefunds.domain.XdOrderRefunds;
import com.ruoyi.XdOrderRefunds.service.IXdOrderRefundsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单退款Controller
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@RestController
@RequestMapping("/XdOrderRefunds/XdOrderRefunds")
public class XdOrderRefundsController extends BaseController
{
    @Autowired
    private IXdOrderRefundsService xdOrderRefundsService;

    /**
     * 查询订单退款列表
     */
    @PreAuthorize("@ss.hasPermi('XdOrderRefunds:XdOrderRefunds:list')")
    @GetMapping("/list")
    public TableDataInfo list(XdOrderRefunds xdOrderRefunds)
    {
        startPage();
        List<XdOrderRefunds> list = xdOrderRefundsService.selectXdOrderRefundsList(xdOrderRefunds);
        return getDataTable(list);
    }

    /**
     * 导出订单退款列表
     */
    @PreAuthorize("@ss.hasPermi('XdOrderRefunds:XdOrderRefunds:export')")
    @Log(title = "订单退款", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdOrderRefunds xdOrderRefunds)
    {
        List<XdOrderRefunds> list = xdOrderRefundsService.selectXdOrderRefundsList(xdOrderRefunds);
        ExcelUtil<XdOrderRefunds> util = new ExcelUtil<XdOrderRefunds>(XdOrderRefunds.class);
        util.exportExcel(response, list, "订单退款数据");
    }

    /**
     * 获取订单退款详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdOrderRefunds:XdOrderRefunds:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdOrderRefundsService.selectXdOrderRefundsById(id));
    }

    /**
     * 新增订单退款
     */
    @PreAuthorize("@ss.hasPermi('XdOrderRefunds:XdOrderRefunds:add')")
    @Log(title = "订单退款", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdOrderRefunds xdOrderRefunds)
    {
        return toAjax(xdOrderRefundsService.insertXdOrderRefunds(xdOrderRefunds));
    }

    /**
     * 修改订单退款
     */
    @PreAuthorize("@ss.hasPermi('XdOrderRefunds:XdOrderRefunds:edit')")
    @Log(title = "订单退款", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdOrderRefunds xdOrderRefunds)
    {
        return toAjax(xdOrderRefundsService.updateXdOrderRefunds(xdOrderRefunds));
    }

    /**
     * 删除订单退款
     */
    @PreAuthorize("@ss.hasPermi('XdOrderRefunds:XdOrderRefunds:remove')")
    @Log(title = "订单退款", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdOrderRefundsService.deleteXdOrderRefundsByIds(ids));
    }
}
