package com.ruoyi.XdCarts.controller;

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
import com.ruoyi.XdCarts.domain.XdCarts;
import com.ruoyi.XdCarts.service.IXdCartsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 购物车Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdCarts/XdCarts")
public class XdCartsController extends BaseController
{
    @Autowired
    private IXdCartsService xdCartsService;

    /**
     * 查询购物车列表
     */
    @PreAuthorize("@ss.hasPermi('XdCarts:XdCarts:list')")
    @GetMapping("/list")
    @DataScope(deptAlias = "xc", userAlias = "xc")
    public TableDataInfo list(XdCarts xdCarts)
    {
        startPage();
        List<XdCarts> list = xdCartsService.selectXdCartsList(xdCarts);
        return getDataTable(list);
    }

    /**
     * 导出购物车列表
     */
    @PreAuthorize("@ss.hasPermi('XdCarts:XdCarts:export')")
    @Log(title = "购物车", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdCarts xdCarts)
    {
        List<XdCarts> list = xdCartsService.selectXdCartsList(xdCarts);
        ExcelUtil<XdCarts> util = new ExcelUtil<XdCarts>(XdCarts.class);
        util.exportExcel(response, list, "购物车数据");
    }

    /**
     * 获取购物车详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdCarts:XdCarts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdCartsService.selectXdCartsById(id));
    }

    /**
     * 新增购物车
     */
    @PreAuthorize("@ss.hasPermi('XdCarts:XdCarts:add')")
    @Log(title = "购物车", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdCarts xdCarts)
    {
        return toAjax(xdCartsService.insertXdCarts(xdCarts));
    }

    /**
     * 修改购物车
     */
    @PreAuthorize("@ss.hasPermi('XdCarts:XdCarts:edit')")
    @Log(title = "购物车", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdCarts xdCarts)
    {
        return toAjax(xdCartsService.updateXdCarts(xdCarts));
    }

    /**
     * 删除购物车
     */
    @PreAuthorize("@ss.hasPermi('XdCarts:XdCarts:remove')")
    @Log(title = "购物车", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdCartsService.deleteXdCartsByIds(ids));
    }
}
