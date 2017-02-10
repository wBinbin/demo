package com.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
	
	public static void main(String[] args) {
		/*File 
			文件类
		RandomAccessFile
			随机存取文件类
		InputStream
			字节输入流
		OutputStream
			字节输出流
		Reader
			字符输出流
		Writer
			字符输入流*/
		
		String line = null;
		System.out.print("$ ");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);
		try {
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				System.out.print("$ ");
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}	

}
