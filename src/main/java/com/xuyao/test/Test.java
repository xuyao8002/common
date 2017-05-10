package com.xuyao.test;

import com.xuyao.utils.NetworkUtils;

public class Test {

	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 9092;
		int timeout = 5000;
		long b = System.currentTimeMillis();
		System.out.println(NetworkUtils.isHostConnectable(host, port, timeout));
		long a = System.currentTimeMillis();
		System.out.println(a-b);
		
		b = System.currentTimeMillis();
		System.out.println(NetworkUtils.isHostReachable(host, timeout));
		a = System.currentTimeMillis();
		System.out.println(a-b);
	}

}
