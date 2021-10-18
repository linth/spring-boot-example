package com.example.springarchitecture.controller;

import com.example.springarchitecture.config.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class test {

    @Autowired
    config config;

    @RequestMapping("show")
    public String show() {
        return "Hello world.";
    }
}
