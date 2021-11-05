package com.example.springarchitecture.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 將配置組態模型，並將值注入模型中
 * 
 * Reference:
 *  - https://ithelp.ithome.com.tw/articles/10278638
 */
@Configuration
@ConfigurationProperties
@Data
public class TaskThreadPoolConfig {
    private int corePoolSize = 5;
    private int maxPoolSize = 50;
    private int keepAliveSeconds = 60;
    private int queueCapacity = 10000;
    private String threadNamePrefix = "Weisting-AsyncTask-";
}
