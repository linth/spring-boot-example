package com.example.websocketmesagequeue;

import com.example.websocketmesagequeue.dto.ResponseMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * NotificationService
 * 主要是做notification service部分，實作部分也是利用SimpMessagingTemplate來處理。
 * 
 * Reference:
 *  - https://github.com/liliumbosniacum/websocket/blob/master/src/main/java/com/websocket/wstutorial/NotificationService.java
 */
@Service
@Slf4j
public class NotificationService {
    
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public NotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * 傳送 global notification.
     * 
     */
    public void sendGlobalNotification() {
        log.info("call sendGlobalNotification().");

        ResponseMessage message = new ResponseMessage("global notification");

        // 建立一個 /topic/global-notifications
        messagingTemplate.convertAndSend("topic/global-notifications", message);
    }

    /**
     * 傳送 private notification.
     * 
     * @param userId
     */
    public void sendPrivateNotification(final String userId) {
        log.info("call sendPrivateNotification().");
        log.info("user id: " + userId);

        
        ResponseMessage message = new ResponseMessage("private notification");

        // 建立一個 /topic/private-notifications
        messagingTemplate.convertAndSendToUser(userId, "/topic/private-notifications", message);
    }

    // TODO: 增加群播
}
