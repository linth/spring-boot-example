package com.example.springarchitecture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Reference:
 *  - https://matthung0807.blogspot.com/2021/01/spring-web-requestmapping-optional-pathvariable-api.html
 */
@RestController
public class RequestMappingExampleController {

    @RequestMapping(value = "api/{text}", method = RequestMethod.GET)
    public void api(@PathVariable("text") String text) {
        System.out.println(text);
    }

    @RequestMapping(value = {"/api2", "/api2/{arg1}/{arg2}"}, method = RequestMethod.GET)
    public String api2(
        @PathVariable(value = "arg1", required = false) String arg1, 
        @PathVariable(value = "arg2", required = false) String arg2) {
            // ! 只有全不填或全填
            if (arg1 == null) {
                arg1 = "";
            }

            if (arg2 == null) {
                arg2 = "";
            }

            return arg1 + arg2;
    }
}

