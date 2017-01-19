package com.mine.jdk8;

public interface InterfaceDemo {

	double cal(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}

}

@FunctionalInterface
interface Converter<F, T> {
	T convert(F from);
}
