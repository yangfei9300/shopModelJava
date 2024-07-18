package com.ruoyi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JUtils {
    public  static List<Map<String,String>>  getriqi(){
        // 获取当前日期
        LocalDate today = LocalDate.now();

        // 获取本月的第一天
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);

        // 格式化日期为 "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 创建一个列表来存储日期字符串
        List<Map<String,String>> dateList = new ArrayList<Map<String,String>>();

        // 从本月1号开始，到当天为止，将每天的日期添加到列表中
        LocalDate currentDate = firstDayOfMonth;
        while (!currentDate.isAfter(today)) {
            Map<String,String> mapp=new HashMap<>();
            mapp.put("date",currentDate.format(formatter));
            dateList.add(mapp);
            currentDate = currentDate.plusDays(1); // 递增到下一天
        }
        return dateList;
    }

    public static void main(String[] args) {
        getWeekStr();
    }

    public static List<Map<String,String>> getWeekStr(){

        List<Map<String,String>> listt=new ArrayList<Map<String,String>>();

        // 获取当前日期
        LocalDate today = LocalDate.now();

        // 定义周的起始日（这里假设是周一）
        DayOfWeek startOfWeek = DayOfWeek.MONDAY;

        // 计算本周一（如果今天是周一或之前的任何一天，则返回上周一）
        LocalDate startOfWeekDate = today.with(java.time.temporal.TemporalAdjusters.previousOrSame(startOfWeek));

        // 计算本周日（本周一加上6天）
        LocalDate endOfWeekDate = startOfWeekDate.plusDays(6);

        // 创建一个列表来存储本周的日期
        List<String> weekDates = new ArrayList<>();
        // 遍历本周的每一天，并添加到列表中
        for (LocalDate date = startOfWeekDate; !date.isAfter(endOfWeekDate); date = date.plusDays(1)) {
            // 格式化日期为 "年月日" 并添加到列表中
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            weekDates.add(date.format(formatter));
        }
        // 打印本周的日期列表
        for (String dateString : weekDates) {
            System.out.println(dateString);
            Map<String,String> map=new HashMap<>();
            map.put("date",dateString);
            listt.add(map);
        }
        return listt;
    }
}
