package com.ebees.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	
	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String US_DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";

	public static void main(String args[]) {
		String dateStr = "2017-06-26 21:03:10.0";
		try {
			System.out.println(formatDateTime(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static String formatDateTime(String dateStr) throws ParseException {
		Date date = new SimpleDateFormat(DATE_TIME_FORMAT).parse(dateStr);
		System.out.println(date);
		return new SimpleDateFormat(US_DATE_TIME_FORMAT).format(date);
	}
}
