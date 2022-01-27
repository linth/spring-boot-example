package com.example.springarchitecture.controller;

import com.example.springarchitecture.service.MongoDBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Mongodb")
public class MongoDBController {
    @Autowired
    private MongoDBService service;
    
    @GetMapping("host")
    public String getHost() {
        return service.getHost();
    }

    @GetMapping("port")
    public String getPost() {
        return service.getPort();
    }

    @GetMapping("database")
    public String getDatabase() {
        return service.getDatabase();
    }

    @GetMapping("username")
    public String getUsername() {
        return service.getUsername();
    }

    @GetMapping("password")
    public String getPassword() {
        return service.getPassword();
    }
}
