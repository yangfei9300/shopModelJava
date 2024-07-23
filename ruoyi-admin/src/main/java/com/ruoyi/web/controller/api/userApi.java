package com.ruoyi.web.controller.api;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.XdAddress.domain.XdAddress;
import com.ruoyi.XdAddress.service.IXdAddressService;
import com.ruoyi.XdCarts.domain.XdCarts;
import com.ruoyi.XdCarts.service.IXdCartsService;
import com.ruoyi.XdCategories.domain.XdCategories;
import com.ruoyi.XdCommissionHistory.domain.XdCommissionHistory;
import com.ruoyi.XdCommissionHistory.service.IXdCommissionHistoryService;
import com.ruoyi.XdCoupons.domain.XdCoupons;
import com.ruoyi.XdCoupons.service.IXdCouponsService;
import com.ruoyi.XdGoodSpecs.domain.XdGoodSpecs;
import com.ruoyi.XdGoodSpecs.service.IXdGoodSpecsService;
import com.ruoyi.XdIntegralRecord.domain.XdIntegralRecord;
import com.ruoyi.XdIntegralRecord.service.IXdIntegralRecordService;
import com.ruoyi.XdOrderRefunds.domain.XdOrderRefunds;
import com.ruoyi.XdOrderRefunds.service.IXdOrderRefundsService;
import com.ruoyi.XdOrders.domain.XdOrders;
import com.ruoyi.XdOrders.service.IXdOrdersService;
import com.ruoyi.XdOrdersInfo.domain.XdOrdersInfo;
import com.ruoyi.XdOrdersInfo.service.IXdOrdersInfoService;
import com.ruoyi.XdUseCoupons.domain.XdUseCoupons;
import com.ruoyi.XdUseCoupons.service.IXdUseCouponsService;
import com.ruoyi.XdUser.domain.XdUser;
import com.ruoyi.XdUser.service.IXdUserService;
import com.ruoyi.XdUserConsumptionRecords.domain.XdUserConsumptionRecords;
import com.ruoyi.XdUserConsumptionRecords.service.IXdUserConsumptionRecordsService;
import com.ruoyi.XdUserRechargeRecords.domain.XdUserRechargeRecords;
import com.ruoyi.XdUserRechargeRecords.service.IXdUserRechargeRecordsService;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.ServerConfig;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

@RestController
@RequestMapping("/api/user")
public class userApi {

    @Autowired
    private IXdUserService xdUserService;
    @Autowired
    private IXdAddressService xdAddressService;
    @Autowired
    private IXdCartsService xdCartsService;
    @Autowired
    private IXdCouponsService xdCouponsService;
    @Autowired
    private IXdUseCouponsService xdUseCouponsService;
    @Autowired
    private IXdOrdersService xdOrdersService;
    @Autowired
    private IXdOrdersInfoService xdOrdersInfoService;
    @Autowired
    private IXdGoodSpecsService xdGoodSpecsService;
    @Autowired
    private IXdIntegralRecordService xdIntegralRecordService;
    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    private IXdOrderRefundsService xdOrderRefundsService;
    @Autowired
    private IXdCommissionHistoryService xdCommissionHistoryService;
    @Autowired
    private IXdUserRechargeRecordsService xdUserRechargeRecordsService;
    @Autowired
    private IXdUserConsumptionRecordsService xdUserConsumptionRecordsService;



    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();


    //获取个人（通过openid）
    @PostMapping("/getUserInfo")
    public Map<String, Object> getGoodTypes(@RequestBody XdUser xdUser) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(Collections.singleton(xdUser.getOpenid())) && (StringUtils.isEmpty(xdUser.getPhoneNumber()) && StringUtils.isEmpty(xdUser.getPassword()))&&xdUser.getId()==null) {
            map.put("code", 201);
            map.put("msg", "信息不完全");
            return map;
        }
        XdUser xdUser1=xdUserService.selectXdUserById(xdUser.getId());
        List<XdUser> listXdUser = xdUserService.selectXdUserList(xdUser);
        map.put("code", 200);
        map.put("data", xdUser1);
        map.put("msg", "操作成功");
        return map;
//        if (listXdUser.size() == 1) {
//            map.put("code", 200);
//            map.put("data", xdUser1);
//            map.put("msg", "操作成功");
//        } else {
//            map.put("code", 202);
//            map.put("msg", "用户信息出错");
//        }
//        return map;
    }

    //    修改个人信息
    @PostMapping("/updateUserInfo")
    public Map<String, Object> updateUserInfo(@RequestBody XdUser xdUser) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (xdUser.getId() == null) {
            map.put("code", 201);
            map.put("msg", "请传入用户ID");
            return map;
        }
        int count = xdUserService.updateXdUser(xdUser);
        if (count > 0) {
            map.put("code", 200);
            map.put("msg", "修改成功");
        } else {
            map.put("code", 201);
            map.put("msg", "修改失败");
        }
        return map;
    }
    //    注册个人信息
    @PostMapping("/registerUserInfo")
    public Map<String, Object> registerUserInfo(@RequestBody XdUser xdUser) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(xdUser.getPhoneNumber()==null||xdUser.getPassword()==null){
            map.put("code", 201);
            map.put("msg", "信息不足，操作失败");
            return  map;
        }
