package com.example.springarchitecture.Entity;

import com.example.springarchitecture.Entity.base.EntityBase;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;


@TypeAlias("user")
@Document(collection = "user")
@Data
public class User extends EntityBase {
    @MongoId
    private String id;
}
