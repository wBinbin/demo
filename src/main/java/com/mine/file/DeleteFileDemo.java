package com.mine.file;

import java.io.File;

public class DeleteFileDemo {

	public static void main(String[] args) {
		File file = new File("D:\\workspace\\in_order_V5\\src\\main\\java\\com");
		find(file);
	}

	private static void find(File file) {
		try {
			for (File f : file.listFiles()) {
				if (f.isDirectory()) {
					find(f);
				} else {
					if (f.getName().endsWith(".class")) {
						System.out.println(f.getName() + " -> " + f.delete());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
