package com.example.springarchitecture.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * References:
 *  - https://chikuwa-tech-study.blogspot.com/2021/07/spring-boot-mockito-unit-test.html
 */
@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    
}
