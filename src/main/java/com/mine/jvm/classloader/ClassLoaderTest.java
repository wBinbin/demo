package com.mine.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		
//		ClassLoader myLoader = new ClassLoader() {
//
//			@Override
//			public Class<?> loadClass(String name) throws ClassNotFoundException {
//				try {
//
//					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
//					
//					InputStream in = getClass().getResourceAsStream(fileName);
//
//					if (in == null) {
//						return super.loadClass(name);
//					}
//
//					byte[] b = new byte[in.available()];
//					in.read(b);
//					return defineClass(name, b, 0, b.length);
//				} catch (IOException e) {
//					throw new ClassNotFoundException(name);
//				}
//			}
//
//		};
//		
//		Object o1 = myLoader.loadClass("com.mine.jvm.classloader.ClassLoaderTest").newInstance();
//		System.out.println(o1.getClass());
//		System.out.println(o1 instanceof ClassLoaderTest);
		
		
		
		
		String str = System.getProperty("sun.boot.class.path");
		String[] arr = str.split(";");
		for (String a : arr) {
			System.out.println(a);
			
		}
		
	}

}
