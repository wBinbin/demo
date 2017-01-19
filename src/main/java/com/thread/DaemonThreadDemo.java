package com.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * <p>
 * 描述：守护线程，当JVM中存在任何一个非守护线程没有结束，守护线程仍然工作；只有当最后一个非守护线程结束时，守护线程随JVM一起结束。文件中没有“
 * daemon”原因：直到主线程完成时，守护线程仍然处于1秒的阻塞状态，这个时候主线程完成虚拟机退出，Daemon停止服务，输出失败
 * </p>
 *
 * @Author patrick
 * @Date 2017年1月19日
 *
 */
public class DaemonThreadDemo {

	public static void main(String[] args) {
		Thread r = new Thread(new ThreadA());
		r.setDaemon(true);
		r.start();
	}

}

class ThreadA implements Runnable {

	@Override
	public void run() {
		OutputStream o = null;
		try {
			Thread.sleep(1000);
			System.out.println("开始写数据");

			File f = new File("D:\\daemon.txt");
			o = new FileOutputStream(f);
			o.write("daemon".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (o != null) {
				try {
					o.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
