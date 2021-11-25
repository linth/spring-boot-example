package com.example.springarchitecture.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 使用 spring boot + yaml 結合 config 範例
 * 
 * Reference:
 *  - http://samchu.logdown.com/posts/290211-spring-boot-yaml-uses
 */
@ConfigurationProperties
@Component
@Data
public class PhoneConfig {
    private List<String> phoneClassArray;
}
