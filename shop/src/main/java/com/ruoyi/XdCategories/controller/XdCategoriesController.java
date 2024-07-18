package com.ruoyi.XdCategories.controller;

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
import com.ruoyi.XdCategories.domain.XdCategories;
import com.ruoyi.XdCategories.service.IXdCategoriesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品分类Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdCategories/XdCategories")
public class XdCategoriesController extends BaseController
{
    @Autowired
    private IXdCategoriesService xdCategoriesService;

    /**
     * 查询商品分类列表
     */
    @PreAuthorize("@ss.hasPermi('XdCategories:XdCategories:list')")
    @GetMapping("/list")
    @DataScope(deptAlias = "xc", userAlias = "xc")
    public TableDataInfo list(XdCategories xdCategories)
    {
        startPage();
        List<XdCategories> list = xdCategoriesService.selectXdCategoriesList(xdCategories);
        return getDataTable(list);
    }

    /**
     * 导出商品分类列表
     */
    @PreAuthorize("@ss.hasPermi('XdCategories:XdCategories:export')")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdCategories xdCategories)
    {
        List<XdCategories> list = xdCategoriesService.selectXdCategoriesList(xdCategories);
        ExcelUtil<XdCategories> util = new ExcelUtil<XdCategories>(XdCategories.class);
        util.exportExcel(response, list, "商品分类数据");
    }

    /**
     * 获取商品分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdCategories:XdCategories:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdCategoriesService.selectXdCategoriesById(id));
    }

    /**
     * 新增商品分类
     */
    @PreAuthorize("@ss.hasPermi('XdCategories:XdCategories:add')")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdCategories xdCategories)
    {
        return toAjax(xdCategoriesService.insertXdCategories(xdCategories));
    }

    /**
     * 修改商品分类
     */
    @PreAuthorize("@ss.hasPermi('XdCategories:XdCategories:edit')")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdCategories xdCategories)
    {
        return toAjax(xdCategoriesService.updateXdCategories(xdCategories));
    }

    /**
     * 删除商品分类
     */
    @PreAuthorize("@ss.hasPermi('XdCategories:XdCategories:remove')")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdCategoriesService.deleteXdCategoriesByIds(ids));
    }
}
