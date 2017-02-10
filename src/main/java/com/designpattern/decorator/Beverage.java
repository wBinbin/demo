package com.designpattern.decorator;

/**
 * 
 * <p>
 * 描述：装饰器模式，超类，饮料
 * </p>
 *
 * @Author patrick
 * @Date 2017年2月8日
 *
 */
public abstract class Beverage {

	public String description = "Unknown Beverage";

	public abstract String getDescription();

	public abstract double cost();

}
