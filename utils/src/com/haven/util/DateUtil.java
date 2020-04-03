package com.haven.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * date类型的一些工具类
 */
public class DateUtil {
    /**
     * 默认日期格式
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd";



    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }

    /**
     * 日期相减
     * @param endDate
     * @param startDate
     * @return
     */
    public static Long getDatePoor(Date endDate, Date startDate) {
        long nd = 1000l * 24l * 60l * 60l;  // 天
        long nh = 1000l * 60l * 60l;       // 时
        long nm = 1000l * 60l;            // 分
        long ns = 1000l;                // 秒
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
//        long day = diff / nd;
        // 计算差多少小时
//        long hour = diff % nd / nh;
        // 计算差多少分钟
//        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return diff / nm;
    }

    /**
     * 日期相减，获得秒
     * @param endDate
     * @param startDate
     * @return
     */
    public static Long getDatePoorSecond(Date endDate, Date startDate) {
        long ns = 1000;                // 秒
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        return diff / ns;
    }

    /**
     * 获得时间相减结果毫秒
     * @param endDate
     * @param startDate
     * @return
     */
    public static Long getDatePoorMs(Date endDate, Date startDate) {
        if(endDate == null ||
            startDate == null){
            return null;
        }
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        return diff;
    }
    /**
     * 格式化日期
     * @param date 日期对象
     * @return String 日期字符串
     */
    public static String formatDate(Date date){
        SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
        String sDate = f.format(date);
        return sDate;
    }


    public static String getFormatDateMonth(){
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
        String sDate = f.format(date);
        return sDate;
    }

    public static String getFormatDateMonth_Day(Date date){
        SimpleDateFormat f = new SimpleDateFormat("MM-dd");
        String sDate = f.format(date);
        return sDate;
    }

    /**
     * 获得年月日的时间数据：2017年10月27日
     * @param date
     * @return
     */

    public static String getDateStr(Date date){
        String str = formatDate(date);
        String[] re = str.split("-");
        return re[0] + "年" + re[1] + "月" + re[2] + "日";
    }

    /**
     * 获取当年的第一天
     * @return
     */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     * @return
     */
    public static Date getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 获取本月第一天日期
     * @return Date
     */
    public static Date getMonthFirst(){
        Calendar calendar  =   new GregorianCalendar();
        calendar.set( Calendar.DATE,  1 );
        return calendar.getTime();
    }

    /**
     * 获取本月最后一天日期
     * @return Date
     */
    public static Date getMonthLast(){
        Calendar calendar  =   new  GregorianCalendar();
        calendar.set( Calendar.DATE,  1 );
        calendar.roll(Calendar.DATE,  - 1 );
        return calendar.getTime();
    }

    /**
     * 两个时间差是否大于目标书
     * @return
     */
    public static Boolean getIsMin(Date dateStart, Date dateEnd, int num){
//        System.out.println((dateEnd.getTime() - dateStart.getTime())/60000);
        if(dateStart == null || dateEnd == null){
            return false;
        }
        return dateEnd.getTime() - dateStart.getTime() > (num * 60000);       //
    }

    /**
     * 判断第一个日期是否大于第二个日志
     * @param date1
     * @param date2
     * @return
     */
    public static Boolean isMax(Date date1, Date date2){
        if(date1 == null || date2 == null){
            return false;
        }
        return date1.getTime() - date2.getTime() > 0;
    }

    // String类型转date
    public static Date string2Date(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        return null;
    }
    // Date类型转String
    public static String date2String(Date date, String pattern) {
        if(date==null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static Date getDate(String str){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟

        try{
            return sdf.parse(str);
        }catch (Exception exception){
            return null;
        }
    }
}
