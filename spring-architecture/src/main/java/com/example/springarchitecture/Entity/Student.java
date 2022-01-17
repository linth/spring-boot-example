package com.example.springarchitecture.Entity;

import java.sql.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

/**
 * 定義資料對應的物件格式
 * 
 * add mongodb example. (2022-01-17)
 * 
 * Reference:
 *  - 
 * 
 * TODO: schema function, e.g., not null, not empty, ..., and so on.
 * TODO: add the different types: Date, ..., etc.
 */
@TypeAlias("student")
@Document(collection = "student")
@Data
public class Student {
    @MongoId
    private String id;
    @Indexed
    private String name;
    private int age;

    private Date birDate;
}