//        判断手机号是否存在
        XdUser xdUser1=new XdUser();
        xdUser1.setPhoneNumber(xdUser.getPhoneNumber());
        List<XdUser> list=xdUserService.selectXdUserList(xdUser1);

            if(list.size()==1){
                if(xdUser.getId()!=null){
                    if(xdUser.getId()!=list.get(0).getId()){
                        map.put("code", 201);
                        map.put("msg", "手机号已存在，修改失败");
                        return  map;
                    }
                }else{
                    map.put("code", 201);
                    map.put("msg", "手机号已存在，修改失败");
                    return  map;
                }
            }


//        XdUser xdUser2=new XdUser();
//        xdUser2.setPhoneNumber(xdUser.getPhoneNumber());
//        List<XdUser> list2=xdUserService.selectXdUserList(xdUser2);
//        if(list2.size()>1){
//            map.put("code", 201);
//            map.put("msg", "手机号已存在");
//            return map;
//        }

        if(xdUser.getId()!=null){
            xdUserService.updateXdUser(xdUser);
            map.put("code", 200);
            map.put("msg", "修改成功");
            map.put("data", xdUser);
            return  map;
        }




        xdUserService.insertXdUser(xdUser);
        map.put("code", 200);
        map.put("msg", "注册成功");
        map.put("data",xdUser);
        return map;
    }

    //    添加修改收货地址
    @PostMapping("/updateAddress")
    public Map<String, Object> updateAddress(@RequestBody XdAddress xdAddress) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (xdAddress.getId() == null) {
            xdAddressService.insertXdAddress(xdAddress);
            map.put("msg", "地址添加成功");
        } else {
            xdAddressService.updateXdAddress(xdAddress);
            map.put("msg", "地址修改成功");
        }
        map.put("code", 200);
        map.put("data", xdAddress.getId());
        return map;
    }

    //    删除收货地址
    @PostMapping("/delAddress")
    public Map<String, Object> delAddress(@RequestBody XdAddress xdAddress) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (xdAddress.getId() == null || xdAddress.getuId() == null) {
            map.put("msg", "信息不全，删除失败");
            map.put("code", 201);
            return map;
        }
        xdAddressService.deleteXdAddressById(xdAddress.getId());
        map.put("msg", "地址删除成功");
        map.put("code", 200);
        return map;
    }
    //    获取收货地址列表
    @PostMapping("/getCartList")
    public Map<String, Object> getCartList(@RequestBody XdAddress xdAddress) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (xdAddress.getuId() == null) {
            map.put("msg", "无个人信息");
            map.put("code", 201);
            return map;
        }
        List<XdAddress> xdAddressList=xdAddressService.selectXdAddressList(xdAddress);
        map.put("msg", "操作成功");
        map.put("code", 200);
        map.put("data", xdAddressList);
        return map;
    }


    //    添加购物车
    @PostMapping("/addCart")
    public Map<String, Object> addCart(@RequestBody XdCarts carts) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (carts.getuId() == null) {
            map.put("msg", "无个人信息");
            map.put("code", 201);
            return map;
        }
        if (carts.getProductId() == null) {
            map.put("msg", "无商品信息");
            map.put("code", 201);
            return map;
        }
        XdCarts cartsSel = new XdCarts();
        cartsSel.setuId(carts.getuId());
        cartsSel.setProductId(carts.getProductId());
        cartsSel.setSpecsId(carts.getSpecsId());
        List<XdCarts> xdCartsList = xdCartsService.selectXdCartsList(cartsSel);
        if (xdCartsList.size() > 0) {
            if (carts.getQuantity() <= 0) {
                xdCartsService.deleteXdCartsById(xdCartsList.get(0).getId());
            } else {
                xdCartsList.get(0).setQuantity(carts.getQuantity());
                xdCartsService.updateXdCarts(xdCartsList.get(0));
            }
        }else{
            xdCartsService.insertXdCarts(carts);
        }
        map.put("msg", "操作成功");
        map.put("code", 200);
        return map;
    }

    @PostMapping("/delCarts")
    public Map<String, Object> delCarts(@RequestBody XdCarts carts) {
        Map<String, Object> map = new HashMap<String, Object>();
        String ids = carts.getParams().get("ids").toString();
        String [] idsStr=ids.split(",");
        int[] intArray = stringArrayToIntArray(idsStr);
        Long[] longArr = intArrayToLongArray(intArray);
        int count=xdCartsService.deleteXdCartsByIds(longArr);
        map.put("msg", "操作成功");
        map.put("code", 200);
        map.put("count", count);
        return map;
    }
    public static int[] stringArrayToIntArray(String[] strArr) {
        int length = strArr.length;
        int[] intArr = new int[length];
        for (int i = 0; i < length; i++) {
            try {
                // 使用Integer.parseInt()将字符串转换为整数
                intArr[i] = Integer.parseInt(strArr[i]);
            } catch (NumberFormatException e) {
                // 如果字符串不能被解析为整数，可以抛出自定义异常或设置默认值
                // 这里为了简单起见，我们使用默认值0
                intArr[i] = 0;
                // 或者你可以选择抛出异常，以指示输入无效
                // throw new IllegalArgumentException("Invalid input string: " + strArr[i], e);
            }
        }
        return intArr;
    }
    public static Long[] intArrayToLongArray(int[] intArr) {
        int length = intArr.length;
        Long[] longArr = new Long[length];
        for (int i = 0; i < length; i++) {
            // 将int值转换为long并存储到Long数组中
            longArr[i] = (long) intArr[i];
        }
        return longArr;
    }

    //    添加订单
    @PostMapping("/addOrder")
    public Map<String, Object> addOrder(@RequestBody XdOrders xdOrders) {
        Map<String, Object> map = new HashMap<String, Object>();

        if(xdOrders.getuId()==null){
            map.put("msg", "用户信息为空");
            map.put("code", 201);
            return map;
        }
        if(xdOrders.getShippingMethod().equals("2")){
            if(xdOrders.getAddress()==null
                    ||xdOrders.getAddressId()==null
                    ||xdOrders.getAddressInfo()==null
                    ||xdOrders.getAddressName()==null
                    ||xdOrders.getAddressPhone()==null
            ){
                map.put("msg", "地址信息为空");
                map.put("code", 201);
                return map;
            }
        }
        Long goodCount=0L;
        xdOrders.setOrderNumber(Utils.getOrderCode());
        XdCoupons xdCoupons=null;
        if(xdOrders.getCouponId()!=null){
            xdCoupons=xdCouponsService.selectXdCouponsById(xdOrders.getCouponId());
            Date nowDate = new Date();
            Boolean isYes= DateUtils.isDateBetween(nowDate,xdCoupons.getStartDate(),xdCoupons.getEndDate());
            if(!isYes){
                map.put("msg", "优惠券不在可使用日期内");
                map.put("code", 201);
                return map;
            }
        }
//        订单商品列表
        List<XdOrdersInfo> xdOrdersInfoList = (List<XdOrdersInfo>) xdOrders.getParams().get("goodList");
        List<XdOrdersInfo> xdAnOrdersInfoList= JSON.parseArray(JSON.toJSONString(xdOrdersInfoList),XdOrdersInfo.class);

        //判断商品库存是否足够
        Boolean isKucun=true;
        for(int a=0;a<xdAnOrdersInfoList.size();a++){
            goodCount=goodCount+xdAnOrdersInfoList.get(a).getQuantity();
            XdGoodSpecs xdGoodSpecs=xdGoodSpecsService.selectXdGoodSpecsById(xdAnOrdersInfoList.get(a).getSpaceId());
            if(xdGoodSpecs.getCount()<xdAnOrdersInfoList.get(a).getQuantity()){
                isKucun=false;
            }
        }
        if(!isKucun){
            map.put("msg", "商品库存不足，下单失败");
            map.put("code", 201);
            return map;
        }


        BigDecimal totalAmount= BigDecimal.valueOf(0.00);//订单总价、
        BigDecimal couponMoney=BigDecimal.valueOf(0.00);//优惠券总金额
        BigDecimal endMoney=BigDecimal.valueOf(0.00);//最终价格

        for(int a=0;a<xdAnOrdersInfoList.size();a++){
            XdOrdersInfo xoi=xdAnOrdersInfoList.get(a);
            BigDecimal Quantity = new BigDecimal(xoi.getQuantity());
            BigDecimal result = xoi.getSpecsPrice().multiply(Quantity);
            xdAnOrdersInfoList.get(a).setFinalPrice(result);
            totalAmount=totalAmount.add(result).setScale(2, RoundingMode.HALF_UP);
            if(xdAnOrdersInfoList.get(a).getParams().get("cartId")!=null){
                Long cartId= Long.parseLong(xdAnOrdersInfoList.get(a).getParams().get("cartId").toString());
                xdCartsService.deleteXdCartsById(cartId);
            }


        }
        if(xdOrders.getCouponId()!=null){
            if(xdCoupons.getMinimumAmount().compareTo(totalAmount)==-1){
                if(xdCoupons.getType().equals("1")){
                    endMoney=totalAmount.subtract(xdCoupons.getMoney());
                }else if(xdCoupons.getType().equals("2")){
                    BigDecimal n = new BigDecimal(10);
                    endMoney= totalAmount.multiply(xdCoupons.getDiscount().divide(n));
                }
            }
        }else{
            endMoney=totalAmount;
        }


//        计算优惠的总金额
        couponMoney=totalAmount.subtract(endMoney);
//        保留两位小数
        totalAmount = totalAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
        endMoney = endMoney.setScale(2, BigDecimal.ROUND_HALF_UP);
        couponMoney = couponMoney.setScale(2, BigDecimal.ROUND_HALF_UP);
        xdOrders.setTotalAmount(totalAmount);
        xdOrders.setEndMoney(endMoney);
        xdOrders.setCouponMoney(couponMoney);
        xdOrders.setTotalInteger(Utils.integerToB(endMoney));
        xdOrders.setStatus(1L);
        xdOrders.setOrderDate(new Date());
        xdOrdersService.insertXdOrders(xdOrders);
//        添加订单商品
        for(int  a=0;a<xdAnOrdersInfoList.size();a++){
            xdAnOrdersInfoList.get(a).setOrderId(xdOrders.getId());
            xdOrdersInfoService.insertXdOrdersInfo(xdAnOrdersInfoList.get(a));

        }
//        把优惠券领取记录整成已使用
        if(xdOrders.getCouponId()!=null){
            XdUseCoupons xdUseCoupons=new XdUseCoupons();
            xdUseCoupons.setUsedOrderId(xdOrders.getId());
            xdUseCoupons.setuId(xdOrders.getuId());
            xdUseCoupons.setStatus("2");
            Integer historyCouponId= (Integer) xdOrders.getParams().get("historyCouponId");
            Long longVal = historyCouponId.longValue();
            xdUseCoupons.setId(longVal);
            xdUseCouponsService.updateXdUseCoupons(xdUseCoupons);
            xdCoupons.setUsedCount(xdCoupons.getUsedCount()+1);
            xdCouponsService.updateXdCoupons(xdCoupons);
        }

        for(int a=0;a<xdAnOrdersInfoList.size();a++){
            XdGoodSpecs xdGoodSpecs=xdGoodSpecsService.selectXdGoodSpecsById(xdAnOrdersInfoList.get(a).getSpaceId());
            xdGoodSpecs.setCount(xdGoodSpecs.getCount()-xdAnOrdersInfoList.get(a).getQuantity());
            xdGoodSpecsService.updateXdGoodSpecs(xdGoodSpecs);
        }
//        给用户添加积分
            XdUser xdUser=new XdUser();
            xdUser.setId(xdOrders.getuId());
            xdUser.setIntegral(Utils.integerToB(endMoney));
            xdUserService.updateIntegral(xdUser);
            map.put("msg", "操作成功");
            map.put("code", 200);
//            添加积分记录
        XdIntegralRecord xdIntegralRecord=new XdIntegralRecord();
        xdIntegralRecord.getOrderId(xdOrders.getId());
        xdIntegralRecord.setuId(xdOrders.getuId());
        xdIntegralRecord.setNum(xdOrders.getTotalInteger());
        xdIntegralRecord.setDeptId(xdOrders.getDeptId());
        xdIntegralRecord.setNotes("下单获取欧积分（1:1）");
        xdIntegralRecord.setUpdateType(1L);
        xdIntegralRecord.setConsumptionType(1L);
        xdIntegralRecord.setCreateTime(new Date());
        xdIntegralRecordService.insertXdIntegralRecord(xdIntegralRecord);
//        添加佣金记录
        XdUser xdUserInfo=xdUserService.selectXdUserById(xdOrders.getuId());
        XdCommissionHistory xdCommissionHistory=new XdCommissionHistory();
        if(xdUserInfo!=null &&xdUserInfo.getSuperiorPhone()!=null){
            xdCommissionHistory.setuId(xdUserInfo.getSuperiorPhone());
        }else{
            xdCommissionHistory.setuId(1L);
        }
        xdCommissionHistory.setOrderId(xdOrders.getId());
        xdCommissionHistory.setDeptId(xdOrders.getDeptId());
        xdCommissionHistory.setBelowId(xdOrders.getuId());
        BigDecimal bd0_1 = BigDecimal.valueOf(0.1);
        xdCommissionHistory.setMoney(xdOrders.getEndMoney().multiply(bd0_1));
        xdCommissionHistory.setStatus("1");
        xdCommissionHistory.setType(1L);
        xdCommissionHistory.setGoodCount(goodCount);
        xdCommissionHistory.setCreateTime(new Date());

//        goodCount
        xdCommissionHistory.setRemark("下单了"+xdOrders.getEndMoney()+"元的商品");
        xdCommissionHistoryService.insertXdCommissionHistory(xdCommissionHistory);
        map.put("data",xdOrders);
        return map;
    }
