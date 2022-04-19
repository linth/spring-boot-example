package com.example.websocketmesagequeue;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.example.websocketmesagequeue.dto.ResponseMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * WSService 主要實作 service 部分，呼叫函式會順便兩種 message 同時傳輸 (notification, message)。
 * 
 * Simple (or Streaming) Text Oriented Message Protocol (STOMP)
 * 
 */
@Service
@Slf4j
public class WSService {
    
    //! 似乎可以自訂義一些 message 來區別不同的訊息
    private SimpMessagingTemplate messagingTemplate;
    private NotificationService notificationService;

    @Autowired
    public WSService(SimpMessagingTemplate messagingTemplate, NotificationService notificationService) {
        this.messagingTemplate = messagingTemplate;
        this.notificationService = notificationService;
    }

    public void notifyFrontend(final  String message) {
        log.info("call notifyFrontend().");
        log.info("message: " + message);

        ResponseMessage response = new ResponseMessage(message);
        notificationService.sendGlobalNotification();

        messagingTemplate.convertAndSend("/topic/messages", response);
    }

    public void notifyUser(final String id, final String message) {
        log.info("call notifyUser().");
        log.info("id: " + id);
        log.info("message: " + message);

        ResponseMessage response = new ResponseMessage(message);
        notificationService.sendPrivateNotification(id); // notification.

        messagingTemplate.convertAndSendToUser(id, "/topic/private-message", response);
    }
}
