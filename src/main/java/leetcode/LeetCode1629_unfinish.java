package leetcode;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author : liyang
 * @date : 10/1/2022
 * link: https://leetcode-cn.com/problems/slowest-key/
 * 1629. 按键持续时间最长的键
 */
public class LeetCode1629_unfinish {

    private static String yearType = "1";

    //月度任务
    private static String monthType = "0";

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat monTypeSdf = new SimpleDateFormat("yyyyMM");
        String taskTime = "202301";

        Date date = monTypeSdf.parse(taskTime);

        LocalDateTime localDateEndDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).with(TemporalAdjusters.lastDayOfMonth()).plusDays(1).minusSeconds(1);
        System.out.println(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
        System.out.println(localDateEndDate);
        System.out.println(calculationEstimateTime(localDateEndDate,"0"));

    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        return 1;
    }

    private static LocalDateTime calculationEstimateTime(LocalDateTime taskEndTime, String taskDateType) {
        Date startDate = new Date();
        Calendar calendar = Calendar.getInstance();
        LocalDateTime localDateStartDate = null;
        Date taskTime = Date.from(taskEndTime.atZone(ZoneOffset.ofHours(8)).toInstant());
        //在任务数据类型为月时,传回1个月前的时间
        if (monthType.equals(taskDateType)) {
            calendar.setTime(taskTime);
            calendar.add(calendar.MONTH, -1);
            startDate = calendar.getTime();
            localDateStartDate = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault()).plusSeconds(1);
        } //在任务数据类型为年时,传回3年前的时间
        else if (yearType.equals(taskDateType)) {
            calendar.setTime(taskTime);
            calendar.add(calendar.YEAR, -3);
            startDate = calendar.getTime();
            localDateStartDate = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault()).plusSeconds(1);
        }
        //在任务数据类型为空时,传回半年前的时候--查询半年内主单表是否有病例标识为康复病例
        if (StringUtils.isEmpty(taskDateType)) {
            calendar.setTime(taskTime);
            calendar.add(calendar.MONTH, -6);
            startDate = calendar.getTime();
            localDateStartDate = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault()).plusSeconds(1);
        }
        return localDateStartDate;
    }
}
