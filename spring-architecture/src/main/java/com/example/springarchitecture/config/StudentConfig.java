package com.example.springarchitecture.config;

import java.util.List;

import com.example.springarchitecture.entity.Student;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 使用 spring boot + yaml 結合 config 範例
 * 
 * Reference:
 *  - http://samchu.logdown.com/posts/290211-spring-boot-yaml-uses
 */
@Data
@Component
@ConfigurationProperties(prefix = "school")
public class StudentConfig {
    // private List<Student> student;
}
