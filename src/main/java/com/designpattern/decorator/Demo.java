package com.designpattern.decorator;

/**
 * 
 * <p>
 * 描述：装饰器模式
 * </p>
 *
 * @Author patrick
 * @Date 2017年2月8日
 *
 */
public class Demo {

	public static void main(String[] args) {
		Beverage v1 = new Espresso();
		System.out.println(v1.getDescription() + " -> " + v1.cost());

		Beverage v2 = new Soy(new Mocha(new Espresso()));
		System.out.println(v2.getDescription() + " -> " + v2.cost());

		Beverage v3 = new Mocha(new Soy(new Espresso()));
		System.out.println(v3.getDescription() + " -> " + v3.cost());
	}

}
