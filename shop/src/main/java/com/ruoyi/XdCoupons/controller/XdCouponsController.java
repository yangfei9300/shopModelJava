package com.ruoyi.XdCoupons.controller;

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
import com.ruoyi.XdCoupons.domain.XdCoupons;
import com.ruoyi.XdCoupons.service.IXdCouponsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 优惠券Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdCoupons/XdCoupons")
public class XdCouponsController extends BaseController
{
    @Autowired
    private IXdCouponsService xdCouponsService;

    /**
     * 查询优惠券列表
     */
    @PreAuthorize("@ss.hasPermi('XdCoupons:XdCoupons:list')")
    @GetMapping("/list")
    @DataScope(deptAlias = "xc", userAlias = "xc")
    public TableDataInfo list(XdCoupons xdCoupons)
    {
        startPage();
        List<XdCoupons> list = xdCouponsService.selectXdCouponsList(xdCoupons);
        return getDataTable(list);
    }

    /**
     * 导出优惠券列表
     */
    @PreAuthorize("@ss.hasPermi('XdCoupons:XdCoupons:export')")
    @Log(title = "优惠券", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdCoupons xdCoupons)
    {
        List<XdCoupons> list = xdCouponsService.selectXdCouponsList(xdCoupons);
        ExcelUtil<XdCoupons> util = new ExcelUtil<XdCoupons>(XdCoupons.class);
        util.exportExcel(response, list, "优惠券数据");
    }

    /**
     * 获取优惠券详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdCoupons:XdCoupons:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdCouponsService.selectXdCouponsById(id));
    }

    /**
     * 新增优惠券
     */
    @PreAuthorize("@ss.hasPermi('XdCoupons:XdCoupons:add')")
    @Log(title = "优惠券", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdCoupons xdCoupons)
    {
        return toAjax(xdCouponsService.insertXdCoupons(xdCoupons));
    }

    /**
     * 修改优惠券
     */
    @PreAuthorize("@ss.hasPermi('XdCoupons:XdCoupons:edit')")
    @Log(title = "优惠券", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdCoupons xdCoupons)
    {
        return toAjax(xdCouponsService.updateXdCoupons(xdCoupons));
    }

    /**
     * 删除优惠券
     */
    @PreAuthorize("@ss.hasPermi('XdCoupons:XdCoupons:remove')")
    @Log(title = "优惠券", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdCouponsService.deleteXdCouponsByIds(ids));
    }
}
