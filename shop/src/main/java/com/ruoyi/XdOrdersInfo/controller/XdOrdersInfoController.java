package com.ruoyi.XdOrdersInfo.controller;

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
import com.ruoyi.XdOrdersInfo.domain.XdOrdersInfo;
import com.ruoyi.XdOrdersInfo.service.IXdOrdersInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单商品详情Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdOrdersInfo/XdOrdersInfo")
public class XdOrdersInfoController extends BaseController
{
    @Autowired
    private IXdOrdersInfoService xdOrdersInfoService;

    /**
     * 查询订单商品详情列表
     */
    @PreAuthorize("@ss.hasPermi('XdOrdersInfo:XdOrdersInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(XdOrdersInfo xdOrdersInfo)
    {
        startPage();
        List<XdOrdersInfo> list = xdOrdersInfoService.selectXdOrdersInfoList(xdOrdersInfo);
        return getDataTable(list);
    }

    /**
     * 导出订单商品详情列表
     */
    @PreAuthorize("@ss.hasPermi('XdOrdersInfo:XdOrdersInfo:export')")
    @Log(title = "订单商品详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdOrdersInfo xdOrdersInfo)
    {
        List<XdOrdersInfo> list = xdOrdersInfoService.selectXdOrdersInfoList(xdOrdersInfo);
        ExcelUtil<XdOrdersInfo> util = new ExcelUtil<XdOrdersInfo>(XdOrdersInfo.class);
        util.exportExcel(response, list, "订单商品详情数据");
    }

    /**
     * 获取订单商品详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdOrdersInfo:XdOrdersInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdOrdersInfoService.selectXdOrdersInfoById(id));
    }

    /**
     * 新增订单商品详情
     */
    @PreAuthorize("@ss.hasPermi('XdOrdersInfo:XdOrdersInfo:add')")
    @Log(title = "订单商品详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdOrdersInfo xdOrdersInfo)
    {
        return toAjax(xdOrdersInfoService.insertXdOrdersInfo(xdOrdersInfo));
    }

    /**
     * 修改订单商品详情
     */
    @PreAuthorize("@ss.hasPermi('XdOrdersInfo:XdOrdersInfo:edit')")
    @Log(title = "订单商品详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdOrdersInfo xdOrdersInfo)
    {
        return toAjax(xdOrdersInfoService.updateXdOrdersInfo(xdOrdersInfo));
    }

    /**
     * 删除订单商品详情
     */
    @PreAuthorize("@ss.hasPermi('XdOrdersInfo:XdOrdersInfo:remove')")
    @Log(title = "订单商品详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdOrdersInfoService.deleteXdOrdersInfoByIds(ids));
    }
}
