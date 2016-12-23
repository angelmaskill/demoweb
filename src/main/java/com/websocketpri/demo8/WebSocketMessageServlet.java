package com.websocketpri.demo8;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.websocket.StreamInbound;

@WebServlet(urlPatterns = { "/message" })
public class WebSocketMessageServlet extends org.apache.catalina.websocket.WebSocketServlet {

	private static final long serialVersionUID = 1L;

	public static int ONLINE_USER_COUNT = 1;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	public String getUser(HttpServletRequest request) {
		return (String) request.getSession().getAttribute("user");
	}

	@Override
	protected StreamInbound createWebSocketInbound(String subProtocol, HttpServletRequest request) {
		return new WebSocketMessageInbound(this.getUser(request));
	}
}
