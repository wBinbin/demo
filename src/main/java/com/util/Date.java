package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date extends java.util.Date {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7687268686821931497L;

	/**
	 * yyyy-MM
	 */
	public static final String YYYY_MM = "yyyy-MM";
	/**
	 * yyyy-MM-dd
	 */
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	/**
	 * yyyyMMdd
	 */
	public static final String YYYYMMDD = "yyyyMMdd";
	/**
	 * yyyy-MM-dd hh:mm:ss
	 */
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyyMMddhhmmss
	 */
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	/**
	 * yyyy-MM-dd
	 */
	public static final String HHMMSS = "HHmmss";

	public final String dateToStr(String pattern) {
		String dateStr = "";
		if (pattern == null || pattern.isEmpty()) {
			pattern = YYYY_MM_DD_HH_MM_SS;
		}
		if (this != null) {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			dateStr = format.format(this);
		}
		return dateStr;
	}

	public final Calendar dateToCal() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this);
		return this == null ? null : cal;
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.dateToCal());
	}

}
