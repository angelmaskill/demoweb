package com.websocketpri.demo2;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class ScanWebSocketSeverConfig implements ServerApplicationConfig {

	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> scanned) {

		Set<ServerEndpointConfig> result = new HashSet<ServerEndpointConfig>();
		/*
		 * if (scanned.contains(EchoWsChatSever.class)) {
		 * result.add(ServerEndpointConfig.Builder.create(EchoWsChatSever.class,
		 * "/echo").build()); }
		 */
		return result;
	}

	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
		Set<Class<?>> results = new HashSet<Class<?>>();
		for (Class<?> clazz : scanned) {
			if (clazz.getPackage().getName().startsWith("com.websocketpri.")) {
				System.out.println("find end point : " + clazz.getName());
				results.add(clazz);
			}
		}
		return results;
	}
}