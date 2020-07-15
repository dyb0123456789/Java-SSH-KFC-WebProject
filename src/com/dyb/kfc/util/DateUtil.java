package com.dyb.kfc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Title: DateUtil
 *
 * Description: 时间处理工具类
 *
 *
 */
public class DateUtil {
	/**
	 * 
	 * @param date    util包下的时间
	 * @param pattern 时间格式
	 * @return Date转为字符串
	 */
	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
}
