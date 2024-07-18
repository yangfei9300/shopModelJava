package com.ruoyi.XdOrders.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.JUtils;
import com.ruoyi.XdOrdersInfo.domain.XdOrdersInfo;
import com.ruoyi.XdOrdersInfo.service.IXdOrdersInfoService;
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
import com.ruoyi.XdOrders.domain.XdOrders;
import com.ruoyi.XdOrders.service.IXdOrdersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/XdOrders/XdOrders")
public class XdOrdersController extends BaseController
{
    @Autowired
    private IXdOrdersService xdOrdersService;
    @Autowired
    private IXdOrdersInfoService xdOrdersInfoService;

    //    查询统计数据
    @PostMapping("/getHomeSums")
    public Map<String, Object> addOrder(Map<String,Object> map1) {
        Map<String, Object> map = new HashMap<String, Object>();
        LoginUser loginUser= SecurityUtils.getLoginUser();
        map1.put("deptId",loginUser.getDeptId());
        map1=  xdOrdersService.getHomeSum1(map1);
        map.put("code",200);
        map.put("msg","操作成功");
        map.put("data",map1);
        return map;
    }
    //    查询销售占比
    @PostMapping("/getGoodSaleProportion")
    public Map<String, Object> getGoodSaleProportion(Map<String,Object> map1) {
        Map<String, Object> map = new HashMap<String, Object>();
        LoginUser loginUser= SecurityUtils.getLoginUser();
        map1.put("deptId",loginUser.getDeptId());
        List<Map<String,Object>> listStr=  xdOrdersService.getGoodSaleProportion(map1);
        map.put("code",200);
        map.put("msg","操作成功");
        map.put("data",listStr);
        return map;
    }
//    查询一月的商品销售额
    @PostMapping("/getMonthSales")
    public Map<String, Object> getMonthSales(Map<String,Object> map1) {
        Map<String, Object> map = new HashMap<String, Object>();
        LoginUser loginUser= SecurityUtils.getLoginUser();
        map1.put("deptId",loginUser.getDeptId());
        List<Map<String,Object>>  listMap=xdOrdersService.getMonthSales(map1);
//        获取当前月的日期
        List<Map<String,String>> listMonth= JUtils.getriqi();
        for(int a=0;a<listMonth.size();a++){
            for(int b=0;b<listMap.size();b++){
                if(listMonth.get(a).get("date").equals(listMap.get(b).get("sale_date").toString())){
                    listMonth.get(a).put("money",listMap.get(b).get("total_sales").toString());
                }
            }
        }
        for(int a=0;a<listMonth.size();a++){
            if(listMonth.get(a).get("money")==null){
                listMonth.get(a).put("money","0.00");
            }
        }
        map.put("code",200);
        map.put("msg","操作成功");
        map.put("data",listMonth);
        return map;
    }

//    查询一周的销售额
    @PostMapping("/getWeekSales")
    public Map<String, Object> getWeekSales(Map<String,Object> map1) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String,String>> listMWeek= JUtils.getWeekStr();
        LoginUser loginUser= SecurityUtils.getLoginUser();
        map1.put("deptId",loginUser.getDeptId());
        map1.put("start",listMWeek.get(0).get("date"));
        map1.put("end",listMWeek.get(listMWeek.size()-1).get("date"));
        List<Map<String,Object>>  listMap=xdOrdersService.getWeekSales(map1);
//        获取当前月的日期

        for(int a=0;a<listMWeek.size();a++){
            for(int b=0;b<listMap.size();b++){
                if(listMWeek.get(a).get("date").equals(listMap.get(b).get("sale_date").toString())){
                    listMWeek.get(a).put("money",listMap.get(b).get("total_sales").toString());
                }
            }
        }
        for(int a=0;a<listMWeek.size();a++){
            if(listMWeek.get(a).get("money")==null){
                listMWeek.get(a).put("money","0.00");
            }
        }
        map.put("code",200);
        map.put("msg","操作成功");
        map.put("data",listMWeek);

        return map;
    }



    /**
     * 查询订单列表
     */
    @PreAuthorize("@ss.hasPermi('XdOrders:XdOrders:list')")
    @GetMapping("/list")
    @DataScope(deptAlias = "xo", userAlias = "xo")
    public TableDataInfo list(XdOrders xdOrders)
    {
        startPage();
        List<XdOrders> list = xdOrdersService.selectXdOrdersList(xdOrders);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @PreAuthorize("@ss.hasPermi('XdOrders:XdOrders:export')")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XdOrders xdOrders)
    {
        List<XdOrders> list = xdOrdersService.selectXdOrdersList(xdOrders);
        ExcelUtil<XdOrders> util = new ExcelUtil<XdOrders>(XdOrders.class);
        util.exportExcel(response, list, "订单数据");
    }

    /**
     * 获取订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('XdOrders:XdOrders:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
//        获取订单详情
        XdOrders xdOrders=xdOrdersService.selectXdOrdersById(id);
//        订单商品
        XdOrdersInfo xdOrdersInfo=new XdOrdersInfo();
        xdOrdersInfo.setOrderId(id);
        List<XdOrdersInfo> xdOrdersInfoList=xdOrdersInfoService.selectXdOrdersInfoList(xdOrdersInfo);
        xdOrders.getParams().put("goods",xdOrdersInfoList);
        return success(xdOrders);
    }

    /**
     * 新增订单
     */
    @PreAuthorize("@ss.hasPermi('XdOrders:XdOrders:add')")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XdOrders xdOrders)
    {
        return toAjax(xdOrdersService.insertXdOrders(xdOrders));
    }

    /**
     * 修改订单
     */
    @PreAuthorize("@ss.hasPermi('XdOrders:XdOrders:edit')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XdOrders xdOrders)
    {
        return toAjax(xdOrdersService.updateXdOrders(xdOrders));
    }

    @PostMapping("/sendGoods")
    public Map<String,Object> sendGoods(@RequestBody XdOrders xdOrders)
    {
        Map<String,Object> map=new HashMap<>();
        if(xdOrders.getId()==null||xdOrders.getLogisticsName()==null||xdOrders.getLogisticsCode()==null){
            map.put("code",201);
            map.put("msg","信息不足");
            return map;
        }
        xdOrders.setStatus(3L);
        int count=xdOrdersService.updateXdOrders(xdOrders);
        return toAjax(count);
    }




    /**
     * 删除订单
     */
    @PreAuthorize("@ss.hasPermi('XdOrders:XdOrders:remove')")
    @Log(title = "订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xdOrdersService.deleteXdOrdersByIds(ids));
    }
}
