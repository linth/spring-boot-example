package com.example.springarchitecture.Entity;

import com.example.springarchitecture.Entity.base.EntityBase;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@TypeAlias("teacher")
@Document(collection = "teacher")
@Data
public class Teacher extends EntityBase {
    @MongoId
    private String id;
    private String sex;
}
