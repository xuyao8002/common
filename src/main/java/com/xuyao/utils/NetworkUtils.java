package com.xuyao.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkUtils {

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
