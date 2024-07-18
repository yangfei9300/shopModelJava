package com.ruoyi.web.controller.api;

import com.ruoyi.XdBanners.domain.XdBanners;
import com.ruoyi.XdBanners.service.IXdBannersService;
import com.ruoyi.XdCarts.domain.XdCarts;
import com.ruoyi.XdCarts.service.IXdCartsService;
import com.ruoyi.XdCategories.domain.XdCategories;
import com.ruoyi.XdCategories.service.IXdCategoriesService;
import com.ruoyi.XdCoupons.domain.XdCoupons;
import com.ruoyi.XdCoupons.service.IXdCouponsService;
import com.ruoyi.XdGoodSpecs.domain.XdGoodSpecs;
import com.ruoyi.XdGoodSpecs.service.IXdGoodSpecsService;
import com.ruoyi.XdProducts.domain.XdProducts;
import com.ruoyi.XdProducts.service.IXdProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/shop")
public class shopApi {

    @Autowired
    private IXdCategoriesService xdCategoriesService;
    @Autowired
    private IXdBannersService xdBannersService;
    @Autowired
    private IXdProductsService xdProductsService;
    @Autowired
    private IXdGoodSpecsService xdGoodSpecsService;
    @Autowired
    private IXdCartsService xdCartsService;
    @Autowired
    private IXdCouponsService xdCouponsService;

    //   获取商品分类
    @PostMapping("/getGoodTypes")
    public Map<String,Object> getGoodTypes(@RequestBody XdCategories xdCategories){
        Map<String,Object> map=new HashMap<String, Object>();
        xdCategories.setStatus(1L);
        List<XdCategories> xdCategoriesList =xdCategoriesService.selectXdCategoriesList(xdCategories);
        map.put("code",200);
        map.put("data",xdCategoriesList);
        map.put("msg","操作成功");
        return  map;
    }
    //    获取轮播图
    @PostMapping("/getBanners")
    public Map<String,Object> getBanners(@RequestBody XdBanners xdBanners){
        Map<String,Object> map=new HashMap<String, Object>();
        xdBanners.setStatus(1L);
        List<XdBanners> xdBannersList =xdBannersService.selectXdBannersList(xdBanners);
        map.put("code",200);
        map.put("data",xdBannersList);
        map.put("msg","操作成功");
        return  map;
    }
//    获取商品列表
    @PostMapping("/getGoodList")
    public Map<String,Object> getGoodList(@RequestBody XdProducts xdProducts){
        Map<String,Object> map=new HashMap<String, Object>();
        xdProducts.setStatus(1L);
        List<XdProducts> xdProductsList =xdProductsService.selectXdProductsList(xdProducts);
        map.put("code",200);
        map.put("data",xdProductsList);
        map.put("msg","操作成功");
        return  map;
    }
    //    获取商品详情
    @PostMapping("/getGoodInfo")
    public Map<String,Object> getGoodInfo(@RequestBody XdProducts xdProducts){
        Map<String,Object> map=new HashMap<String, Object>();
        xdProducts.setStatus(1L);
        XdProducts xdProductsInfo =xdProductsService.selectXdProductsById(xdProducts.getId());
        //获取规格列表
        XdGoodSpecs xdGoodSpecs=new XdGoodSpecs();
        xdGoodSpecs.setStatus(1L);
        xdGoodSpecs.setGoodId(xdProductsInfo.getId());
        List<XdGoodSpecs> xdGoodSpecsList= xdGoodSpecsService.selectXdGoodSpecsList(xdGoodSpecs);
//        获取购物车
        if(xdProducts.getParams().get("uId")!=null){
            Integer userId= (Integer) xdProducts.getParams().get("uId");
            Long longVal = userId.longValue();
            XdCarts xdCarts=new XdCarts();
            xdCarts.setProductId(xdProducts.getId());
            xdCarts.setuId(longVal);
            List<XdCarts> xdCartsLiist=xdCartsService.selectXdCartsList(xdCarts);
            for(int a=0;a<xdGoodSpecsList.size();a++){
                XdGoodSpecs xgs=xdGoodSpecsList.get(a);
                xdGoodSpecsList.get(a).getParams().put("count",0);
                for(int b=0;b<xdCartsLiist.size();b++){
                    XdCarts xdCarts1=xdCartsLiist.get(b);
                    if(xgs.getId()==xdCarts1.getSpecsId()){
                        xdGoodSpecsList.get(a).getParams().put("count",xdCarts1.getQuantity());
                    }
                }
            }
        }
        xdProductsInfo.getParams().put("spaces",xdGoodSpecsList);
        map.put("code",200);
        map.put("data",xdProductsInfo);
        map.put("msg","操作成功");

        return  map;
    }

//    获取优惠券列表
    @PostMapping("/getcouponList")
    public Map<String, Object> getcouponList(@RequestBody XdCoupons xdCoupons) {
        Map<String, Object> map = new HashMap<String, Object>();

        xdCoupons.setStatus(1L);
        List<XdCoupons> xdCouponsList= xdCouponsService.selectXdCouponsList(xdCoupons);
        map.put("msg", "操作成功");
        map.put("code", 200);
        map.put("data", xdCouponsList);
        return map;
    }

}
