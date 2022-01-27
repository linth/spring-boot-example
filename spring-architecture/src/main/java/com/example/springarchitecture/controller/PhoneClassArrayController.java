package com.example.springarchitecture.controller;

import com.example.springarchitecture.config.PhoneConfig;
import com.example.springarchitecture.config.StudentConfig;
import com.example.springarchitecture.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Phone 和 Student 的設定範例
 * 
 * Reference:
 *  - http://samchu.logdown.com/posts/290211-spring-boot-yaml-uses
 */
@RestController
@RequestMapping("/")
public class PhoneClassArrayController {
    @Autowired
    private PhoneConfig phoneConfig;

    @Autowired
    private StudentConfig studentConfig;

    @RequestMapping("phoneList")
    public List<String> show() {
        return phoneConfig.getPhoneClassArray();
    }

    // @RequestMapping("studentList")
    // public List<Student> showStudent() {
    //     return studentConfig.getStudent();
    // }
}
