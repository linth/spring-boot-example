package com.example.jacksonexample.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.jacksonexample.entity.Person;
import com.example.jacksonexample.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * java object <-> json by using ObjectMapper.
 * 
 * Reference
 *  - https://kucw.github.io/blog/2020/6/java-jackson/
 *  - https://juejin.cn/post/6942727328682213389
 */
@RestController
public class Jackson {

    @GetMapping("jackson")
    public void jacksonExample() {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"createTime\":1621341922450,\"id\":1,\"name\":\"DT\"}";

        Person p = new Person("2", "george", "1621341922450");
        
        try {
            Person person = objectMapper.readValue(json, Person.class);
            System.out.println("java对象->>>"+person);
            System.out.println("person: " + person.getId() + "; name: " + person.getName());

            System.out.println(p);

        } catch (Exception e) {
            System.out.println("[error] " + e.toString());
        }
    }

    // object to json
    @GetMapping("o2j")
    public String o2j() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User(1, "John");
        String json = objectMapper.writeValueAsString(user);

        System.out.println("json: " + json);
        // System.out.println(json.split(",")[0]);
        return json;
    }

    // json to object
    @GetMapping("j2o")
    public void j2o() throws Exception {
        String json = o2j();
        ObjectMapper objectMapper = new ObjectMapper();

        User user = objectMapper.readValue(json, User.class);
        System.out.println("user: " + user);
    }

    // list<User> to json
    @GetMapping("list")
    public String list() throws Exception {
        List<User> uList = new ArrayList<>();
        User user1 = new User(1, "Hi");
        User user2 = new User(2, "GG");
        User user3 = new User(3, "HaHa");

        uList.add(user1);
        uList.add(user2);
        uList.add(user3);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(uList);
    }

    // json to List<User>
    @GetMapping("json2list")
    public void json2list() throws Exception {
        String json = list();

        ObjectMapper objectMapper = new ObjectMapper();
        User[] urlist = objectMapper.readValue(json, User[].class);
        List<User> u = Arrays.asList(objectMapper.readValue(json, User[].class));
        u.forEach(s -> {
            System.out.println(s);
        });
    }

    // map to json.

    // json to map.
}
