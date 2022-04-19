package com.example.websocketmesagequeue;

import com.sun.security.auth.UserPrincipal;
import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserHandshakeHandler extends DefaultHandshakeHandler {
    
    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {

        log.info("call determineUser().");
        // 提供 UUID，每當要傳送 private message 時，需要使用 UUID。
        final String randomId = UUID.randomUUID()
            .toString();

        log.info("randomId: " + randomId);
        return new UserPrincipal(randomId);
    }
}
