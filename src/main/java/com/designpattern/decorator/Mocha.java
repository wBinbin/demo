package com.designpattern.decorator;

/**
 * 
 * <p>
 * 描述：调料类，摩卡
 * </p>
 *
 * @Author patrick
 * @Date 2017年2月8日
 *
 */
public class Mocha extends DondimentDecorator {
	
	private Beverage beverage;
	
	public Mocha (Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " + Mocha";
	}

	@Override
	public double cost() {
		return beverage.cost() + 1.0;
	}

}
