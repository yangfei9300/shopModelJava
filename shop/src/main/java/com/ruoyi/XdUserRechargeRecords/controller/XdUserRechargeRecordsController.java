package com.ruoyi.XdUserRechargeRecords.controller;

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
import com.ruoyi.XdUserRechargeRecords.domain.XdUserRechargeRecords;
import com.ruoyi.XdUserRechargeRecords.service.IXdUserRechargeRecordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户充值记录Controller
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
@RestController
@RequestMapping("/XdUserRechargeRecords/XdUserRechargeRecords")
public class XdUserRechargeRecordsController extends BaseController
{
    @Autowired
    private IXdUserRechargeRecordsService xdUserRechargeRecordsService;

    /**
     * 查询用户充值记录列表
     */
    @PreAuthorize("@ss.hasPermi('XdUserRechargeRecords:XdUserRechargeRecords:list')")
    @GetMapping("/list")
    public TableDataInfo list(XdUserRechargeRecords xdUserRechargeRecords)
    {
        startPage();
        List<XdUserRechargeRecords> list = xdUserRechargeRecordsService.selectXdUserRechargeRecordsList(xdUserRechargeRecords);
        return getDataTable(list);
    }

    /**
     * 导出用户充值记录列表
     */
    @PreAuthorize("@ss.hasPermi('XdUserRechargeRecords:XdUserRechargeRecords:export')")
    @Log(title = "用户充值记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdUserRechargeRecords xdUserRechargeRecords)
    {
        List<XdUserRechargeRecords> list = xdUserRechargeRecordsService.selectXdUserRechargeRecordsList(xdUserRechargeRecords);
        ExcelUtil<XdUserRechargeRecords> util = new ExcelUtil<XdUserRechargeRecords>(XdUserRechargeRecords.class);
        util.exportExcel(response, list, "用户充值记录数据");
    }

    /**
     * 获取用户充值记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdUserRechargeRecords:XdUserRechargeRecords:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdUserRechargeRecordsService.selectXdUserRechargeRecordsById(id));
    }

    /**
     * 新增用户充值记录
     */
    @PreAuthorize("@ss.hasPermi('XdUserRechargeRecords:XdUserRechargeRecords:add')")
    @Log(title = "用户充值记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdUserRechargeRecords xdUserRechargeRecords)
    {
        return toAjax(xdUserRechargeRecordsService.insertXdUserRechargeRecords(xdUserRechargeRecords));
    }

    /**
     * 修改用户充值记录
     */
    @PreAuthorize("@ss.hasPermi('XdUserRechargeRecords:XdUserRechargeRecords:edit')")
    @Log(title = "用户充值记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdUserRechargeRecords xdUserRechargeRecords)
    {
        return toAjax(xdUserRechargeRecordsService.updateXdUserRechargeRecords(xdUserRechargeRecords));
    }

    /**
     * 删除用户充值记录
     */
    @PreAuthorize("@ss.hasPermi('XdUserRechargeRecords:XdUserRechargeRecords:remove')")
    @Log(title = "用户充值记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdUserRechargeRecordsService.deleteXdUserRechargeRecordsByIds(ids));
    }
}
