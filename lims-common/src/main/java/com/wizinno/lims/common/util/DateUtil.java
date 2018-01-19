package com.wizinno.lims.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author LiuMei
 * @date 2017-11-20.
 */
public class DateUtil {

    /**
     * 获取两个日期天数差
     *
     * @param aDate
     * @param bDate
     * @return
     * @throws ParseException
     */
    public static Integer daysBetween(Date aDate, Date bDate) {
        if(aDate != null && bDate != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                aDate = sdf.parse(sdf.format(aDate));
                bDate = sdf.parse(sdf.format(bDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(aDate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bDate);
            long time2 = cal.getTimeInMillis();
            long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(betweenDays)+1);
        }else {
            return null;
        }

    }

}
