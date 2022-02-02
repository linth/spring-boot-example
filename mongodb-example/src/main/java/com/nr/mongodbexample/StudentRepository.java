package com.nr.mongodbexample;

import com.nr.mongodbexample.entity.Student;
import java.util.Optional;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    // public List<Student> findAll();
    public Optional<Student> findByName(String name);
    public List<Student> findByEmail(String email);

    public Page<Student> findByAge(int age, Pageable pageable);
}

