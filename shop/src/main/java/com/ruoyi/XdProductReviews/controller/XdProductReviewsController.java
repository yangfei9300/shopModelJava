package com.ruoyi.XdProductReviews.controller;

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
import com.ruoyi.XdProductReviews.domain.XdProductReviews;
import com.ruoyi.XdProductReviews.service.IXdProductReviewsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户评价Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdProductReviews/XdProductReviews")
public class XdProductReviewsController extends BaseController
{
    @Autowired
    private IXdProductReviewsService xdProductReviewsService;

    /**
     * 查询用户评价列表
     */
    @PreAuthorize("@ss.hasPermi('XdProductReviews:XdProductReviews:list')")
    @GetMapping("/list")
    @DataScope(deptAlias = "xpr", userAlias = "xpr")
    public TableDataInfo list(XdProductReviews xdProductReviews)
    {
        startPage();
        List<XdProductReviews> list = xdProductReviewsService.selectXdProductReviewsList(xdProductReviews);
        return getDataTable(list);
    }

    /**
     * 导出用户评价列表
     */
    @PreAuthorize("@ss.hasPermi('XdProductReviews:XdProductReviews:export')")
    @Log(title = "用户评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdProductReviews xdProductReviews)
    {
        List<XdProductReviews> list = xdProductReviewsService.selectXdProductReviewsList(xdProductReviews);
        ExcelUtil<XdProductReviews> util = new ExcelUtil<XdProductReviews>(XdProductReviews.class);
        util.exportExcel(response, list, "用户评价数据");
    }

    /**
     * 获取用户评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdProductReviews:XdProductReviews:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdProductReviewsService.selectXdProductReviewsById(id));
    }

    /**
     * 新增用户评价
     */
    @PreAuthorize("@ss.hasPermi('XdProductReviews:XdProductReviews:add')")
    @Log(title = "用户评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdProductReviews xdProductReviews)
    {
        return toAjax(xdProductReviewsService.insertXdProductReviews(xdProductReviews));
    }

    /**
     * 修改用户评价
     */
    @PreAuthorize("@ss.hasPermi('XdProductReviews:XdProductReviews:edit')")
    @Log(title = "用户评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdProductReviews xdProductReviews)
    {
        return toAjax(xdProductReviewsService.updateXdProductReviews(xdProductReviews));
    }

    /**
     * 删除用户评价
     */
    @PreAuthorize("@ss.hasPermi('XdProductReviews:XdProductReviews:remove')")
    @Log(title = "用户评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdProductReviewsService.deleteXdProductReviewsByIds(ids));
    }
}
