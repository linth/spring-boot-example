package com.example.springarchitecture.entity;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;


@TypeAlias("user")
@Document(collection = "user")
@Data
public class User {
    @MongoId
    private String id;
}
