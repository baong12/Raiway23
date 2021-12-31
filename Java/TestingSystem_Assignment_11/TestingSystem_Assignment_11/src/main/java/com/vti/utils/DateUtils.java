package com.vti.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static final String PARSE_EXC = "Lỗi không thể parse Date";
	public static final String mysqlDatePattern = "yyyy-MM-dd";

	public static Date getDate(String dateString, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			System.out.println(PARSE_EXC);
			e.printStackTrace();
		}
		return date;
	}
	
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}
}
