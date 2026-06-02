import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) throws ParseException {

        // 1. 当前日期，格式化为 "yyyy年MM月dd日 HH:mm:ss"
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println("当前时间: " + sdf1.format(new Date()));

        // 2. Calendar 设为 2026-06-02，加 10 天
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2026);
        cal.set(Calendar.MONTH, 5);          // 月份从 0 开始，5 就是 6 月
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.add(Calendar.DAY_OF_MONTH, 10);  // 加 10 天 → 2026-06-12
        System.out.println("2026-06-02 + 10天: " + sdf1.format(cal.getTime()));

        // 3. 解析字符串 "2025-01-01 08:00:00" 为 Date
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsed = sdf2.parse("2025-01-01 08:00:00");
        System.out.println("解析结果: " + parsed);
    }
}
