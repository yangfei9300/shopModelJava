package com.ruoyi.XdUserFeedback.controller;

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
import com.ruoyi.XdUserFeedback.domain.XdUserFeedback;
import com.ruoyi.XdUserFeedback.service.IXdUserFeedbackService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 意见反馈Controller
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@RestController
@RequestMapping("/XdUserFeedback/XdUserFeedback")
public class XdUserFeedbackController extends BaseController
{
    @Autowired
    private IXdUserFeedbackService xdUserFeedbackService;

    /**
     * 查询意见反馈列表
     */
    @PreAuthorize("@ss.hasPermi('XdUserFeedback:XdUserFeedback:list')")
    @GetMapping("/list")
    public TableDataInfo list(XdUserFeedback xdUserFeedback)
    {
        startPage();
        List<XdUserFeedback> list = xdUserFeedbackService.selectXdUserFeedbackList(xdUserFeedback);
        return getDataTable(list);
    }

    /**
     * 导出意见反馈列表
     */
    @PreAuthorize("@ss.hasPermi('XdUserFeedback:XdUserFeedback:export')")
    @Log(title = "意见反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdUserFeedback xdUserFeedback)
    {
        List<XdUserFeedback> list = xdUserFeedbackService.selectXdUserFeedbackList(xdUserFeedback);
        ExcelUtil<XdUserFeedback> util = new ExcelUtil<XdUserFeedback>(XdUserFeedback.class);
        util.exportExcel(response, list, "意见反馈数据");
    }

    /**
     * 获取意见反馈详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdUserFeedback:XdUserFeedback:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdUserFeedbackService.selectXdUserFeedbackById(id));
    }

    /**
     * 新增意见反馈
     */
    @PreAuthorize("@ss.hasPermi('XdUserFeedback:XdUserFeedback:add')")
    @Log(title = "意见反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdUserFeedback xdUserFeedback)
    {
        return toAjax(xdUserFeedbackService.insertXdUserFeedback(xdUserFeedback));
    }

    /**
     * 修改意见反馈
     */
    @PreAuthorize("@ss.hasPermi('XdUserFeedback:XdUserFeedback:edit')")
    @Log(title = "意见反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdUserFeedback xdUserFeedback)
    {
        return toAjax(xdUserFeedbackService.updateXdUserFeedback(xdUserFeedback));
    }

    /**
     * 删除意见反馈
     */
    @PreAuthorize("@ss.hasPermi('XdUserFeedback:XdUserFeedback:remove')")
    @Log(title = "意见反馈", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdUserFeedbackService.deleteXdUserFeedbackByIds(ids));
    }
}
