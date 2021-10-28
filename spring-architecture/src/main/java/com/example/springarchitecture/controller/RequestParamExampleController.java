package com.example.springarchitecture.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RequestParam 取得url參數範例
 * 
 * Reference:
 *  - https://matthung0807.blogspot.com/2021/04/spring-mvc-requestparam-url.html
 */
@RestController
@RequestMapping("requestParam")
public class RequestParamExampleController {

    @GetMapping("/api")
    public String api(@RequestParam String name, @RequestParam String age) {
        // ? 請使用url: http://localhost:8080/requestParam?name=%22george%22&age=%2222%22
        System.out.println("name: " + name);
        System.out.println("age: " + age);

        return "Name: " + name + "; Age: " + age;
    }

    @GetMapping("/api2")
    public String api2(@RequestParam Map<String, String> args) {
        // ! RequestParam 使用 map方式
        // ? 請使用url: http://localhost:8080/requestParam/api2?name="george"&age="22"
        System.out.println("name: " + args.get("name"));
        System.out.println("age: " + args.get("age"));

        String result = String.format("name=%s, age=%s", args.get("name"), args.get("age"));
        return result;
    }

    @GetMapping("/api3")
    public String api3(@RequestParam List<String> name) {
        // ! RequestParam 使用 list方式
        // ? 請使用url: http://localhost:8080/requestParam/api3?name=john,mary,bill
        System.out.println("name: " + name);

        String result = String.format("name=%s", String.join(",", name));
        return result;
    }
}