//    立即付款
    @PostMapping("/payOrderById")
    public Map<String, Object> payOrderById(@RequestBody XdOrders xdOrders) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(xdOrders.getId()==null||xdOrders.getuId()==null){
            map.put("msg", "支付失败");
            map.put("code", 201);
            return map;
        }
        xdOrders.setPayTime(new Date());
        xdOrders.setStatus(2L);
        xdOrdersService.updateXdOrders(xdOrders);
        map.put("msg", "付款成功");
        map.put("code", 200);
        return map;
    }
//    删除订单取消订单
    @PostMapping("/delOrderById")
    public Map<String, Object> delOrderById(@RequestBody XdOrders xdOrders) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(xdOrders.getuId()==null||xdOrders.getId()==null){
            map.put("msg", "信息不足");
            map.put("code", 201);
        }else if(xdOrders.getStatus()!=0){
            map.put("msg", "状态不匹配，取消失败");
            map.put("code", 201);
        }
        return map;
    }

    @PostMapping("/returnOrderByuid")
    public Map<String, Object> returnOrderByuid(@RequestBody XdOrders xdOrders) {
        Map<String, Object> map = new HashMap<String, Object>();
       if(xdOrders.getId()==null||xdOrders.getuId()==null){
           map.put("msg", "信息不足，退款失败");
           map.put("code", 201);
           return map;
       }
//      获取订单列表
         List<XdOrders> xdOrderList= xdOrdersService.getOrders(xdOrders);
        if(xdOrderList.size()>0){
            if(xdOrderList.get(0).getStatus()>2){
                map.put("msg", "已发货的商品不能退款");
                map.put("code", 201);
                return map;
            }
            List<XdOrdersInfo> xdOrdersInfoList =xdOrderList.get(0).getOrderItems();
//            回退库存
            for(int a=0;a<xdOrdersInfoList.size();a++){
                XdGoodSpecs xdGoodSpecs=new XdGoodSpecs();
                xdGoodSpecs.setId(xdOrdersInfoList.get(a).getSpaceId());
                xdGoodSpecs.setCount(xdOrdersInfoList.get(a).getQuantity());
                xdGoodSpecsService.updateGoodCount(xdGoodSpecs);
            }
//            回退积分
            XdUser xdUser=new XdUser();
            xdUser.setId(xdOrderList.get(0).getuId());
            xdUser.setIntegral(xdOrderList.get(0).getTotalInteger());
            xdUserService.updateIntegraljian(xdUser);

            XdIntegralRecord xdIntegralRecord=new XdIntegralRecord();
            xdIntegralRecord.getOrderId(xdOrderList.get(0).getId());
            xdIntegralRecord.setuId(xdOrderList.get(0).getuId());
            xdIntegralRecord.setDeptId(xdOrderList.get(0).getDeptId());
            xdIntegralRecord.setNotes("退款消费积分（1:1）");
            xdIntegralRecord.setUpdateType(2L);
            xdIntegralRecord.setNum(xdOrderList.get(0).getTotalInteger());
            xdIntegralRecord.setConsumptionType(1L);
            xdIntegralRecordService.insertXdIntegralRecord(xdIntegralRecord);

//            修改订单状态
            XdOrders xdOrders1=new XdOrders();
            xdOrders1.setId(xdOrders.getId());
            xdOrders1.setStatus(7L);
            xdOrders1.setUpdateTime(new Date());
            xdOrdersService.updateXdOrders(xdOrders1);
//            退款
            System.out.printf("申请退款");



        }
        map.put("msg", "退款完成");
        map.put("code", 200);
        return map;
    }




    //获取购物车
    @PostMapping("/getCart")
    public Map<String, Object> getCart(@RequestBody XdCarts xdCarts) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(xdCarts.getuId()==null){
            map.put("msg", "获取购物车失败");
            map.put("code", 201);
            return map;
        }
        List<XdCarts> listXdCarts=xdCartsService.getUserCarts(xdCarts);
        map.put("msg", "操作成功");
        map.put("code", 200);
        map.put("data", listXdCarts);
        return map;
    }

    //用户领取优惠券
    @PostMapping("/addCouponById")
    public Map<String, Object> addCouponById(@RequestBody XdUseCoupons xdUseCoupons) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(xdUseCoupons.getuId()==null){
            map.put("msg", "领取失败");
            map.put("code", 201);
            return map;
        }
        xdUseCoupons.setStatus("1");
        XdCoupons xdCoupons=xdCouponsService.selectXdCouponsById(xdUseCoupons.getcId());
        if(xdCoupons.getUsageLimit()>0){
            xdUseCouponsService.insertXdUseCoupons(xdUseCoupons);
            xdCoupons.setUsageLimit(xdCoupons.getUsageLimit()-1);
            xdCouponsService.updateXdCoupons(xdCoupons);
        }else{
            map.put("msg", "优惠券无库存了");
            map.put("code", 201);
            return map;
        }
        map.put("msg", "操作成功");
        map.put("code", 200);
        return map;
    }

