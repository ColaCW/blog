package com.lgq.common.util;

import com.lgq.common.exception.ServiceBizException;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	// 判断字符串是否为空
	public static boolean isEmpty(String str) {
		if (!"".equals(str) && str != null && str.length() > 0) {
			return false;
		}
		return true;
	}

	// 判断List是否为空
	public static boolean isEmpty(List<?> list) {
		if (list != null && list.size() > 0) {
			return false;
		}
		return true;
	}

	//获取Integer
	public static int getInteger(String string, int defualt) {
		if(!StringUtils.isEmpty(string)) {
			return Integer.parseInt(string);
		}
		return defualt;
	}
	
	//获取String
	public static String getString(String string, String defualt) {
		if(!StringUtils.isEmpty(string)) {
			return string;
		}
		return defualt;
	}
	
	// 生成32位uuid
	public static String getId() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24);
		return temp;
	}

	// 获取随机字符串
	public static String getRandNumber(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	// 下划线转驼峰
	public static String lineToHump(String str) {
		if (isEmpty(str)) {
			return "";
		}
		Pattern humpPattern = Pattern.compile("[A-Z]");
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	public static boolean isNullOrEmpty(Object obj) {
		return null == obj || "".equals(obj) || "\"\"".equals(obj);
	}

	public static <T> List<T> convertStrToArray(String str, String split, Class<T> returnClass) {
		if (isNullOrEmpty(str)) {
			return Collections.emptyList();
		} else {
			try {
				String[] splitArray = str.split(split);
				List<T> returnList = new ArrayList();

				for(int i = 0; i < splitArray.length; ++i) {
					Constructor<T> constructor = returnClass.getConstructor(String.class);
					T instance = constructor.newInstance(splitArray[i]);
					returnList.add(instance);
				}

				return returnList;
			} catch (Exception var8) {
				throw new ServiceBizException(var8);
			}
		}
	}

	/**
	 * 首字母小写
	 * @param str
	 * @return
	 */
	public static String lowerFirstCase(String str){

		char[] chars = str.toCharArray();

		//首字母小写方法，大写会变成小写，如果小写首字母会消失
		chars[0] +=32;
		return String.valueOf(chars);

	}
}
