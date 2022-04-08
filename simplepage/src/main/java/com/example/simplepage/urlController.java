package com.example.simplepage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 使用簡單的 Thymeleaf
 * 
 * Reference:
 *  - https://iter01.com/518210.html
 */
@Controller
public class urlController {
    
    @GetMapping("index")
    public String getindex(Model model) {

        // ! 丟資料到前端網頁需要使用 model 方式。
        model.addAttribute("name", "george");
        model.addAttribute("age", 30);

        return "index";
    }
}
