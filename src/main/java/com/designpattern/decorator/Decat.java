package com.designpattern.decorator;

/**
 * 
 * <p>
 * 描述：被装饰者饮料
 * </p>
 *
 * @Author patrick
 * @Date 2017年2月8日
 *
 */
public class Decat extends Beverage {

	public Decat () {
		description = "Decat";
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double cost() {
		return 2.45;
	}

}
