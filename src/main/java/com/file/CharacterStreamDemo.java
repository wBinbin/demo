package com.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * <p>
 * 描述：字符流
 * </p>
 *
 * @Author patrick
 * @Date 2017年2月8日
 *
 */
public class CharacterStreamDemo {

	/**
	 * 读取并输出一个文本文件的每一行
	 * 
	 * @param file
	 */
	private static void readAndPrintEachLine(File file) {
		BufferedReader reader = null;
		try {
			String line = null;
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 向文件里面写入数据
	 * <p>
	 * 字节流没有缓冲区，是直接输出的，而字符流是输出到缓冲区的。因此在输出时，字节流不调用colse()方法时，信息已经输出了，
	 * 而字符流只有在调用close()方法关闭缓冲区时，信息才输出。要想字符流在未关闭时输出信息，则需要手动调用flush()方法。
	 * </p>
	 * 
	 * @param file
	 */
	private static void readAndWrite(File file) {

		// 方式一
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(file, true)); // true=向文件追加内容
			for (int i = 0; i < 5; i++) {
				writer.println("i = " + i);
				writer.flush(); // 字符流，输出，每一行的数据需要flush才会输出，否则等close时全部输出
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

		// // 方式二
		// BufferedWriter writer = null;
		// try {
		// writer = new BufferedWriter(new FileWriter(file, true));
		// for (int i = 0; i < 5; i++) {
		// writer.write("i = " + i);
		// writer.newLine();
		// writer.flush();
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// if (writer != null) {
		// try {
		// writer.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// }
	}

	public static void main(String[] args) {
		String pathName = "D:\\readme.txt";

		File file = new File(pathName);

		// 读取并输出一个文本文件的每一行
		// readAndPrintEachLine(file);

		// 读取一个文件，并写入几行数据
		readAndWrite(file);
	}

}
