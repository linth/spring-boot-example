package com.example.springarchitecture.controller;

import com.example.springarchitecture.exception.CustomException;
import com.example.springarchitecture.exception.EqualToFive;
import com.example.springarchitecture.exception.LargerThanTen;
import com.example.springarchitecture.exception.TooSmallException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

/**
 * Error exception example.
 * 
 * References:
 *  - https://www.tpisoftware.com/tpu/articleDetails/1334
 *  - https://ithelp.ithome.com.tw/articles/10277161
 */
@RestController
@RequestMapping("/exception")
public class ExceptionExampleController {
    private 
    
    @RequestMapping("/custom")
    public void getCustomException() {
        // custom error exception.
        throw new CustomException("hi, this is a custom exception.");
    }

    @RequestMapping("/null")
    public void getNullPointerException() {
        // null pointer exception.
        throw new NullPointerException();
    }

    @RequestMapping("/tooSmall")
    public String tooSmallException(@RequestParam Integer num) {
        // * get a number then return exception: larger, equal, less.
        // example: http://localhost:8081/exception/tooSmall?num=5

        if (num > 10) {
            // return "good! the number is larger than 10.";
            throw new LargerThanTen("larger than 10.");
        } else if (num == 5) {
            throw new EqualToFive("equals to 5.");
        } else {
            throw new TooSmallException("less than 10.");
        }
    }

    @RequestMapping("/simple")
    public void simple() throws Exception {
        try {
            int ans = 1 / 0;
            System.out.println("ans: " + ans);
        } catch (CustomException e) {
            throw new CustomException();
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @RequestMapping("/simple2")
    public void simple2() throws Exception {
        try {
            int ans = 1 / 0;
            System.out.println("ans: " + ans);
        } catch (CustomException e) {
            throw new CustomException();
        } catch (Exception e) {
            throw new Exception("exception: " + e.toString());
        }
    }
}
