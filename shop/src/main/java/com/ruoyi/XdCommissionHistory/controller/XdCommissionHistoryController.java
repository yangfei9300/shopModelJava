package com.ruoyi.XdCommissionHistory.controller;

import java.util.Date;
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
import com.ruoyi.XdCommissionHistory.domain.XdCommissionHistory;
import com.ruoyi.XdCommissionHistory.service.IXdCommissionHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 佣金记录Controller
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@RestController
@RequestMapping("/XdCommissionHistory/XdCommissionHistory")
public class XdCommissionHistoryController extends BaseController
{
    @Autowired
    private IXdCommissionHistoryService xdCommissionHistoryService;

    /**
     * 查询佣金记录列表
     */
    @PreAuthorize("@ss.hasPermi('XdCommissionHistory:XdCommissionHistory:list')")
    @GetMapping("/list")
    public TableDataInfo list(XdCommissionHistory xdCommissionHistory)
    {
        startPage();
        List<XdCommissionHistory> list = xdCommissionHistoryService.selectXdCommissionHistoryList(xdCommissionHistory);
        return getDataTable(list);
    }

    /**
     * 导出佣金记录列表
     */
    @PreAuthorize("@ss.hasPermi('XdCommissionHistory:XdCommissionHistory:export')")
    @Log(title = "佣金记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdCommissionHistory xdCommissionHistory)
    {
        List<XdCommissionHistory> list = xdCommissionHistoryService.selectXdCommissionHistoryList(xdCommissionHistory);
        ExcelUtil<XdCommissionHistory> util = new ExcelUtil<XdCommissionHistory>(XdCommissionHistory.class);
        util.exportExcel(response, list, "佣金记录数据");
    }

    /**
     * 获取佣金记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdCommissionHistory:XdCommissionHistory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdCommissionHistoryService.selectXdCommissionHistoryById(id));
    }

    /**
     * 新增佣金记录
     */
    @PreAuthorize("@ss.hasPermi('XdCommissionHistory:XdCommissionHistory:add')")
    @Log(title = "佣金记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdCommissionHistory xdCommissionHistory)
    {
        xdCommissionHistory.setCreateTime(new Date());
        return toAjax(xdCommissionHistoryService.insertXdCommissionHistory(xdCommissionHistory));
    }

    /**
     * 修改佣金记录
     */
    @PreAuthorize("@ss.hasPermi('XdCommissionHistory:XdCommissionHistory:edit')")
    @Log(title = "佣金记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdCommissionHistory xdCommissionHistory)
    {
        return toAjax(xdCommissionHistoryService.updateXdCommissionHistory(xdCommissionHistory));
    }

    /**
     * 删除佣金记录
     */
    @PreAuthorize("@ss.hasPermi('XdCommissionHistory:XdCommissionHistory:remove')")
    @Log(title = "佣金记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdCommissionHistoryService.deleteXdCommissionHistoryByIds(ids));
    }
}
