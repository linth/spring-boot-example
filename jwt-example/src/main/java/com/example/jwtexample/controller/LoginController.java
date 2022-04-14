package com.example.jwtexample.controller;

import com.example.jwtexample.bean.ResponseBean;
import com.example.jwtexample.exception.UnauthorizedException;
import com.example.jwtexample.service.UserBean;
import com.example.jwtexample.service.UserService;
import com.example.jwtexample.util.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseBean login(@RequestParam("username") String username, @RequestParam("password") String password) {
        log.info("username: " + username);
        log.info("password: " + password);
        
        UserBean userBean = userService.getUser(username);
        
        if (userBean.getPassword().equals(password)) {
            return new ResponseBean(200, "Login success", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }
}
