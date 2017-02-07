package com.file;

import java.io.File;

/**
 * 
 * <p>
 * 描述：删除文件夹中所有匹配到的文件
 * </p>
 *
 * @Author patrick
 * @Date 2017年1月20日
 *
 */
public class DeleteFileDemo {

	public static void main(String[] args) {
		String path = "D:\\workspace\\in_order_V5\\src\\main\\java\\com";
		findAndDelete(path);
	}

	private static void findAndDelete(String path) {
		File file = new File(path);
		findAndDelete(file, ".class");
	}

	/**
	 * 根据文件格式遍历匹配查找到文件并删除
	 * 
	 * @param file
	 * @param fileFormat
	 */
	private static void findAndDelete(File file, String fileFormat) {
		try {
			for (File f : file.listFiles()) {
				if (f.isDirectory()) {
					findAndDelete(f, fileFormat);
				} else {
					if (f.getName().endsWith(fileFormat)) {
						System.out.println(f.getName() + " -> " + f.delete());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
