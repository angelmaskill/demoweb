package com.websocketpri.demo8;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import net.sf.json.JSONObject;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

public class WebSocketMessageInbound extends MessageInbound {

	private final String user;

	public WebSocketMessageInbound(String user) {
		this.user = user;
	}

	public String getUser() {
		return this.user;
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		// 触发连接事件，在连接池中添加连接
		JSONObject result = new JSONObject();
		result.element("type", "user_join");
		result.element("user", this.user);
		WebSocketMessageInboundPool.sendMessage(result.toString());

		result = new JSONObject();
		result.element("type", "get_online_user");
		result.element("list", WebSocketMessageInboundPool.getOnlineUser());
		WebSocketMessageInboundPool.addMessageInbound(this);
		WebSocketMessageInboundPool.sendMessageToUser(this.user, result.toString());
	}

	@Override
	protected void onClose(int status) {
		// 触发关闭事件，在连接池中移除连接
		WebSocketMessageInboundPool.removeMessageInbound(this);
		JSONObject result = new JSONObject();
		result.element("type", "user_leave");
		result.element("user", this.user);
		WebSocketMessageInboundPool.sendMessage(result.toString());
	}

	@Override
	protected void onBinaryMessage(ByteBuffer message) throws IOException {
		throw new UnsupportedOperationException("Binary message not supported.");
	}

	@Override
	protected void onTextMessage(CharBuffer message) throws IOException {
		WebSocketMessageInboundPool.sendMessage(message.toString());
	}
}
