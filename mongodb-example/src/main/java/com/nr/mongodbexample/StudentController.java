package com.nr.mongodbexample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nr.mongodbexample.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("")
    public List<Student> findAll() {
        return repository.findAll();
        // return service.findAll().stream().collect(Collectors.toList());
    }

    /**
     * Paging and search.
     * 
     * TODO: sorting and ordering.
     * 
     * Reference:
     *  - https://matthung0807.blogspot.com/2019/12/spring-data-mongodb-page-query.html
     * 
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("search")
    public String search() throws JsonProcessingException { // @RequestBody Integer age
        int page = 0;
        int size = 3;
        int age = 38;

        PageRequest pageable = PageRequest.of(page, size, Sort.by("age").descending());
        Page<Student> res = repository.findByAge(age, pageable);

        System.out.println("res TotalPages: " + res.getTotalPages());
        System.out.println("res TottalElement: " + res.getNumberOfElements());
        System.out.println("res getSize: " + res.getSize());
        System.out.println("res getNumber: " + res.getNumber());
        System.out.println("res getNumberOfElements: " + res.getNumberOfElements());

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(res.getContent());
        System.out.println("jsonString: " + jsonString);
        return jsonString;
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