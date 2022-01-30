package com.example.springarchitecture.service;

import com.example.springarchitecture.entity.Student;
import com.example.springarchitecture.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {
    // 使用 repository 來存取資料
    @Autowired
    private StudentRepository repository;

    public void createStudentByRepository(Student student) {
        // log.info("call createStudentByRepository().");
        repository.save(student);
        // log.info("finish createStudentByRepository().");
    }

    // 使用 MongoTemplate 來存取資料
    @Autowired
    private MongoTemplate mongoTemplate;

    public void createStudentByMongoTemplate(Student student) {
        // log.info("call createStudentByMongoTemplate().");
        mongoTemplate.save(student);
        // log.info("finish createStudentByMongoTemplate().");
    }
}
