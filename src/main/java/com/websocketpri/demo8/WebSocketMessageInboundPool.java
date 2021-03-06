package com.websocketpri.demo8;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WebSocketMessageInboundPool {

	private static final Map<String, WebSocketMessageInbound> connections = new HashMap<String, WebSocketMessageInbound>();

	public static void addMessageInbound(WebSocketMessageInbound inbound) {
		// 添加连接
		System.out.println("user : " + inbound.getUser() + " join..");
		connections.put(inbound.getUser(), inbound);
	}

	public static Set<String> getOnlineUser() {
		return connections.keySet();
	}

	public static void removeMessageInbound(WebSocketMessageInbound inbound) {
		// 移除连接
		System.out.println("user : " + inbound.getUser() + " exit..");
		connections.remove(inbound.getUser());
	}

	public static void sendMessageToUser(String user, String message) {
		try {
			// 向特定的用户发送数据
			System.out.println("send message to user : " + user + " ,message content : " + message);
			WebSocketMessageInbound inbound = connections.get(user);
			if (inbound != null) {
				inbound.getWsOutbound().writeTextMessage(CharBuffer.wrap(message));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void sendMessage(String message) {
		try {
			Set<String> keySet = connections.keySet();
			for (String key : keySet) {
				WebSocketMessageInbound inbound = connections.get(key);
				if (inbound != null) {
					System.out.println("send message to user : " + key + " ,message content : " + message);
					inbound.getWsOutbound().writeTextMessage(CharBuffer.wrap(message));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void sendMessageFilterUser(String message, String user) {
		try {
			Set<String> keySet = connections.keySet();
			for (String key : keySet) {
				WebSocketMessageInbound inbound = connections.get(key);
				if (inbound != null) {
					System.out.println("send message to user : " + key + " ,message content : " + message);
					inbound.getWsOutbound().writeTextMessage(CharBuffer.wrap(message));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
