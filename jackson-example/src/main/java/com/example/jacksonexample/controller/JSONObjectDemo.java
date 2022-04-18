package com.example.jacksonexample.controller;

import net.sf.json.JSONObject;

import com.google.gson.JsonObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONObjectDemo {
    
    @GetMapping("simple")
    public void simple() {
        // JSONObject jsonObject = new JSONObject();
        JsonObject jsonObject = new JsonObject();
        // jsonObject.addProperty(property, value);
        jsonObject.addProperty("name", "george");
        jsonObject.addProperty("sex", "boy");

        System.out.println("json: " + jsonObject);
    }

}
