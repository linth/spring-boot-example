package com.example.springarchitecture.controller;

import com.example.springarchitecture.exception.CustomException;
import com.example.springarchitecture.exception.TooSmallException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String tooSmallException() {
        int num = 5;

        if (num > 10) {
            return "good! the number is larger than 10.";
        } else {
            throw new TooSmallException("the number is less than 10.");
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
