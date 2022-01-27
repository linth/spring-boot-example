package com.example.springarchitecture.controller;

import java.util.List;

import com.example.springarchitecture.Entity.Student;
import com.example.springarchitecture.repository.StudentRepository;
import com.example.springarchitecture.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("student")
public class StudentController {
    // 使用 repository 來存取資料
    @Autowired
    private StudentRepository repository;
    
    @PostMapping("add")
    public void save(@RequestBody Student student) {
        repository.save(student);
    }

    @GetMapping("finalAll")
    public List<Student> getStudents() {
        return repository.findAll();
    }

    // 使用 MongoTemplate 來存取資料
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("addWithMongo")
    public void saveWithMongo(@RequestBody Student student) {
        mongoTemplate.save(student);
    }

    // 使用 service 來存取資料
    @Autowired
    private StudentService service;

    @PostMapping("addWithService")
    public void saveWithService(@RequestBody Student student) {
        // ! 透過 service 去自行決定要用那方式存取
        service.createStudentByMongoTemplate(student);
        // service.createStudentByRepository(student);
    }
}
