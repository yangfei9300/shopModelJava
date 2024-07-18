package com.ruoyi.XdUser.controller;

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
import com.ruoyi.XdUser.domain.XdUser;
import com.ruoyi.XdUser.service.IXdUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 微信用户Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdUser/XdUser")
public class XdUserController extends BaseController
{
    @Autowired
    private IXdUserService xdUserService;

    /**
     * 查询微信用户列表
     */
    @PreAuthorize("@ss.hasPermi('XdUser:XdUser:list')")
    @GetMapping("/list")
    @DataScope(deptAlias = "xu", userAlias = "xu")
    public TableDataInfo list(XdUser xdUser)
    {
        startPage();
        List<XdUser> list = xdUserService.selectXdUserList(xdUser);
        return getDataTable(list);
    }

    /**
     * 导出微信用户列表
     */
    @PreAuthorize("@ss.hasPermi('XdUser:XdUser:export')")
    @Log(title = "微信用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdUser xdUser)
    {
        List<XdUser> list = xdUserService.selectXdUserList(xdUser);
        ExcelUtil<XdUser> util = new ExcelUtil<XdUser>(XdUser.class);
        util.exportExcel(response, list, "微信用户数据");
    }

    /**
     * 获取微信用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdUser:XdUser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdUserService.selectXdUserById(id));
    }

    /**
     * 新增微信用户
     */
    @PreAuthorize("@ss.hasPermi('XdUser:XdUser:add')")
    @Log(title = "微信用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdUser xdUser)
    {
        return toAjax(xdUserService.insertXdUser(xdUser));
    }

    /**
     * 修改微信用户
     */
    @PreAuthorize("@ss.hasPermi('XdUser:XdUser:edit')")
    @Log(title = "微信用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdUser xdUser)
    {
        return toAjax(xdUserService.updateXdUser(xdUser));
    }

    /**
     * 删除微信用户
     */
    @PreAuthorize("@ss.hasPermi('XdUser:XdUser:remove')")
    @Log(title = "微信用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdUserService.deleteXdUserByIds(ids));
    }
}
