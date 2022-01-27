package com.example.springarchitecture.entity;

import java.sql.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

/**
 * 定義資料對應的物件格式
 * Persistant Object (PO): 持久層物件 = Entity.
 * 
 * add mongodb example. (2022-01-17)
 * 
 * Reference:
 *  - https://www.uj5u.com/ruanti/282608.html
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

    private Integer age;
    private Date birDate;
    private String schoolName;
}
