package com.example.websocketmesagequeue;

import java.security.Principal;

import com.example.websocketmesagequeue.dto.Message;
import com.example.websocketmesagequeue.dto.ResponseMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * Websocket + message queue.
 * 
 * Reference:
 *  - (youtube) https://www.youtube.com/watch?v=XY5CUuE6VOk
 *  - (youtube) https://www.youtube.com/watch?v=dFwBJKwkxZE
 *  - (youtube) https://www.youtube.com/watch?v=LdQY-OUM2mk
 */
@Controller
public class MessageController {
    
    @Autowired
    private NotificationService notificationService;

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ResponseMessage getMessage(final Message message) throws InterruptedException {
        Thread.sleep(1000);
        notificationService.sendGlobalNotification();

        return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
    }

    @MessageMapping("/private-message")
    @SendToUser("/topic/private-message")
    public ResponseMessage getPrivateMessage(final Message message, final Principal principal) throws InterruptedException {
        Thread.sleep(1000);
        notificationService.sendPrivateNotification(principal.getName());

        return new ResponseMessage(
            HtmlUtils.htmlEscape("sending private message to user " + principal.getName() + ": " + message.getMessageContent())
        );
    }
}
