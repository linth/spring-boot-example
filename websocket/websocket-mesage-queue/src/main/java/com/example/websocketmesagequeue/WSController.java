package com.example.websocketmesagequeue;

import com.example.websocketmesagequeue.dto.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WSController {
    
    @Autowired
    private WSService service;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody final Message message) {
        log.info("call sendMessage().");
        log.info("message: " + message.getMessageContent());

        // 呼叫此 service api 會傳送兩個 message.
        service.notifyFrontend(message.getMessageContent());
    }

    @PostMapping("/send-private-message/{id}")
    public void sendPrivateMessage(@PathVariable final String id, @RequestBody final Message message) {
        log.info("call sendPrivateMessage().");
        log.info("id: " + id);
        log.info("message: " + message.getMessageContent());

        // 呼叫此 service api 會傳送兩個 message.
        service.notifyUser(id, message.getMessageContent());
    }
}
