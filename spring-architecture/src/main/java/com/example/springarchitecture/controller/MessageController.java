package com.example.springarchitecture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * References:
 *  - https://matthung0807.blogspot.com/2019/08/spring-boot-interceptor.html
 */
@RestController
@RequestMapping("message")
public class MessageController {

    @GetMapping()
    public String getMessage() {
        String message = "the system got the message.";
        return message;
    }
}
