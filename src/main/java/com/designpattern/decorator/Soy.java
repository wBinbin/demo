package com.designpattern.decorator;

/**
 * 
 * <p>
 * 描述：调料
 * </p>
 *
 * @Author patrick
 * @Date 2017年2月8日
 *
 */
public class Soy extends DondimentDecorator {
	
	private Beverage beverage;
	
	public Soy (Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " + Soy";
	}

	@Override
	public double cost() {
		return beverage.cost() + 2.0;
	}

}
