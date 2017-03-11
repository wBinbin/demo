package com.cache;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class XMemcachedDemo {

	public static void main(String[] args) {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("123.59.65.113:11211"));
		MemcachedClient client;
		try {
			client = builder.build();
			System.out.println(client.get("wbinbin"));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}

}
