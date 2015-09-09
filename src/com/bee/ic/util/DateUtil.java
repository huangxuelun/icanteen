/***************************************************** 
 * 
 * Copyright:
 *  Copyright 2009 - 2010 © 版权所有：
 *  成都晟峰软件有限公司
 * License:
 *
 * Created By Time:
 *       2009-7-24 上午10:52:26
 *****************************************************/
package com.bee.ic.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Date Utility Class This is used to convert Strings to Dates and Timestamps
 * 封装一些常用的Date方法
 * 
 * @author Blood Lee
 * @email : liguorui@cdsafe.com.cn
 * @version 1.0
 */
public class DateUtil {

	/** 格式化形式：yyyy-MM-dd */
	public static final String DATE_PATTERN_YYYYMMDD1 = "yyyy-MM-dd";
	/** 格式化形式：yyyy/MM/dd */
	public static final String DATE_PATTERN_YYYYMMDD2 = "yyyy/MM/dd";
	/** 格式化形式：yyyy年MM月dd日 */
	public static final String DATE_PATTERN_YYYYMMDD3 = "yyyy年MM月dd日";
	
	/** 格式化形式：yyyy年MM月dd日 */
	public static final String DATE_PATTERN_YYYYMMDD4 = "MM月dd日 HH时mm分";
	/** 格式化形式：M月d号 */
	public static final String DATE_PATTERN_MD = "M月d号";
	/** 格式化形式：yyyyMMdd */
	public static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";
	/** 格式化形式：yyyy-MM-dd HH:MM:SS */
	public static final String DATE_PATTERN_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	/** 格式化形式：yyyy-MM-dd HH:MM */
	public static final String DATE_PATTERN_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

	/**
	 * 获取当前字符串类型时间
	 * 
	 * @param pattern
	 * @return
	 */
	public static String nowStringDate(String pattern) {
		return dateToString(new Date(), pattern);
	}

	/**
	 * 获取当前日期格式的时间
	 * 
	 * @param pattern
	 * @return
	 */
	public static Date nowDate(String pattern) {
		String nowStringDate = nowStringDate(pattern);
		return stringToDate(nowStringDate, pattern);
	}

