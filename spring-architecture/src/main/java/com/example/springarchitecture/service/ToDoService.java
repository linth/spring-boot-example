package com.example.springarchitecture.service;

import com.example.springarchitecture.Dao.ToDoDao;
import com.example.springarchitecture.Entity.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * Reference:
 *  - https://ithelp.ithome.com.tw/articles/10244715
 */
@Service
public class ToDoService {

    @Autowired
    ToDoDao toDoDao;

    public Iterable<ToDo> getTodos() {
        return toDoDao.findAll();
    }
}
