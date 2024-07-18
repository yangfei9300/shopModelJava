package com.ruoyi.XdIntegralRecord.controller;

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
import com.ruoyi.XdIntegralRecord.domain.XdIntegralRecord;
import com.ruoyi.XdIntegralRecord.service.IXdIntegralRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 积分记录Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdIntegralRecord/XdIntegralRecord")
public class XdIntegralRecordController extends BaseController
{
    @Autowired
    private IXdIntegralRecordService xdIntegralRecordService;

    /**
     * 查询积分记录列表
     */
    @PreAuthorize("@ss.hasPermi('XdIntegralRecord:XdIntegralRecord:list')")
    @GetMapping("/list")
    @DataScope(deptAlias = "xi", userAlias = "xi")
    public TableDataInfo list(XdIntegralRecord xdIntegralRecord)
    {
        startPage();
        List<XdIntegralRecord> list = xdIntegralRecordService.selectXdIntegralRecordList(xdIntegralRecord);
        return getDataTable(list);
    }

    /**
     * 导出积分记录列表
     */
    @PreAuthorize("@ss.hasPermi('XdIntegralRecord:XdIntegralRecord:export')")
    @Log(title = "积分记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdIntegralRecord xdIntegralRecord)
    {
        List<XdIntegralRecord> list = xdIntegralRecordService.selectXdIntegralRecordList(xdIntegralRecord);
        ExcelUtil<XdIntegralRecord> util = new ExcelUtil<XdIntegralRecord>(XdIntegralRecord.class);
        util.exportExcel(response, list, "积分记录数据");
    }

    /**
     * 获取积分记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdIntegralRecord:XdIntegralRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdIntegralRecordService.selectXdIntegralRecordById(id));
    }

    /**
     * 新增积分记录
     */
    @PreAuthorize("@ss.hasPermi('XdIntegralRecord:XdIntegralRecord:add')")
    @Log(title = "积分记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdIntegralRecord xdIntegralRecord)
    {
        return toAjax(xdIntegralRecordService.insertXdIntegralRecord(xdIntegralRecord));
    }

    /**
     * 修改积分记录
     */
    @PreAuthorize("@ss.hasPermi('XdIntegralRecord:XdIntegralRecord:edit')")
    @Log(title = "积分记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdIntegralRecord xdIntegralRecord)
    {
        return toAjax(xdIntegralRecordService.updateXdIntegralRecord(xdIntegralRecord));
    }

    /**
     * 删除积分记录
     */
    @PreAuthorize("@ss.hasPermi('XdIntegralRecord:XdIntegralRecord:remove')")
    @Log(title = "积分记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdIntegralRecordService.deleteXdIntegralRecordByIds(ids));
    }
}
