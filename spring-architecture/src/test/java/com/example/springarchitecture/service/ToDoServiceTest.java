package com.example.springarchitecture.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.example.springarchitecture.Dao.ToDoDao;
import com.example.springarchitecture.Entity.ToDo;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * 
 * Reference:
 *  - https://ithelp.ithome.com.tw/articles/10245255
 */
@SpringBootTest
public class ToDoServiceTest {
    @Autowired
    ToDoService service;

    @MockBean
    ToDoDao toDoDao;

    @Test
    public void getToDosTest() {
        // 預期資料
        List<ToDo> exceptedToDoList = new ArrayList<>();
        ToDo toDo = new ToDo();
        toDo.setId(1);
        toDo.setTask("洗衣服");
        toDo.setStatus(1);
        exceptedToDoList.add(toDo);

        // 定義模擬呼叫todoDao.findAll() 要回傳的預設結果
        Mockito.when(toDoDao.findAll())
            .thenReturn(exceptedToDoList);

        // 操作todoService.getTodos()
        Iterable<ToDo> actualToDoList = service.getTodos();

        // 預期與實際的資料
        assertEquals(exceptedToDoList, actualToDoList);
    }
}