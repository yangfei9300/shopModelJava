package com.ruoyi.XdGoodSpecs.controller;

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
import com.ruoyi.XdGoodSpecs.domain.XdGoodSpecs;
import com.ruoyi.XdGoodSpecs.service.IXdGoodSpecsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 规格管理Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdGoodSpecs/XdGoodSpecs")
public class XdGoodSpecsController extends BaseController
{
    @Autowired
    private IXdGoodSpecsService xdGoodSpecsService;

    /**
     * 查询规格管理列表
     */
    @PreAuthorize("@ss.hasPermi('XdGoodSpecs:XdGoodSpecs:list')")
    @GetMapping("/list")
    public TableDataInfo list(XdGoodSpecs xdGoodSpecs)
    {
        startPage();
        List<XdGoodSpecs> list = xdGoodSpecsService.selectXdGoodSpecsList(xdGoodSpecs);
        return getDataTable(list);
    }

    /**
     * 导出规格管理列表
     */
    @PreAuthorize("@ss.hasPermi('XdGoodSpecs:XdGoodSpecs:export')")
    @Log(title = "规格管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdGoodSpecs xdGoodSpecs)
    {
        List<XdGoodSpecs> list = xdGoodSpecsService.selectXdGoodSpecsList(xdGoodSpecs);
        ExcelUtil<XdGoodSpecs> util = new ExcelUtil<XdGoodSpecs>(XdGoodSpecs.class);
        util.exportExcel(response, list, "规格管理数据");
    }

    /**
     * 获取规格管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdGoodSpecs:XdGoodSpecs:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdGoodSpecsService.selectXdGoodSpecsById(id));
    }

    /**
     * 新增规格管理
     */
    @PreAuthorize("@ss.hasPermi('XdGoodSpecs:XdGoodSpecs:add')")
    @Log(title = "规格管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdGoodSpecs xdGoodSpecs)
    {
        return toAjax(xdGoodSpecsService.insertXdGoodSpecs(xdGoodSpecs));
    }

    /**
     * 修改规格管理
     */
    @PreAuthorize("@ss.hasPermi('XdGoodSpecs:XdGoodSpecs:edit')")
    @Log(title = "规格管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdGoodSpecs xdGoodSpecs)
    {
        return toAjax(xdGoodSpecsService.updateXdGoodSpecs(xdGoodSpecs));
    }

    /**
     * 删除规格管理
     */
    @PreAuthorize("@ss.hasPermi('XdGoodSpecs:XdGoodSpecs:remove')")
    @Log(title = "规格管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdGoodSpecsService.deleteXdGoodSpecsByIds(ids));
    }
}
