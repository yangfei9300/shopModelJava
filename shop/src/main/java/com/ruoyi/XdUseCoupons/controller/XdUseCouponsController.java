package com.ruoyi.XdUseCoupons.controller;

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
import com.ruoyi.XdUseCoupons.domain.XdUseCoupons;
import com.ruoyi.XdUseCoupons.service.IXdUseCouponsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 优惠券领取使用记录Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdUseCoupons/XdUseCoupons")
public class XdUseCouponsController extends BaseController
{
    @Autowired
    private IXdUseCouponsService xdUseCouponsService;

    /**
     * 查询优惠券领取使用记录列表
     */
    @PreAuthorize("@ss.hasPermi('XdUseCoupons:XdUseCoupons:list')")
    @GetMapping("/list")
    @DataScope(deptAlias = "xu", userAlias = "xu")
    public TableDataInfo list(XdUseCoupons xdUseCoupons)
    {
        startPage();
        List<XdUseCoupons> list = xdUseCouponsService.selectXdUseCouponsList(xdUseCoupons);
        return getDataTable(list);
    }

    /**
     * 导出优惠券领取使用记录列表
     */
    @PreAuthorize("@ss.hasPermi('XdUseCoupons:XdUseCoupons:export')")
    @Log(title = "优惠券领取使用记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdUseCoupons xdUseCoupons)
    {
        List<XdUseCoupons> list = xdUseCouponsService.selectXdUseCouponsList(xdUseCoupons);
        ExcelUtil<XdUseCoupons> util = new ExcelUtil<XdUseCoupons>(XdUseCoupons.class);
        util.exportExcel(response, list, "优惠券领取使用记录数据");
    }

    /**
     * 获取优惠券领取使用记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdUseCoupons:XdUseCoupons:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdUseCouponsService.selectXdUseCouponsById(id));
    }

    /**
     * 新增优惠券领取使用记录
     */
    @PreAuthorize("@ss.hasPermi('XdUseCoupons:XdUseCoupons:add')")
    @Log(title = "优惠券领取使用记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdUseCoupons xdUseCoupons)
    {
        return toAjax(xdUseCouponsService.insertXdUseCoupons(xdUseCoupons));
    }

    /**
     * 修改优惠券领取使用记录
     */
    @PreAuthorize("@ss.hasPermi('XdUseCoupons:XdUseCoupons:edit')")
    @Log(title = "优惠券领取使用记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdUseCoupons xdUseCoupons)
    {
        return toAjax(xdUseCouponsService.updateXdUseCoupons(xdUseCoupons));
    }

    /**
     * 删除优惠券领取使用记录
     */
    @PreAuthorize("@ss.hasPermi('XdUseCoupons:XdUseCoupons:remove')")
    @Log(title = "优惠券领取使用记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdUseCouponsService.deleteXdUseCouponsByIds(ids));
    }
}
