package com.example.springarchitecture.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration: 用來設定Spring環境配置，例如宣告及註冊bean至Spring容器中
 * 
 * Reference:
 *  - https://matthung0807.blogspot.com/2019/04/spring-configuration_28.html
 */

@Configuration
@ConfigurationProperties
public class config {
    @Value("${test.name}")
    String name;

    @Value("${test.age}")
    String age;
}