	/**
	 * 格式化时间为字符串
	 * 
	 * @param date
	 * @param pattern
	 *            yyyy-MM-dd
	 * @param locale
	 *            时区
	 * @return
	 */
	public static String dateToString(Date date, String pattern, Locale locale) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
			return sdf.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 格式化时间为字符串
	 * 
	 * @param date
	 * @param pattern
	 *            yyyy-MM-dd HH:mm
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 格式化字符型时间为长整型
	 * 
	 * @param strDate
	 * @param pattern
	 *            yyyy-MM-dd
	 * @param locale
	 * @return
	 * @throws ParseException
	 */
	public static long stringToLong(String strDate, String pattern,
			Locale locale) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
		Date date = sdf.parse(strDate);
		return date.getTime();
	}

	/**
	 * 格式化字符型时间为长整型
	 * 
	 * @param strDate
	 * @param pattern
	 *            yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static long stringToLong(String strDate, String pattern)
			throws ParseException {
		Locale locale = Locale.CHINESE;
		return stringToLong(strDate, pattern, locale);
	}

	/**
	 * 格式化字符型为Date型
	 * 
	 * @param strDate
	 * @param pattern
	 *            yyyy-MM-dd
	 * @return
	 */
	public static Date stringToDate(String strDate, String pattern) {
		try {
			long ltime = stringToLong(strDate, pattern);
			return new Date(ltime);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 格式化字符型为Date型
	 * 
	 * @param strDate
	 * @param pattern
	 *            yyyy-MM-dd
	 * @param otherPattern
	 * @return
	 */
	public static Date stringToDate(String strDate, String pattern,
			String otherPattern) {
		try {
			long ltime = stringToLong(strDate, pattern);
			return new Date(ltime);
		} catch (Exception ex) {
			try {
				long ltime = stringToLong(strDate, otherPattern);
				return new Date(ltime);
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 格式化时间
	 * 
	 * @param date
	 * @param pattern
	 *            yyyy-MM-dd
	 * @return
	 */
	public static Date formateDate(Date date, String pattern) {
		String s = dateToString(date, pattern);
		return stringToDate(s, pattern);
	}

	/**
	 * 星期的取得（Int）
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekInt(Date date) {

		Calendar date1 = Calendar.getInstance();

		// 设置日期
		date1.setTime(date);

		// 取星期
		int week = date1.get(Calendar.DAY_OF_WEEK) - 1;

		return week;
	}

	/**
	 * 获取某个时间的具体的某一天
	 * 
	 * @param date
	 * @return
	 */
	public static int getEmbodyDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int embodyDay = calendar.get(Calendar.DAY_OF_MONTH);
		return embodyDay;

	}

	/**
	 * 获取某个时间的具体的某一月
	 * 
	 * @param date
	 * @return
	 */
	public static int getEmbodyMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int embodyMonth = calendar.get(Calendar.MONTH) + 1;
		return embodyMonth;

	}

	/**
	 * 获取某个时间的具体的某一年
	 * 
	 * @param date
	 * @return
	 */
	public static int getEmbodyYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int embodyYear = calendar.get(Calendar.YEAR);
		return embodyYear;

	}

	/**
	 * 将给定的日期转换为指定格式的字符串,如果输入时间为null,那么返回""
	 * 
	 * @param startDate
	 * @return
	 */
	public static String getdate_dd(Date startDate) {
		String sDate = "";
		if (startDate != null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			sDate = format.format(startDate);
		}
		return sDate;
	}

	/**
	 * 返回当前日期-时间的字符串表达形式
	 * 
	 * @return
	 */
	public static String getCurrentDateString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS",
				Locale.US);
		return sdf.format(new Date());
	}

	/**
	 * 日期変換<BR>
	 * 
	 * @param _strDate
	 *            日付変換対象文字列
	 * @param _strDateFormat
	 * @return Date 変換後日付
	 */
	public static Date toDateType(String _strDate, String _strDateFormat) {

		Date dteRet_ = null;
		SimpleDateFormat sdfObject_ = null;

		try {

			// if (CommonFunction.isNull(_strDate)) {
			// return null;
			// }

			sdfObject_ = new SimpleDateFormat(_strDateFormat);

			dteRet_ = sdfObject_.parse(_strDate);

		} catch (Exception e) {
			dteRet_ = null;
		}

		return dteRet_;
	}

	/**
	 * 开始日星期日取得
	 * 
	 * @param BeginDate
	 * @return
	 */
	public static String getSunday(String beginDate, String pattern) {

		if (getWeekInt(toDateType(beginDate, pattern)) != 0) {

			GregorianCalendar Calendar = new GregorianCalendar();
			Calendar.setTime(toDateType(beginDate, pattern));
			switch (getWeekInt(toDateType(beginDate, pattern))) {
			case 1:
				Calendar.add(GregorianCalendar.DATE, -1);
				break;
			case 2:
				Calendar.add(GregorianCalendar.DATE, -2);
				break;
			case 3:
				Calendar.add(GregorianCalendar.DATE, -3);
				break;
			case 4:
				Calendar.add(GregorianCalendar.DATE, -4);
				break;
			case 5:
				Calendar.add(GregorianCalendar.DATE, -5);
				break;
			case 6:
				Calendar.add(GregorianCalendar.DATE, -6);
				break;
			default:
				break;
			}
			// 创建SimpleDateFormat
			SimpleDateFormat DateFormat = new SimpleDateFormat(pattern);
			// 获得开始日
			beginDate = DateFormat.format(Calendar.getTime());
		}

		return beginDate;
	}

	/**
	 * 开始日星期一取得
	 * 
	 * @param BeginDate
	 * @return
	 */
	public static String getPrevMondy(String beginDate, String pattern) {

		if (getWeekInt(toDateType(beginDate, pattern)) != 0) {

			GregorianCalendar Calendar = new GregorianCalendar();
			Calendar.setTime(toDateType(beginDate, pattern));
			switch (getWeekInt(toDateType(beginDate, pattern))) {
			case 1:
				Calendar.add(GregorianCalendar.DATE, -7);
				break;
			case 2:
				Calendar.add(GregorianCalendar.DATE, -1);
				break;
			case 3:
				Calendar.add(GregorianCalendar.DATE, -2);
				break;
			case 4:
				Calendar.add(GregorianCalendar.DATE, -3);
				break;
			case 5:
				Calendar.add(GregorianCalendar.DATE, -4);
				break;
			case 6:
				Calendar.add(GregorianCalendar.DATE, -5);
				break;
			case 7:
				Calendar.add(GregorianCalendar.DATE, -6);
				break;
			default:
				break;
			}
			// 创建SimpleDateFormat
			SimpleDateFormat DateFormat = new SimpleDateFormat(pattern);
			// 获得开始日
			beginDate = DateFormat.format(Calendar.getTime());
		}

		return beginDate;
	}

	/**
	 * 前一个星期一取得
	 * 
	 * @param BeginDate
	 * @return
	 */
	public static Date getPrevMondy(Date beginDate) {

		GregorianCalendar Calendar = new GregorianCalendar();
		Calendar.setTime(beginDate);
		switch (getWeekInt(beginDate)) {
		case 1:
			Calendar.add(GregorianCalendar.DATE, -7);
			break;
		case 2:
			Calendar.add(GregorianCalendar.DATE, -1);
			break;
		case 3:
			Calendar.add(GregorianCalendar.DATE, -2);
			break;
		case 4:
			Calendar.add(GregorianCalendar.DATE, -3);
			break;
		case 5:
			Calendar.add(GregorianCalendar.DATE, -4);
			break;
		case 6:
			Calendar.add(GregorianCalendar.DATE, -5);
			break;
		case 0:
			Calendar.add(GregorianCalendar.DATE, -6);
			break;
		default:
			break;
		}
		beginDate = Calendar.getTime();
		return beginDate;
	}

	/**
	 * 下一个星期一取得
	 * 
	 * @param BeginDate
	 * @return
	 */
	public static String getNextMondy(String beginDate, String pattern) {

		if (getWeekInt(toDateType(beginDate, pattern)) != 0) {

			GregorianCalendar Calendar = new GregorianCalendar();
			Calendar.setTime(toDateType(beginDate, pattern));
			switch (getWeekInt(toDateType(beginDate, pattern))) {
			case 2:
				Calendar.add(GregorianCalendar.DATE, 6);
				break;
			case 3:
				Calendar.add(GregorianCalendar.DATE, 5);
				break;
			case 4:
				Calendar.add(GregorianCalendar.DATE, 4);
				break;
			case 5:
				Calendar.add(GregorianCalendar.DATE, 3);
				break;
			case 6:
				Calendar.add(GregorianCalendar.DATE, 2);
				break;
			case 7:
				Calendar.add(GregorianCalendar.DATE, 1);
				break;
			default:
				break;
			}
			// 创建SimpleDateFormat
			SimpleDateFormat DateFormat = new SimpleDateFormat(pattern);
			// 获得开始日
			beginDate = DateFormat.format(Calendar.getTime());
		}

		return beginDate;
	}

	/**
	 * 下一个星期天取得
	 * 
	 * @param BeginDate
	 * @return
	 */
	public static String getNextSunday(String beginDate, String pattern) {

		if (getWeekInt(toDateType(beginDate, pattern)) != 0) {

			GregorianCalendar Calendar = new GregorianCalendar();
			Calendar.setTime(toDateType(beginDate, pattern));
			switch (getWeekInt(toDateType(beginDate, pattern))) {
			case 1:
				Calendar.add(GregorianCalendar.DATE, 6);
				break;
			case 2:
				Calendar.add(GregorianCalendar.DATE, 5);
				break;
			case 3:
				Calendar.add(GregorianCalendar.DATE, 4);
				break;
			case 4:
				Calendar.add(GregorianCalendar.DATE, 3);
				break;
			case 5:
				Calendar.add(GregorianCalendar.DATE, 2);
				break;
			case 6:
				Calendar.add(GregorianCalendar.DATE, 1);
				break;
			default:
				break;
			}
			// 创建SimpleDateFormat
			SimpleDateFormat DateFormat = new SimpleDateFormat(pattern);
			// 获得开始日
			beginDate = DateFormat.format(Calendar.getTime());
		}

		return beginDate;
	}

	/**
	 * 下一个星期天取得
	 * 
	 * @param BeginDate
	 * @return
	 */
	public static Date getNextSunday(Date beginDate) {

		if (getWeekInt(beginDate) != 0) {

			GregorianCalendar Calendar = new GregorianCalendar();
			Calendar.setTime(beginDate);
			switch (getWeekInt(beginDate)) {
			case 1:
				Calendar.add(GregorianCalendar.DATE, 6);
				break;
			case 2:
				Calendar.add(GregorianCalendar.DATE, 5);
				break;
			case 3:
				Calendar.add(GregorianCalendar.DATE, 4);
				break;
			case 4:
				Calendar.add(GregorianCalendar.DATE, 3);
				break;
			case 5:
				Calendar.add(GregorianCalendar.DATE, 2);
				break;
			case 6:
				Calendar.add(GregorianCalendar.DATE, 1);
				break;
			default:
				break;
			}
			// 获得开始日
			beginDate = Calendar.getTime();
		}

		return beginDate;
	}

	/**
	 * 取得指定月份的第一天
	 * 
	 * @param strdate
	 *            String
	 * @return String
	 */
	public static String getMonthBegin(String strdate, String pattern) {
		Date date = stringToDate(strdate, pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();

		return format(date, pattern);
	}
	
	/**
	 * 取得指定月份的第一天
	 * 
	 * @param date
	 *            Date
	 * @param pattern
	 *            String
	 * @return String
	 */
	public static String getMonthBegin(Date date,String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		return format(date, pattern);
	}
	
	/**
	 * 取得下一个月的第一天
	 * 
	 * @param date
	 *            Date
	 * @param pattern
	 *            String
	 * @return String
	 */
	public static String getNextMonthBegin(Date date,String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH,1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		return format(date, pattern);
	}

	/**
	 * 取得指定月份的最后一天
	 * 
	 * @param strdate
	 *            String
	 * @return String
	 */
	public static String getMonthEnd(String strdate, String pattern) {
		Date date = stringToDate(strdate, pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		date = addMonth(date, 1);
		date = addDays(date, -1);
		return format(date, pattern);
	}

	/**
	 * 取得指定月份的最大天数
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return 返回指定月份的最大天数
	 */
	public static int getMonthDay(String year, String month) {
		String strDate = getYYYYMMDD(year, month, "1",
				DateUtil.DATE_PATTERN_YYYYMMDD);
		Date date = stringToDate(strDate, DateUtil.DATE_PATTERN_YYYYMMDD);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		date = addMonth(date, 1);
		date = addDays(date, -1);
		return getDayInt(date);
	}

	/**
	 * 月份中文名称转换函数
	 * 
	 * @param months
	 *            String
	 * @return String
	 */
	public static String getMonthChineseName(String months) {
		String monthsChinese = "";
		String[] newMonths = months.split(",");
		for (int i = 0; i < newMonths.length; i++) {
			if ("01".equals(newMonths[i]) || "1".equals(newMonths[i])) {
				newMonths[i] = "1月";
			}
			if ("02".equals(newMonths[i]) || "2".equals(newMonths[i])) {
				newMonths[i] = "2月";
			}
			if ("03".equals(newMonths[i]) || "3".equals(newMonths[i])) {
				newMonths[i] = "3月";
			}
			if ("04".equals(newMonths[i]) || "4".equals(newMonths[i])) {
				newMonths[i] = "4月";
			}
			if ("05".equals(newMonths[i]) || "5".equals(newMonths[i])) {
				newMonths[i] = "5月";
			}
			if ("06".equals(newMonths[i]) || "6".equals(newMonths[i])) {
				newMonths[i] = "6月";
			}
			if ("07".equals(newMonths[i]) || "7".equals(newMonths[i])) {
				newMonths[i] = "7月";
			}
			if ("08".equals(newMonths[i]) || "8".equals(newMonths[i])) {
				newMonths[i] = "8月";
			}
			if ("09".equals(newMonths[i]) || "9".equals(newMonths[i])) {
				newMonths[i] = "9月";
			}
			if ("10".equals(newMonths[i])) {
				newMonths[i] = "10月";
			}
			if ("11".equals(newMonths[i])) {
				newMonths[i] = "11月";
			}
			if ("12".equals(newMonths[i])) {
				newMonths[i] = "12月";
			}
		}
		for (int i = 0; i < newMonths.length; i++) {
			if (i == 0) {
				monthsChinese = newMonths[i];
			} else {
				monthsChinese = monthsChinese + "," + newMonths[i];
			}
		}
		return monthsChinese;
	}

	/**
	 * 日的取得（Int）
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayInt(Date date) {

		Calendar date1 = Calendar.getInstance();

		// 设置日期
		date1.setTime(date);

		// 取号数
		int day = date1.get(Calendar.DAY_OF_MONTH);

		return day;
	}

	/**
	 * 日期月份加减计算方法
	 * 
	 * @param _date
	 *            日期
	 * @param month
	 *            加减月份
	 * @return Date 计算结果
	 */
	public static Date addMonth(Date _date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}

	/**
	 * 日期日的加减计算方法
	 * 
	 * @param _date
	 *            日期
	 * @param day
	 *            加减天数
	 * @return Date 计算结果
	 */
	public static Date addDays(Date _date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}

	/**
	 * 日期分钟的加减计算方法
	 * 
	 * @param _date
	 *            日期
	 * @param minutes
	 *            加减分钟
	 * @return Date 计算结果
	 */
	public static Date addMinutes(Date _date, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	/**
	 * 日期的小时加减计算方法
	 * 
	 * @param _date
	 * @param hour
	 * @return
	 */
	public static Date addHours(Date _date, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.add(Calendar.HOUR, hour);
		return cal.getTime();
	}

	/**
	 * 返回YYYYMMDD格式的日期字符串
	 * 
	 * @param _yaer
	 *            年
	 * @param _months
	 *            月
	 * @param _day
	 *            日
	 * @return 日期字符串
	 */
	public static String getYYYYMMDD(String _yaer, String _months, String _day,
			String _pattern) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(_yaer));
		cal.set(Calendar.MONTH, Integer.parseInt(_months) - 1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(_day));
		Date date = cal.getTime();

		return format(date, _pattern);
	}

	/**
	 * 日期格式化方法
	 * 
	 * @param _dte
	 *            日期
	 * @param _pattern
	 *            格式化形式
	 * @return 格式化后的日期字符串
	 */
	public static String format(Date _dte, String _pattern) {
		String result = "";
		try {
			if (_dte != null) {
				DateFormat df = new SimpleDateFormat(_pattern);
				result = df.format(_dte);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 判断时间date1是否在时间date2之前 时间格式 2005-4-21 16:16:34
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isDateBefore(String date1, String date2) {
		try {
			DateFormat df = DateFormat.getDateTimeInstance();
			return df.parse(date1).before(df.parse(date2));
		} catch (ParseException e) {
			System.out.print("[SYS] " + e.getMessage());
			return false;
		}
	}

	/**
	 * 判断当前时间是否在时间date2之前 时间格式 2005-4-21 16:16:34
	 * 
	 * @param date2
	 * @return
	 */
	public static boolean isDateBefore(String date2) {
		try {
			Date date1 = new Date();
			DateFormat df = DateFormat.getDateTimeInstance();
			return date1.before(df.parse(date2));
		} catch (ParseException e) {
			System.out.print("[SYS] " + e.getMessage());
			return false;
		}
	}

}