package com.example.springarchitecture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 
 * Reference:
 *  - https://matthung0807.blogspot.com/2021/04/spring-mvc-requestparam-url.html
 *  - https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-mockmvc-integration-test-1.html
 *  - https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-mockmvc-integration-test-2.html
 *  - https://ithelp.ithome.com.tw/articles/10281055
 *  - https://matthung0807.blogspot.com/2021/01/spring-web-requestmapping-optional-pathvariable-api.html
 */
@AutoConfigureMockMvc
@SpringBootTest
public class RequestMappingExampleControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    // TODO: do more test.
}
