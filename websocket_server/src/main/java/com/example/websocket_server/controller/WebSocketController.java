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

@Component
@ServerEndpoint(value = "/WebSocketServer/{user}")
public class WebSocketController {

    @OnOpen
    public void onOpen(@PathParam(value = "user") String user, Session session) {
        String message = "有新成員[" + user + "]加入聊天室!";
        System.out.println(message);
        WebSocketUtil.addSession(user, session);
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnClose
    public void onClose(@PathParam(value = "user") String user, Session session) {
        String message = "成員[" + user + "]退出聊天室!";
        System.out.println(message);
        WebSocketUtil.remoteSession(user);
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnMessage
    public void OnMessage(@PathParam(value = "user") String user, String message) {
        String info = "成員[" + user + "]：" + message;
        System.out.println(info);
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("錯誤:" + throwable);
        try {
            session.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }
}
