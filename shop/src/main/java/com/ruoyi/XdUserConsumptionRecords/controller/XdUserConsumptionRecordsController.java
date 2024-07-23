package com.ruoyi.XdUserConsumptionRecords.controller;

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
import com.ruoyi.XdUserConsumptionRecords.domain.XdUserConsumptionRecords;
import com.ruoyi.XdUserConsumptionRecords.service.IXdUserConsumptionRecordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户余额消费记录Controller
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
@RestController
@RequestMapping("/XdUserConsumptionRecords/XdUserConsumptionRecords")
public class XdUserConsumptionRecordsController extends BaseController
{
    @Autowired
    private IXdUserConsumptionRecordsService xdUserConsumptionRecordsService;

    /**
     * 查询用户余额消费记录列表
     */
    @PreAuthorize("@ss.hasPermi('XdUserConsumptionRecords:XdUserConsumptionRecords:list')")
    @GetMapping("/list")
    public TableDataInfo list(XdUserConsumptionRecords xdUserConsumptionRecords)
    {
        startPage();
        List<XdUserConsumptionRecords> list = xdUserConsumptionRecordsService.selectXdUserConsumptionRecordsList(xdUserConsumptionRecords);
        return getDataTable(list);
    }

    /**
     * 导出用户余额消费记录列表
     */
    @PreAuthorize("@ss.hasPermi('XdUserConsumptionRecords:XdUserConsumptionRecords:export')")
    @Log(title = "用户余额消费记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdUserConsumptionRecords xdUserConsumptionRecords)
    {
        List<XdUserConsumptionRecords> list = xdUserConsumptionRecordsService.selectXdUserConsumptionRecordsList(xdUserConsumptionRecords);
        ExcelUtil<XdUserConsumptionRecords> util = new ExcelUtil<XdUserConsumptionRecords>(XdUserConsumptionRecords.class);
        util.exportExcel(response, list, "用户余额消费记录数据");
    }

    /**
     * 获取用户余额消费记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdUserConsumptionRecords:XdUserConsumptionRecords:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdUserConsumptionRecordsService.selectXdUserConsumptionRecordsById(id));
    }

    /**
     * 新增用户余额消费记录
     */
    @PreAuthorize("@ss.hasPermi('XdUserConsumptionRecords:XdUserConsumptionRecords:add')")
    @Log(title = "用户余额消费记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdUserConsumptionRecords xdUserConsumptionRecords)
    {
        return toAjax(xdUserConsumptionRecordsService.insertXdUserConsumptionRecords(xdUserConsumptionRecords));
    }

    /**
     * 修改用户余额消费记录
     */
    @PreAuthorize("@ss.hasPermi('XdUserConsumptionRecords:XdUserConsumptionRecords:edit')")
    @Log(title = "用户余额消费记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdUserConsumptionRecords xdUserConsumptionRecords)
    {
        return toAjax(xdUserConsumptionRecordsService.updateXdUserConsumptionRecords(xdUserConsumptionRecords));
    }

    /**
     * 删除用户余额消费记录
     */
    @PreAuthorize("@ss.hasPermi('XdUserConsumptionRecords:XdUserConsumptionRecords:remove')")
    @Log(title = "用户余额消费记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdUserConsumptionRecordsService.deleteXdUserConsumptionRecordsByIds(ids));
    }
}
