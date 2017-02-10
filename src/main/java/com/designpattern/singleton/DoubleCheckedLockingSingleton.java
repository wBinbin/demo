package com.designpattern.singleton;

/**
 * 
 * <p>
 * 描述：双检索单例
 * </p>
 *
 * @Author patrick
 * @Date 2017年2月9日
 *
 */
public class DoubleCheckedLockingSingleton {

	private volatile DoubleCheckedLockingSingleton instance;

	private DoubleCheckedLockingSingleton() {
	}

	public DoubleCheckedLockingSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckedLockingSingleton.class) {
				// double checking
				if (instance == null) {
					instance = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return instance;
	}

}
