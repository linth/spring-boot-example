package com.example.springarchitecture.entity;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@TypeAlias("teacher")
@Document(collection = "teacher")
@Data
public class Teacher {
    @MongoId
    private String id;
    private String sex;
}
