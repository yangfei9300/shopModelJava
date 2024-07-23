package com.ruoyi.XdShopInfo.controller;

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
import com.ruoyi.XdShopInfo.domain.XdShopInfo;
import com.ruoyi.XdShopInfo.service.IXdShopInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商城信息Controller
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
@RestController
@RequestMapping("/XdShopInfo/XdShopInfo")
public class XdShopInfoController extends BaseController
{
    @Autowired
    private IXdShopInfoService xdShopInfoService;

    /**
     * 查询商城信息列表
     */
    @PreAuthorize("@ss.hasPermi('XdShopInfo:XdShopInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(XdShopInfo xdShopInfo)
    {
        startPage();
        List<XdShopInfo> list = xdShopInfoService.selectXdShopInfoList(xdShopInfo);
        return getDataTable(list);
    }

    /**
     * 导出商城信息列表
     */
    @PreAuthorize("@ss.hasPermi('XdShopInfo:XdShopInfo:export')")
    @Log(title = "商城信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdShopInfo xdShopInfo)
    {
        List<XdShopInfo> list = xdShopInfoService.selectXdShopInfoList(xdShopInfo);
        ExcelUtil<XdShopInfo> util = new ExcelUtil<XdShopInfo>(XdShopInfo.class);
        util.exportExcel(response, list, "商城信息数据");
    }

    /**
     * 获取商城信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdShopInfo:XdShopInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdShopInfoService.selectXdShopInfoById(id));
    }

    /**
     * 新增商城信息
     */
    @PreAuthorize("@ss.hasPermi('XdShopInfo:XdShopInfo:add')")
    @Log(title = "商城信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdShopInfo xdShopInfo)
    {
        return toAjax(xdShopInfoService.insertXdShopInfo(xdShopInfo));
    }

    /**
     * 修改商城信息
     */
    @PreAuthorize("@ss.hasPermi('XdShopInfo:XdShopInfo:edit')")
    @Log(title = "商城信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdShopInfo xdShopInfo)
    {
        return toAjax(xdShopInfoService.updateXdShopInfo(xdShopInfo));
    }

    /**
     * 删除商城信息
     */
    @PreAuthorize("@ss.hasPermi('XdShopInfo:XdShopInfo:remove')")
    @Log(title = "商城信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdShopInfoService.deleteXdShopInfoByIds(ids));
    }
}
