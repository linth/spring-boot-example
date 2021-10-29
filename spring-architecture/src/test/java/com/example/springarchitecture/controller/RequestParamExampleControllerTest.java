package com.example.springarchitecture.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Test for RequestParamExampleController範例
 * 
 * TODO: 增加 RequestParamExampleController 的 test.
 * 
 * Reference: -
 * https://matthung0807.blogspot.com/2021/04/spring-mvc-requestparam-url.html
 */
@AutoConfigureMockMvc
@SpringBootTest
public class RequestParamExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void api_ok() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/requestParam/api?name=george&age=22"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Name: george; Age: 22"));
    }

    // @Test
    // public void api_notFound() throws Exception {
    // mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/requestParam/api"))
    // .andExpect(MockMvcResultMatchers.status().isBadRequest());
    // }
}