//    获取领取的优惠券列表
    @PostMapping("/getCouponListByUid")
    public Map<String, Object> getCouponListByUid(@RequestBody XdUseCoupons xdUseCoupons) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(xdUseCoupons.getuId()==null){
            map.put("msg", "获取优惠券失败");
            map.put("code", 201);
            return map;
        }
        xdUseCoupons.setStatus("1");
        List<XdUseCoupons> xdUseCouponsList=xdUseCouponsService.selectXdUseCouponsList(xdUseCoupons);
        map.put("msg", "操作成功");
        map.put("code", 200);
        map.put("data", xdUseCouponsList);
        return map;
    }
//    获取订单列表
    @PostMapping("/getorders")
    public Map<String, Object> getorders(@RequestBody XdOrders xdOrders) {
        Map<String, Object> map = new HashMap<>();
        List<XdOrders> listOrders=xdOrdersService.getOrders(xdOrders);
        map.put("data",listOrders);
        map.put("code", 200);
        return map;
    }

//    获取订单详情
    @PostMapping("/getordersInfo")
    public Map<String, Object> getordersInfo(@RequestBody XdOrders xdOrders) {
        Map<String, Object> map = new HashMap<>();
        XdOrders xdOrders1=xdOrdersService.selectXdOrdersById(xdOrders.getId());
        XdOrdersInfo xdOrdersInfo=new XdOrdersInfo();
        xdOrdersInfo.setOrderId(xdOrders.getId());
        List<XdOrdersInfo> ordersInfoss=xdOrdersInfoService.selectXdOrdersInfoList(xdOrdersInfo);
//        查询优惠券
        if(xdOrders1.getCouponId()!=null){
            XdCoupons xdCoupons=new XdCoupons();
            xdCoupons=xdCouponsService.selectXdCouponsById(xdOrders1.getCouponId());
            xdOrders1.getParams().put("xdCoupons",xdCoupons);
        }
//退款信息
        XdOrderRefunds xdOrderRefundss=new XdOrderRefunds();
        xdOrderRefundss.setOrderId(xdOrders1.getId());

        List<XdOrderRefunds> listOrderReturn=xdOrderRefundsService.selectXdOrderRefundsList(xdOrderRefundss);
        if(listOrderReturn.size()>0){
            xdOrders1.getParams().put("returnInfos",listOrderReturn);
        }


        xdOrders1.getParams().put("ordersInfoss",ordersInfoss);
        map.put("data",xdOrders1);
        map.put("code", 200);
        return map;
    }

