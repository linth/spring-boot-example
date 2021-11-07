package com.example.springarchitecture.controller;

import com.example.springarchitecture.Entity.ToDo;
import com.example.springarchitecture.service.ToDoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Reference:
 *  - https://ithelp.ithome.com.tw/articles/10244715
 */
@RestController
@RequestMapping("todos")
public class ToDoController {
    @Autowired
    ToDoService service;

    @GetMapping("/list")
    public ResponseEntity<?> getToDos() {
        Iterable<ToDo> todoList = service.getTodos();
        return ResponseEntity.status(HttpStatus.OK)
            .body(todoList);
    }
}
