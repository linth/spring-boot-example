package com.example.springarchitecture.controller;

import com.example.springarchitecture.config.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * References:
 *  - https://ithelp.ithome.com.tw/articles/10277666
 */
@RestController
@RequestMapping("config")
public class ConfigInfoController {
    @Value("${software.version}")
    String version;

    @Value("${software.name}")
    String versionName;

    @Autowired
    private config config;

    @GetMapping
    public String getVersion() {
        return versionName + " " + version ;
    }

    @GetMapping("name")
    public String getName() {
        return config.getName();
    }

    @GetMapping("age")
    public String getAge() {
        return config.getAge();
    }
}
