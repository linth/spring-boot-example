package com.example.springarchitecture.service;

import com.example.springarchitecture.config.MongoDBConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MongoDBService {
    @Autowired
    private MongoDBConfig config;
    
    public String getHost() {
        log.info("into getHost(). host information: " + config.getHost());
        return config.getHost();        
    }

    public String getPort() {
        log.info("into getHost(). port information: " + config.getPort());
        return config.getPort();        
    }

    public String getDatabase() {
        log.info("into getHost(). database information: " + config.getDatabse());
        return config.getDatabse();        
    }

    public String getUsername() {
        log.info("into getHost(). username information: " + config.getUserName());
        return config.getUserName();        
    }

    public String getPassword() {
        log.info("into getHost(). password information: " + config.getPassWord());
        return config.getPassWord();        
    }
}