//    确认收货
    @PostMapping("/confirmOrder")
    public Map<String, Object> confirmOrder(@RequestBody XdOrders xdOrders) {
        Map<String, Object> map = new HashMap<>();
        xdOrders.setPutTime(new Date());
        xdOrdersService.updateXdOrders(xdOrders);
//        给用户添加佣金
        xdOrders=xdOrdersService.selectXdOrdersById(xdOrders.getId());
        if(xdOrders.getSuperiorId()!=null){
             XdUser xdUser=   xdUserService.selectXdUserById(xdOrders.getSuperiorId());
             if(xdUser!=null){
                 BigDecimal bili = new BigDecimal("0.1");
                 BigDecimal result = xdOrders.getEndMoney().multiply(bili);

                 xdUser.setMoney(xdUser.getMoney().add(result).setScale(2, RoundingMode.HALF_UP));
                 xdUserService.updateXdUser(xdUser);
                 XdCommissionHistory xdCommissionHistory=new XdCommissionHistory();
                 xdCommissionHistory.setOrderId(xdOrders.getId());
                 List<XdCommissionHistory> lust=xdCommissionHistoryService.selectXdCommissionHistoryList(xdCommissionHistory);
                 if(lust.size()>0){
                     XdCommissionHistory xdCommissionHistory1=new XdCommissionHistory();
                     xdCommissionHistory1.setStatus("2");
                     xdCommissionHistory1.setId(lust.get(0).getId());
                     xdCommissionHistoryService.updateXdCommissionHistory(xdCommissionHistory1);
                 }
             }
        }
        map.put("msg","操作成功");
        map.put("code", 200);
        return map;
    }

    @PostMapping("/upload")
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", url);
            ajax.put("fileName", fileName);
            ajax.put("newFileName", FileUtils.getName(fileName));
            ajax.put("originalFilename", file.getOriginalFilename());
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }
    @PostMapping("/getCouponByUid")
    public Map<String, Object> getCouponByUid(@RequestBody XdUseCoupons xdUseCoupons) {
        Map<String, Object> map = new HashMap<>();
        List<XdUseCoupons> couponsList=xdUseCouponsService.getCouponByUid(xdUseCoupons);
        map.put("msg","操作成功");
        map.put("code", 200);
        map.put("data", couponsList);
        return map;
    }

    @PostMapping("/returnOrderMoneyByUid")
    public Map<String, Object> returnOrderMoneyByUid(@RequestBody XdOrderRefunds  xdOrderRefunds) {
        Map<String, Object> map = new HashMap<>();
        if(xdOrderRefunds.getuId()==null){
            map.put("msg","个人信息不足，退款失败");
            map.put("code", 200);
            return map;
        }
        XdOrders xdOrders=new XdOrders();
        xdOrders.setuId(xdOrderRefunds.getuId());
        xdOrders.setId(xdOrderRefunds.getOrderId());
        List<XdOrders> xdOrdersList=xdOrdersService.selectXdOrdersList(xdOrders);
        if(xdOrdersList.size()==0){
            map.put("msg","订单查询失败");
            map.put("code", 200);
            return map;
        }
        XdOrders xdOrders1=xdOrdersList.get(0);
        xdOrders1.setStatus(7L);
        xdOrdersService.updateXdOrders(xdOrders1);
        xdOrderRefundsService.insertXdOrderRefunds(xdOrderRefunds);
        map.put("msg","申请成功，请等待审核");
        map.put("code", 200);
        return map;
    }
    //    通过商品规格ID以及用户ID查询个数
    @PostMapping("/getCartGoodCount")
    public Map<String, Object> getCartGoodCount(@RequestBody XdCarts  xdCarts) {
        Map<String, Object> map = new HashMap<>();
        List<XdCarts> xdCartsList =xdCartsService.selectXdCartsList(xdCarts);
        if(xdCartsList.size()<=0){
            map.put("data", 1);
        }else{
            map.put("data", xdCartsList.get(0).getQuantity());
        }
        map.put("msg","申请成功，请等待审核");
        map.put("code", 200);
        return map;
    }
        //    获取佣金记录
        @PostMapping("/getKickbacks")
        public Map<String, Object> getKickbacks(@RequestBody XdCommissionHistory  xdCommissionHistory) {
            Map<String, Object> map = new HashMap<>();
            List<XdCommissionHistory> xdCommissionHistoryList =xdCommissionHistoryService.getKickbacks(xdCommissionHistory);
            map.put("msg","操作成功");
            map.put("code", 200);
            map.put("data", xdCommissionHistoryList);
            return map;
        }



    @PostMapping("/userReangeMoney")
    public Map<String, Object> userReangeMoney(@RequestBody XdUserRechargeRecords xdUserRechargeRecords) {
        Map<String, Object> map = new HashMap<>();
        if(xdUserRechargeRecords.getuId()==null||xdUserRechargeRecords.getRechargeAmount()==null){
            map.put("msg","充值失败");
            map.put("code", 201);
            return map;
        }
        String orderCode=Utils.getOrderCode();
        xdUserRechargeRecords.setTransactionId(orderCode);
        xdUserRechargeRecordsService.insertXdUserRechargeRecords(xdUserRechargeRecords);
//        给用户增加余额
        XdUser xdUser=xdUserService.selectXdUserById(xdUserRechargeRecords.getuId());
        if(xdUser==null){
            map.put("msg","充值失败");
            map.put("code", 201);
            return map;
        }else{
            xdUser.setMoney(xdUser.getMoney().add(xdUserRechargeRecords.getRechargeAmount()).setScale(2,RoundingMode.HALF_UP));
            xdUserService.updateXdUser(xdUser);
        }
        map.put("msg","充值成功");
        map.put("code", 200);
        return map;
    }

        //    使用余额支付
        @PostMapping("/toBalancePay")
        public Map<String, Object> toBalancePay(@RequestBody XdUserConsumptionRecords xdUserConsumptionRecords) {

            Map<String, Object> map = new HashMap<>();
            XdUser xdUser1=xdUserService.selectXdUserById(xdUserConsumptionRecords.getuId());
            if(xdUser1==null){
                map.put("msg","用户信息不存在,支付失败");
                map.put("code", 201);
                return map;
            }else{
                int result = xdUser1.getMoney().compareTo(xdUserConsumptionRecords.getTotalPrice());
                if(result<0){
                    map.put("msg","余额不足,支付失败");
                    map.put("code", 201);
                    return map;
                }else{
                    xdUser1.setMoney(xdUser1.getMoney().subtract(xdUserConsumptionRecords.getTotalPrice()).setScale(2,RoundingMode.HALF_UP));
                    xdUserService.updateXdUser(xdUser1);
                    XdOrders xdOrders=new XdOrders();
                    xdOrders.setId(xdUserConsumptionRecords.getOrderId());
                    xdOrders.setStatus(2L);
                    xdOrdersService.updateXdOrders(xdOrders);
                }
            }
            xdUserConsumptionRecordsService.insertXdUserConsumptionRecords(xdUserConsumptionRecords);
            map.put("msg","支付成功");
            map.put("code", 200);
            return map;
        }

