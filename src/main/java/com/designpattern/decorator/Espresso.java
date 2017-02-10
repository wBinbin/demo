package com.designpattern.decorator;

/**
 * 
 * <p>
 * 描述：被装饰者饮料，意大利浓咖啡
 * </p>
 *
 * @Author patrick
 * @Date 2017年2月8日
 *
 */
public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso";
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double cost() {
		return 1.99;
	}

}
