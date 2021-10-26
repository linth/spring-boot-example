package com.example.springarchitecture.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration: 用來設定Spring環境配置，例如宣告及註冊bean至Spring容器中
 * 
 * TODO: software version, i.e., v0.0.1. API version, auth, permission, sonarqube, ..., etc.
 * 
 * Reference:
 *  - https://matthung0807.blogspot.com/2019/04/spring-configuration_28.html
 *  - https://ithelp.ithome.com.tw/articles/10277666
 */

@Configuration
@ConfigurationProperties
public class config {
    @Value("${test.name}")
    String name;

    @Value("${test.age}")
    String age;

    public String getName() {
        return this.name;
    }

    public String getAge() {
        return this.age;
    }
}
