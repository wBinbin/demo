package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

	/**
	 * 值 yyyyMM
	 */
	public static final String YYYYMM = "yyyyMM";

	/**
	 * 值 yyyy-MM
	 */
	public static final String YYYY_MM = "yyyy-MM";

	/**
	 * 值 yyyy-MM-dd
	 */
	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	/**
	 * 值 yyyyMMdd
	 */
	public static final String YYYYMMDD = "yyyyMMdd";

	/**
	 * 值 yyyy-MM-dd hh:mm:ss
	 */
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 值 yyyyMMddhhmmss
	 */
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	/**
	 * 值 yyyy-MM-dd
	 */
	public static final String HHMMSS = "HHmmss";

	/**
	 * 时间转换,Date 转 Calendar
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar dateToCal(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * Calendar转字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String calToStr(Calendar date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dateStr = sdf.format(date.getTime());
		return dateStr;
	}

	/**
	 * 字符串转Calendar
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Calendar strToCal(String dateStr, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar calendar = null;
		if (dateStr != null && !"".equals(dateStr)) {
			try {
				calendar = Calendar.getInstance();
				Date date = sdf.parse(dateStr);
				calendar.setTime(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return calendar;
	}

	/**
	 * Date转Integer
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Integer dateToInt(Date date, String pattern) {
		if (date == null) {
			date = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dateStr = sdf.format(date);
		return Integer.parseInt(dateStr);
	}

	/**
	 * Date转字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToStr(Date date, String pattern) {
		if (date == null) {
			date = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dateStr = sdf.format(date);
		return dateStr;
	}

	/**
	 * 字符串转Date
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date strToDate(String dateStr, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		if (dateStr != null && !"".equals(dateStr)) {
			try {
				date = sdf.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	/**
	 * 获取当前日期/时间或日期时间,分不同的格式，如:yyyyMMdd、yyyy-MM-dd 如果sFormat为null将返回yyyy-MM-dd格式
	 * 调用示例：getCurrentDateTime("yyyy-MM-dd HH:mm:ss");
	 * 
	 * @param sFormat
	 *            期待返回的格式如下: yyyy-MM-dd yyy年MM月dd日 yyyy-MM-dd HH:mm:ss sss
	 *            yyyy年MM月dd日 HH时mm分ss秒 HH:mm:ss
	 *            时间格式中,大写HH表示为24小时制,小写hh表示为12小时制.
	 * @return 按sFormat返回的当前日期字符串
	 */
	public static String getCurrentDateTime(String sFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
		return sdf.format(new Date());
	}

	/**
	 * 取当年,如2015
	 * 
	 * @return 返回当前四位年份
	 */
	public static String getCurrentYear() {
		return getCurrentDateTime("yyyy");
	}

	/**
	 * 取当月份,如10
	 * 
	 * @return 返回当前二位月份
	 */
	public static String getCurrentMonth() {
		return getCurrentDateTime("MM");
	}

	/**
	 * 取当日,如10
	 * 
	 * @return 返回当前二位日期
	 */
	public static String getCurrentDay() {
		return getCurrentDateTime("dd");
	}

	/**
	 * 取当前时间
	 */
	public static String getCurrentHour() {
		return getCurrentDateTime("HH");
	}

	/**
	 * 获取当前星期
	 * 
	 * @return 当前星期,如一，二等.
	 */
	public static int getWeekDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return day;
	}

	/**
	 * 判断优惠券是否过期
	 * 
	 * @param useEndtime
	 * @return
	 */
	public static boolean checkOverdueDate(Date useEndtime) {
		if (useEndtime == null) {
			return false;
		}
		Calendar c1 = Calendar.getInstance();
		c1.setTime(useEndtime);
		Calendar c2 = Calendar.getInstance();
		return c1.before(c2);
	}

	/**
	 * 判断是否到使用期
	 * 
	 * @param useStarttime
	 * @return
	 */
	public static boolean checkNotdueDate(Date useStarttime) {
		if (useStarttime == null) {
			return false;
		}
		Calendar c1 = Calendar.getInstance();
		c1.setTime(useStarttime);
		Calendar c2 = Calendar.getInstance();
		return c1.after(c2);
	}

}
