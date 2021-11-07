package com.example.springarchitecture.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test for RequestParamExampleController範例
 * 
 * TODO: 增加 RequestParamExampleController 的 test.
 * TODO: 是否可以自己建立library框架?
 * 
 * Reference: 
 *  - https://matthung0807.blogspot.com/2021/04/spring-mvc-requestparam-url.html
 *  - https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-mockmvc-integration-test-1.html
 *  - https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-mockmvc-integration-test-2.html
 *  - https://ithelp.ithome.com.tw/articles/10281055
 *  - https://ithelp.ithome.com.tw/articles/10246525
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class RequestParamExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateProduct() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        JSONObject request = new JSONObject()
            .put("name", "Harry Potter")
            .put("price", 450);

        // post 方法代表發送 POST 請求，參數需傳入 API 路徑。
        // headers 方法可附加請求標頭。
        // content 方法可加入請求主體，此處傳入 JSON 字串作為參數。
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products")
            .headers(headers)
            .content(request.toString());

        // 發出請求與驗證
        mockMvc.perform(requestBuilder)
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").hasJsonPath())
            .andExpect(jsonPath("$.name").value(request.getString("name")))
            .andExpect(jsonPath("$.price").value(request.getInt("price")))
            .andExpect(header().exists(HttpHeaders.LOCATION))
            .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
    }
    
    public void api_ok() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/requestParam/api?name=george&age=22"))
                .andExpect(status().isOk())
                .andExpect(content().string("Name: george; Age: 22"));
    }

    // @Test
    // public void api_notFound() throws Exception {
    // mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/requestParam/api"))
    // .andExpect(MockMvcResultMatchers.status().isBadRequest());
    // }
}
