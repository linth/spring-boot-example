package com.example.websocket_server.controller;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import com.example.websocket_server.util.WebSocketUtil;

/**
 * Websocket Server Example.
 * 
 * Reference:
 *  - https://morosedog.gitlab.io/springboot-20190416-springboot28/
 *  - https://www.yixuebiancheng.com/article/91076.html
 */
@Component
@ServerEndpoint(value = "/WebSocketServer/{user}")
public class WebSocketController {

    // TODO: WebSocketServer should be a chatroom name.

    private static int onlineCount = 0;

    /**
     * 建立websocket連線
     * 
     * @param user user name.
     * @param session session information.
     */
    @OnOpen
    public void onOpen(@PathParam(value = "user") String user, Session session) {
        String message = "New Member: [" + user + "] join the chatroom!";
        System.out.println(message);

        // add new session and send message to all members.
        WebSocketUtil.addSession(user, session);
        WebSocketUtil.sendMessageForAll(message);

        // add user count.
        addOnlineCount();
        System.out.println("online count: " + onlineCount);
    }

    /**
     * 關閉websocket連線
     * 
     * @param user user name.
     * @param session session information.
     */
    @OnClose
    public void onClose(@PathParam(value = "user") String user, Session session) {
        String message = "Member: [" + user + "] quit the chatroom!";
        System.out.println(message);

        // delete the session and send message to all members.
        WebSocketUtil.remoteSession(user);
        WebSocketUtil.sendMessageForAll(message);

        // user left
        subOnlineCount();
        System.out.println("online count: " + onlineCount);
    }

    /**
     * 傳送資訊
     * 
     * @param user user name.
     * @param message message information.
     */
    @OnMessage
    public void OnMessage(@PathParam(value = "user") String user, String message) {
        String info = "Member: [" + user + "]：" + message;
        System.out.println(info);

        // send message to all members.
        WebSocketUtil.sendMessageForAll(message);
    }

    /**
     * 錯誤資訊
     * 
     * @param session session information.
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("Error:" + throwable);
        try {
            session.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }

    private static synchronized void addOnlineCount() {
        WebSocketController.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketController.onlineCount--;
    }
}
