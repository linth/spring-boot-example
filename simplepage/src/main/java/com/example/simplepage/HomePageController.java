package com.example.simplepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    
    @GetMapping("home")
    public String home() {
        // 最基本的網頁範例
        return "home";
    }
}
