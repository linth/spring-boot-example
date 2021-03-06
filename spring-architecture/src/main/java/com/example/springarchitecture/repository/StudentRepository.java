package com.example.springarchitecture.repository;

import com.example.springarchitecture.entity.Student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    // public Student findByName(String name);
}
