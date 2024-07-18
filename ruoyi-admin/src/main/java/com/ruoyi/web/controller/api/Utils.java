package com.ruoyi.web.controller.api;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils {
    public static String getOrderCode(){
        // 获取当前的日期时间
        LocalDateTime now = LocalDateTime.now();

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

        // 格式化日期时间并打印
        String formattedDateTime = now.format(formatter);
        Random random = new Random();
        int randomNumber = random.nextInt(1000) + 1; // 生成1到1000之间的随机数
        int randomNumber1 = random.nextInt(1000) + 1; // 生成1到1000之间的随机数
        int randomNumber2 = random.nextInt(1000) + 1; // 生成1到1000之间的随机数
        formattedDateTime=randomNumber+randomNumber1+formattedDateTime+randomNumber2;
        System.out.println("当前的日期时间是: " + formattedDateTime);
        return formattedDateTime;
    }
    public  static Long integerToB(BigDecimal bd){

        // 检查是否有小数部分
        if (bd.scale() > 0) {
            // 如果有小数部分，你可以选择如何处理它
            // 例如，通过四舍五入去除小数部分
            bd = bd.setScale(0, RoundingMode.HALF_UP);
        }

        // 检查值是否在 int 范围内
        if (bd.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) > 0 || bd.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) < 0) {
            // 如果不在范围内，你可以抛出异常或处理这种情况
            System.out.println("Value is out of range for int.");
            return 0L;
        }

        // 转换为 int
        int value = bd.intValueExact(); // 如果确定值在 int 范围内，使用这个方法
        long longValue = value; // 隐式类型转换
        return longValue;
    }
    public static void main(String[] args) {
        System.out.printf("---"+getOrderCode());
    }
}
