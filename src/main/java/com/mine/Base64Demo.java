package com.mine;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class Base64Demo {
	
	/**
	 * 解密
	 * 
	 * @param key
	 * @return
	 */
	public static String getFromBase64(String key) {
		byte[] b = null;
		String result = null;
		if (key != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(key);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 加密
	public static String getBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}
	
	public static void main(String[] args) {
//		String s = "[\"admin\",\"admin\"]";
//		System.out.println(getBase64(s));
		
		
//		int[] elementData = new int[] { 0, 1, 2, 3, 4 };
//		int index = 2;
//		int numMoved = elementData.length - index - 1;
//
//		System.arraycopy(elementData, 3, elementData, 2, 1);
//		
//		
//		// 0, 1, 2, 3, 4
//		// 0, 1, 3, 4, 4
//		System.out.println();
		
		String a = "123456";
		System.out.println(a.compareTo("112"));
		
	}

}
