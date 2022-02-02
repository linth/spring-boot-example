package com.nr.mongodbexample;

import com.nr.mongodbexample.entity.Student;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void add(Student student) {
        repository.save(student);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }
}
