package com.lgq.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	//将日期转化为字符串
	public static String getFormatDate(Date date, String formatType) {
		if(StringUtils.isNullOrEmpty(formatType)) {
			formatType = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat format = new SimpleDateFormat(formatType);
		return format.format(date);
	}
	
	//获取当前时间字符串
	public static String currentDate() {
		return getFormatDate(new Date(), null);
	}
}
