package com.nr.mongodbexample;

import com.nr.mongodbexample.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import nr.mongodbexample.entity.Student;

@RestController("")
public class StudentController {
    @Autowired
    private StudentService service;

    @Autowired
    private StudentRepository repository;


    /**
     * CREATE student data.
     * @param student
     */
    @PostMapping("add")
    public void add(@RequestBody Student student) {
        service.add(student);
        // repository.save(student);
    }
    
    @RequestMapping("hello")
    public String hello() {
        return "Hello";
    }
}


// JSON data.
// url: http://localhost:8080/add

// {
//     "name": "haha",
//     "email": "haha@gmail.com",
//     "sex": "boy",
//     "age": 33,
//     "switchType": "ON",
//     "deviceType": "OFF"
// }