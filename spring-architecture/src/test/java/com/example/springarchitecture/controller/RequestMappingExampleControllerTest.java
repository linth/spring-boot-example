package com.example.springarchitecture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 測試CRUD RESTful整個過程是否有如預期一樣運作，Java 提供了一個In-memory的測試資料庫H2
 * ，若我們今天是介接MySQL這樣要執行整合測試就顯得困難許多，
 * 必須安裝並運行MySQL保持連接且要設置正確得用戶與資料庫 。
 * H2 Database就是一個很好的測試工具，由於資料是內存，測試程序結束後資料會不留痕跡地被刪除，
 * 以完全獨立的方式運行。
 * 
 * 
 * 
 * Reference:
 *  - https://matthung0807.blogspot.com/2021/04/spring-mvc-requestparam-url.html
 *  - https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-mockmvc-integration-test-1.html
 *  - https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-mockmvc-integration-test-2.html
 *  - https://ithelp.ithome.com.tw/articles/10281055
 *  - https://matthung0807.blogspot.com/2021/01/spring-web-requestmapping-optional-pathvariable-api.html
 *  - https://ithelp.ithome.com.tw/articles/10246525
 */
@AutoConfigureMockMvc
@SpringBootTest
public class RequestMappingExampleControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    // TODO: do more test.
}
