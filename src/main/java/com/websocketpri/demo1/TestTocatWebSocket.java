package com.websocketpri.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

public class TestTocatWebSocket {

	public static void main(String[] args) throws URISyntaxException {

		String url = "ws://localhost:8080/demoweb/ws/chat/" + args[0];
		WebSocketClient wc = new WebSocketClient(new URI(url), new Draft_17()) {

			@Override
			public void onOpen(ServerHandshake handshakedata) {
				System.out.println(handshakedata.getHttpStatusMessage());
			}

			@Override
			public void onMessage(String message) {
				System.out.println(message);
			}

			@Override
			public void onError(Exception ex) {
			}

			@Override
			public void onClose(int code, String reason, boolean remote) {
			}
		};

		wc.connect();

		while (true) {
			BufferedReader strin=new BufferedReader(new InputStreamReader(System.in)); 
			String message="";
			
			try {
				 message = strin.readLine();  
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (message.equals("q")) {
				wc.close();
				break;
			}
			wc.send(message);
		}
	}
}