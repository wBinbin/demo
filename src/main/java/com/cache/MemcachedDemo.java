//package com.cache;
//
//import com.whalin.MemCached.MemCachedClient;
//import com.whalin.MemCached.SockIOPool;
//
//public class MemcachedDemo {
//
//	private static MemCachedClient memCachedClient = null;
//
//	static {
////		String[] servers = { "123.59.65.113:11211", "127.0.0.1:9211" };
////		 String[] servers = { "123.59.65.113:11211" };
//		 String[] servers = { "127.0.0.1:9211" };
//
//		// 获取socket连接池的实例对象
//		SockIOPool pool = SockIOPool.getInstance();
//
//		// 设置服务器信息
//		pool.setServers(servers);
//
//		// 设置初始连接数
//		pool.setInitConn(5);
//		// 最小和最大连接数
//		pool.setMinConn(5);
//		pool.setMaxConn(250);
//		// 最大处理时间
//		pool.setMaxIdle(1000 * 60 * 60 * 6);
//
//		// 设置主线程的睡眠时间
//		pool.setMaintSleep(30);
//
//		// 设置TCP的参数，连接超时等
//		pool.setNagle(false);
//		pool.setSocketTO(3000);
//		pool.setSocketConnectTO(0);
//
//		// 初始化连接池
//		pool.initialize();
//
//		memCachedClient = new MemCachedClient();
//	}
//
//	public static void main(String[] args) {
////		System.out.println(memCachedClient.set("wbinbin", "这是在测试"));
////		
////		System.out.println(memCachedClient.get("wbinbin"));
//		
//	}
//
//}