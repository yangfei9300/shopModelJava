import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class tes {
    public static String generateOrderId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
//        System.out.printf("-11-"+generateOrderId());
//        Random random=new Random();
//        System.out.printf("订单编号"+random.nextInt(2500));
        getriqi();
    }
    public  static void  getriqi(){
        // 获取当前日期
        LocalDate today = LocalDate.now();

        // 获取本月的第一天
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);

        // 格式化日期为 "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 创建一个列表来存储日期字符串
        List<String> dateList = new ArrayList<>();

        // 从本月1号开始，到当天为止，将每天的日期添加到列表中
        LocalDate currentDate = firstDayOfMonth;
        while (!currentDate.isAfter(today)) {
            dateList.add(currentDate.format(formatter));
            currentDate = currentDate.plusDays(1); // 递增到下一天
        }

        // 打印日期列表
        for (String date : dateList) {
            System.out.println(date);
        }
    }
}