//    获取佣金记录
    @PostMapping("/getKickbackhistory")
    public Map<String, Object> getKickbackhistory(@RequestBody XdCommissionHistory xdCommissionHistory) {
        Map<String, Object> map = new HashMap<>();
        if(xdCommissionHistory.getuId()==null){
            map.put("msg","获取失败");
            map.put("code", 200);
            return map;
        }
        List<XdCommissionHistory> xdCommissionHistoryList=xdCommissionHistoryService.selectXdCommissionHistoryList(xdCommissionHistory);
        map.put("data",xdCommissionHistoryList);
        map.put("msg","操作成功");
        map.put("code", 200);
        return map;
    }

//    获取充值记录
    @PostMapping("/getRangehistory")
    public Map<String, Object> getRangeHistory(@RequestBody XdUserRechargeRecords xdCommissionHistory) {
        Map<String, Object> map = new HashMap<>();
        if(xdCommissionHistory.getuId()==null){
            map.put("msg","获取失败");
            map.put("code", 200);
            return map;
        }
        List<XdUserRechargeRecords> xdUserRechargeRecordsList=xdUserRechargeRecordsService.selectXdUserRechargeRecordsList(xdCommissionHistory);
        map.put("data",xdUserRechargeRecordsList);
        map.put("msg","操作成功");
        map.put("code", 200);
        return map;
    }
