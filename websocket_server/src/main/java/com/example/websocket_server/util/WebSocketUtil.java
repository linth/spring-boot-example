package com.example.websocket_server.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.Session;

public class WebSocketUtil {
    
    private static final Map<String, Session> ONLINE_SESSION = new ConcurrentHashMap<>();

    // 新增紀錄Session
    public static void addSession(String user, Session session) {
        ONLINE_SESSION.put(user, session);
    }

    // 移除Session
    public static void remoteSession(String user) {
        ONLINE_SESSION.remove(user);
    }

    // 發送訊息
    public static void sendMessage(Session session, String message) {
        if (session == null) {
            return;
        }
        Async async = session.getAsyncRemote();
        async.sendText(message);
    }

    // 發送群體訊息
    public static void sendMessageForAll(String message) {
        ONLINE_SESSION.forEach((sessionId, session) -> sendMessage(session, message));
    }
}
