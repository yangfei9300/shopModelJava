package com.ruoyi.XdBanners.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
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
import com.ruoyi.XdBanners.domain.XdBanners;
import com.ruoyi.XdBanners.service.IXdBannersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 轮播图Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdBanners/XdBanners")
public class XdBannersController extends BaseController
{
    @Autowired
    private IXdBannersService xdBannersService;

    /**
     * 查询轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('XdBanners:XdBanners:list')")
    @GetMapping("/list")
    @DataScope(deptAlias = "xb", userAlias = "xb")
    public TableDataInfo list(XdBanners xdBanners)
    {
        startPage();
        List<XdBanners> list = xdBannersService.selectXdBannersList(xdBanners);
        return getDataTable(list);
    }

    /**
     * 导出轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('XdBanners:XdBanners:export')")
    @Log(title = "轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdBanners xdBanners)
    {
        List<XdBanners> list = xdBannersService.selectXdBannersList(xdBanners);
        ExcelUtil<XdBanners> util = new ExcelUtil<XdBanners>(XdBanners.class);
        util.exportExcel(response, list, "轮播图数据");
    }

    /**
     * 获取轮播图详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdBanners:XdBanners:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdBannersService.selectXdBannersById(id));
    }

    /**
     * 新增轮播图
     */
    @PreAuthorize("@ss.hasPermi('XdBanners:XdBanners:add')")
    @Log(title = "轮播图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdBanners xdBanners)
    {

        return toAjax(xdBannersService.insertXdBanners(xdBanners));
    }

    /**
     * 修改轮播图
     */
    @PreAuthorize("@ss.hasPermi('XdBanners:XdBanners:edit')")
    @Log(title = "轮播图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdBanners xdBanners)
    {
        return toAjax(xdBannersService.updateXdBanners(xdBanners));
    }

    /**
     * 删除轮播图
     */
    @PreAuthorize("@ss.hasPermi('XdBanners:XdBanners:remove')")
    @Log(title = "轮播图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdBannersService.deleteXdBannersByIds(ids));
    }
}
