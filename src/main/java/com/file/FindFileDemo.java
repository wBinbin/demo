package com.file;

import java.io.File;
import java.util.Calendar;

import com.util.TimeUtil;

/**
 * 
 * <p>
 * 描述：查找文件夹中所有的文件
 * </p>
 *
 * @Author patrick
 * @Date 2017年1月20日
 *
 */
public class FindFileDemo {

	public static void main(String[] args) {
		File file = new File("D:\\workspace\\in_order\\src\\main\\java");
		find(file);
	}

	private static void find(File file) {
		try {
			for (File f : file.listFiles()) {
				if (f.isDirectory()) {
					find(f);
				} else {
					Calendar modified = Calendar.getInstance();
					modified.setTimeInMillis(f.lastModified());

					Calendar limit = TimeUtil.strToCal("2016-01-19 00:00:00", TimeUtil.YYYY_MM_DD_HH_MM_SS);

					if (modified.after(limit)) {
						System.out.println(f.getName() + " -> " + TimeUtil.calToStr(modified, TimeUtil.YYYY_MM_DD_HH_MM_SS));

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
