package com.util;

import java.math.BigDecimal;

public final class NumberUtil {

	private NumberUtil() {
		throw new RuntimeException("禁止实例化");
	}

	/**
	 * 字符串转Decimal
	 * 
	 * @param Str
	 * @return
	 */
	public static BigDecimal strToDecimal(String Str) {
		if (Str == null)
			return BigDecimal.valueOf(0);
		BigDecimal bd = new BigDecimal(Str);
		// 设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入)
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * double相加
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Double add(Double... d) {
		BigDecimal d_ = new BigDecimal(0.00);
		if (d != null) {
			for (Double b : d) {
				if (b == null) {
					b = 0.00;
				}
				d_ = d_.add(new BigDecimal(b));
			}
		}
		return d_.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

//	/**
//	 * 多个double相加
//	 * 
//	 * @param d1
//	 * @param d2
//	 * @return
//	 */
//	public static Double add(Double[] ds) {
//		BigDecimal b1 = new BigDecimal(0.00);
//		for (Double d : ds) {
//			if (d == null) {
//				d = 0.00;
//			}
//			b1 = b1.add(new BigDecimal(d));
//		}
//		return b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//	}

	/**
	 * double相减， 可多个减，d - d_[0] - d_[1] - d_[2] - d_[...]
	 * 
	 * @param d
	 * @param d_
	 * @return
	 */
	public static Double sub(Double d, Double... d_) {
//		if (d == null) {
//			d = 0.0;
//		}
//		if (d_ == null) {
//			d_ = 0.0;
//		}
//		BigDecimal b1 = new BigDecimal(d);
//		BigDecimal b2 = new BigDecimal(d_);
//		return b1.subtract(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		BigDecimal a = new BigDecimal(d);
		if (d_ != null) {
			for (Double b : d_) {
				if (b == null) {
					b = 0.00;
				}
				a = a.subtract(new BigDecimal(b));
			}
		}
		return a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

//	/**
//	 * 多个double相减，A-B-C-D
//	 * 
//	 * @param ds
//	 *            ds[0]=A，ds[1]=B，ds[2]=C，ds[3]=D，......
//	 * @return
//	 */
//	public static Double sub(Double[] ds) {
//		BigDecimal b1 = new BigDecimal(ds[0]);
//		BigDecimal b2 = null;
//		for (int i = 1; i < ds.length; i++) {
//			Double d = ds[i];
//			if (d == null) {
//				d = 0.00;
//			}
//			b2 = new BigDecimal(d);
//			b1 = b1.subtract(b2);
//		}
//		return b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//	}
	
	/**
	 * double相乘
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Double multiply(Double d1, Double d2) {
		if (d1 == null) {
			d1 = 0.0;
		}
		if (d2 == null) {
			d2 = 0.0;
		}
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.multiply(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 两个数相除
	 * 
	 * @param d1
	 * @param d2
	 * @param scale
	 *            小数位数
	 * @return
	 */
	public static Double divide(Double d1, Double d2) {
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
