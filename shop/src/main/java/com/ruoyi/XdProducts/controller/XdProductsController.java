package com.ruoyi.XdProducts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.XdGoodSpecs.domain.XdGoodSpecs;
import com.ruoyi.XdGoodSpecs.service.IXdGoodSpecsService;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.XdProducts.domain.XdProducts;
import com.ruoyi.XdProducts.service.IXdProductsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdProducts/XdProducts")
public class XdProductsController extends BaseController
{
    @Autowired
    private IXdProductsService xdProductsService;
    @Autowired
    private IXdGoodSpecsService xdGoodSpecsService;

    /**
     * 查询商品列表
     */
    @PreAuthorize("@ss.hasPermi('XdProducts:XdProducts:list')")
    @GetMapping("/list")
    @DataScope(deptAlias = "xp", userAlias = "xp")
    public TableDataInfo list(XdProducts xdProducts)
    {
        startPage();
        List<XdProducts> list = xdProductsService.selectXdProductsList(xdProducts);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @PreAuthorize("@ss.hasPermi('XdProducts:XdProducts:export')")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdProducts xdProducts)
    {
        List<XdProducts> list = xdProductsService.selectXdProductsList(xdProducts);
        ExcelUtil<XdProducts> util = new ExcelUtil<XdProducts>(XdProducts.class);
        util.exportExcel(response, list, "商品数据");
    }

    /**
     * 获取商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdProducts:XdProducts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xdProductsService.selectXdProductsById(id));
    }

    /**
     * 新增商品
     */
    @PreAuthorize("@ss.hasPermi('XdProducts:XdProducts:add')")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdProducts xdProducts)
    {
        int size=xdProductsService.insertXdProducts(xdProducts);
        List<XdGoodSpecs> xdGoodSpecsList = (List<XdGoodSpecs>) xdProducts.getParams().get("xdGoodSpecsList");
        List<XdGoodSpecs> userAnswerDtoList= JSON.parseArray(JSON.toJSONString(xdGoodSpecsList),XdGoodSpecs.class);
        LoginUser loginUser= SecurityUtils.getLoginUser();
        for (int a=0;a<userAnswerDtoList.size();a++){
            userAnswerDtoList.get(a).setGoodId(xdProducts.getId());
            userAnswerDtoList.get(a).setDeptId(loginUser.getDeptId());
            userAnswerDtoList.get(a).setUserId(loginUser.getUserId());
            xdGoodSpecsService.insertXdGoodSpecs(userAnswerDtoList.get(a));
        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",200);
        map.put("msg","操作成功");
        return toAjax(size);
    }

    /**
     * 修改商品
     */
    @PreAuthorize("@ss.hasPermi('XdProducts:XdProducts:edit')")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdProducts xdProducts)
    {
        int size=xdProductsService.updateXdProducts(xdProducts);
        List<XdGoodSpecs> xdGoodSpecsList = (List<XdGoodSpecs>) xdProducts.getParams().get("xdGoodSpecsList");
        List<XdGoodSpecs> userAnswerDtoList= JSON.parseArray(JSON.toJSONString(xdGoodSpecsList),XdGoodSpecs.class);
        LoginUser loginUser= SecurityUtils.getLoginUser();
        for (int a=0;a<userAnswerDtoList.size();a++){
            userAnswerDtoList.get(a).setGoodId(xdProducts.getId());
            if(userAnswerDtoList.get(a).getId()==null){
                xdGoodSpecsService.insertXdGoodSpecs(userAnswerDtoList.get(a));
            }else{
                xdGoodSpecsService.updateXdGoodSpecs(userAnswerDtoList.get(a));
            }
        }
        return toAjax(size);
    }

    /**
     * 删除商品
     */
    @PreAuthorize("@ss.hasPermi('XdProducts:XdProducts:remove')")
    @Log(title = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdProductsService.deleteXdProductsByIds(ids));
    }
}
