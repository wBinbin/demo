package com.mine.jvm.classloading;

public class ConstantClass {
	
	static {
		System.out.println("Constant class");
	}
	
	public static final String value = "--";

}
