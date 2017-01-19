package com.mine.regex;

public class RegexDemo {

	public final static String DATE_7_REGEX = "[0-9]{4}-[0-9]{2}";
	public final static String DATE_10_REGEX = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
	public final static String DATE_18_REGEX = "[0-9]{4}-[0-9]{2}-[0-9]{2}\\s+";

	public static void main(String[] args) {
		String d1 = "2016-10";
		String d2 = "2016_10";

		String d3 = "2016-10-01";
		String d4 = "2016-10-01 ";

		String d5 = "2016-10-01 00:00:00";
		String d6 = "2016-10-01 00:00:00 ";

		System.out.println(checkDate(d1, DATE_7_REGEX));
		System.out.println(checkDate(d2, DATE_7_REGEX));
		System.out.println(checkDate(d3, DATE_7_REGEX));
		System.out.println(checkDate(d4, DATE_7_REGEX));
		System.out.println(checkDate(d5, DATE_7_REGEX));
		System.out.println(checkDate(d6, DATE_7_REGEX));

		System.out.println(checkDate(d1, DATE_10_REGEX));
		System.out.println(checkDate(d2, DATE_10_REGEX));
		System.out.println(checkDate(d3, DATE_10_REGEX));
		System.out.println(checkDate(d4, DATE_10_REGEX));
		System.out.println(checkDate(d5, DATE_10_REGEX));
		System.out.println(checkDate(d6, DATE_10_REGEX));

		System.out.println(checkDate(d1, DATE_7_REGEX));
		System.out.println(checkDate(d2, DATE_7_REGEX));
		System.out.println(checkDate(d3, DATE_7_REGEX));
		System.out.println(checkDate(d4, DATE_7_REGEX));
		System.out.println(checkDate(d5, DATE_7_REGEX));
		System.out.println(checkDate(d6, DATE_7_REGEX));
	}

	private static boolean checkDate(String date, String regex) {
		return date.matches(regex);
	}

}
