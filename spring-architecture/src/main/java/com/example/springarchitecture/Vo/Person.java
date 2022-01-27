package com.example.springarchitecture.Vo;

import com.example.springarchitecture.Entity.Student;
import com.example.springarchitecture.Entity.Teacher;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

/**
 * VO（Value Object）：值物件
 *  - VO就是展示用的資料，不管展示方式是網頁，還是客戶端，還是App，只要這個東西是讓人看到的，就叫VO，VO主要的存在形式就是js中的物件（也可以簡單理解成json）
 * 
 * Reference:
 *  - https://www.uj5u.com/ruanti/282608.html
 * 
 */

@TypeAlias("person")
@Document(collection = "person")
@Data
public class Person {
    @MongoId
    private String id;

    private Student student;
    private Teacher teacher;
}
