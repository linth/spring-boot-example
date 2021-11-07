package com.example.springarchitecture.controller;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.springarchitecture.Entity.ToDo;
import com.example.springarchitecture.service.ToDoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 
 * Reference:
 *  - https://ithelp.ithome.com.tw/articles/10246525
 */
@SpringBootTest
@AutoConfigureMockMvc // 注入用MockMvc 模擬HTTP請求
@Sql(scripts = "classpath:test/data.sql") // sql 檔案放置地方
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // 類中別的每個測試方法之前清除緩存
public class ToDoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ToDoService toDoService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testGetTodos() throws Exception {
        // TODO: has NullPointerException error.
        // ! how to fix it?

        String strDate = "2020-09-20 19:00:00";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(strDate);

        List<ToDo> expectedList = new ArrayList<>();
        ToDo toDo = new ToDo();
        toDo.setId(1);
        toDo.setTask("洗衣服");
        toDo.setCreateTime(date);
        toDo.setUpdateTime(date);
        expectedList.add(toDo);

        String returnString = mockMvc.perform(MockMvcRequestBuilders.get("/todos/list")
            .accept(MediaType.APPLICATION_JSON ))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        Iterable<ToDo> actualList = objectMapper.readValue(returnString, new TypeReference<Iterable<ToDo>>() {});

        assertEquals(expectedList,  actualList);
    }
}
