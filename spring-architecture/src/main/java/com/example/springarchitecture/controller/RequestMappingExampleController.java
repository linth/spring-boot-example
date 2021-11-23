package com.example.springarchitecture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ! 多種接受參數的方式
 *  - @PathVariable: 在url上當作參數引入
 *  - @RequestParam: 可以當表單參數引入
 *  - @RequestBody: 可以使用json來接受參數引入
 *  - @RequestHeader: 可以要求接口請求傳遞參數，如: token
 *  - @CookieValue: 接受cookie參數
 * 
 * Reference:
 *  - https://matthung0807.blogspot.com/2021/01/spring-web-requestmapping-optional-pathvariable-api.html
 *  - https://kknews.cc/zh-tw/code/66z9jgq.html
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

