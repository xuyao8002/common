package com.xuyao.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkUtils {

	/**
	 * 指定ip、port是否可连接，等同于telnet
	 * @param host
	 * @param port
	 * @param timeout
     * @return
     */
	public static boolean isHostConnectable(String host, int port, int timeout) {
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(host, port), timeout);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * 指定ip是否可到达，等同于ping
	 * @param host
	 * @param timeout
     * @return
     */
	public static boolean isHostReachable(String host, Integer timeout) {
		try {
			return InetAddress.getByName(host).isReachable(timeout);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
