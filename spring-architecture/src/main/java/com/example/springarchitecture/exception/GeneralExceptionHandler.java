package com.example.springarchitecture.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 宣告一個 general error exception handler，處理一般常態的 error exception.
 * 
 * ! 讓例外的處理整個抽離，不會讓例外處理與邏輯混在一起。
 */
@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public Object nullPointer(NullPointerException e) {
        String message = "get null pointer: " + e;

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(message);
    }

    @ExceptionHandler(ArithmeticException.class)
    public Object arithmetic(ArithmeticException e) {
        String message = "get ArithmeticException: " + e;

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(message);
    }

    @ExceptionHandler(Exception.class)
    public Object exception(Exception e) {
        String message = "get Exception: " + e;
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(message);
    }
}
