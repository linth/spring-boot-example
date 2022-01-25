package com.example.springarchitecture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * create a new controller and call exteral API to do something.
 * 
 * Keywords:
 *  - RestTemplate
 * 
 * Reference:
 *  - https://www.geeksforgeeks.org/how-to-call-or-consume-external-api-in-spring-boot/
 *  - https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/
 */
@RestController
@RequestMapping("callAnotherBackendApi")
public class CallAnotherBackendApi {
    
    @GetMapping("")
    public String callApi() {
        // after creating another backend api, and then test API to make sure it can work.
        String url  =  "http://localhost:8080/api/drone/getAll";
        RestTemplate restTemplate = new RestTemplate();
        String res = restTemplate.getForObject(url, String.class);
        return res;
    }
}
