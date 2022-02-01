package com.nr.mongodbexample.entity;

import org.springframework.data.annotation.TypeAlias;
// import org.springframework.data.mongodb.core.index.Indexed;

import com.nr.mongodbexample.entity.base.deviceType;
import com.nr.mongodbexample.entity.base.switchType;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@TypeAlias("student")
@Document(collection = "student")
@Data
public class Student {
    @MongoId
    private String id;
    // @Indexed
    private String name;
    private String email;
    private String sex;
    private Integer age;
    private deviceType deviceType;
    private switchType switchType;
// 
    // private deviceType d = deviceType.OFF;

    // public Student(String name) { //, deviceType deviceType
    //     this.name = name;
    //     // this.deviceType = deviceType.ON;
    // }

    // public Student(String name, String email, String sex) {
    //     this.name = name;
    //     this.email = email;
    //     this.sex = sex;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setSex(String sex) {
    //     this.sex = sex;
    // }
    
}