//    获取余额消费记录
    @PostMapping("/getConsumptionHistory")
    public Map<String, Object> getConsumptionHistory(@RequestBody XdUserConsumptionRecords xdUserConsumptionRecords) {
        Map<String, Object> map = new HashMap<>();
        if(xdUserConsumptionRecords.getuId()==null){
            map.put("msg","获取失败");
            map.put("code", 200);
            return map;
        }
        List<XdUserConsumptionRecords> xdUserConsumptionRecordsList=xdUserConsumptionRecordsService.selectXdUserConsumptionRecordsList(xdUserConsumptionRecords);
        map.put("data",xdUserConsumptionRecordsList);
        map.put("msg","操作成功");
        map.put("code", 200);
        return map;
    }

//    登录
    @PostMapping("/tooLogin")
    public Map<String, Object> tooLogin(@RequestBody XdUser xdUser) {
        Map<String, Object> map = new HashMap<>();
        if(xdUser.getPhoneNumber()==null||xdUser.getPassword()==null){
            map.put("msg","登录失败");
            map.put("code", 200);
            return map;
        }
        List<XdUser> xdUserList=xdUserService.selectXdUserList(xdUser);
        if(xdUserList.size()==1){
            map.put("data",xdUserList.get(0));
            map.put("msg","登录成功");
            map.put("code", 200);
        }else{
            map.put("msg","账号或密码有误，登录失败");
            map.put("code", 201);
        }
        return map;
    }

    @PostMapping("/toRegister")
    public Map<String, Object> toRegister(@RequestBody XdUser xdUser) {
        Map<String, Object> map = new HashMap<>();
        if(xdUser.getPhoneNumber()==null||xdUser.getPassword()==null){
            map.put("msg","注册失败");
            map.put("code", 200);
            return map;
        }
        XdUser xdUsersel1=new XdUser();
        xdUsersel1.setPhoneNumber(xdUser.getPhoneNumber());
        List<XdUser> xdUserList=xdUserService.selectXdUserList(xdUsersel1);
        if(xdUserList.size()>0){
            map.put("msg","手机号已被注册");
            map.put("code", 201);
            return map;
        }else{
            //查询上级的手机号是否存在
            if(xdUser.getSource()!=null){
                XdUser xdUser1=new XdUser();
                xdUser1.setPhoneNumber(xdUser.getSource());
                List<XdUser> list=xdUserService.selectXdUserList(xdUser1);
                if(list.size()<=0){
                    map.put("msg","上级手机号输入错误，注册失败");
                    map.put("code", 201);
                    return map;
                }else{
                    xdUser.setSuperiorPhone(list.get(0).getId());
                }
            }



            xdUserService.insertXdUser(xdUser);
            map.put("msg","注册成功");
            map.put("data",xdUser);

            map.put("code", 200);
        }
        return map;
    }

    @PostMapping("/updatePassword")
    public Map<String, Object> updatePassword(@RequestBody XdUser xdUser) {
        Map<String, Object> map = new HashMap<>();
        if(xdUser.getPhoneNumber()==null||xdUser.getPassword()==null||xdUser.getParams().get("code")==null){
            map.put("msg","修改密码失败");
            map.put("code", 201);
            return map;
        }

        XdUser xdUser1=new XdUser();
        xdUser1.setPhoneNumber(xdUser.getPhoneNumber());
        List<XdUser> xdUserList1=xdUserService.selectXdUserList(xdUser1);
        if(xdUserList1.size()<=0){
            map.put("msg","手机号不存在");
            map.put("code", 201);
            return map;
        }
        XdUser xdUser2=xdUserList1.get(0);
        xdUser2.setPassword(xdUser.getPassword());
        xdUserService.updateXdUser(xdUser2);
        map.put("msg","修改密码成功");
        map.put("code", 200);
        return map;
    }

}
