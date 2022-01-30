package com.example.springarchitecture.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 
 * Reference:
 *  - https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-application-properties-configuration.html
 *  - https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-construct-bean-programmatically.html
 */
@Configuration
// @Data
public class MongoDBConfig {
    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Value("${spring.data.mongodb.database}")
    private String databse;

    @Value("${spring.data.mongodb.username}")
    private String userName;

    @Value("${spring.data.mongodb.password}")
    private String passWord;

    // ! TODO: 沒有正確抓到setHost()，請確認如何使用 lombok.Data 正確引入

    // * 使用自訂義寫 get, set 可以 work.
    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDatabse() {
        return databse;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
