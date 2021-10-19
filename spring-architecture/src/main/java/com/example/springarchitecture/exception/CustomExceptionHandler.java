package com.example.springarchitecture.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 宣告一個 error exception handler，並定義自己的error exception.
 * 
 * ! 統一處理回饋的資訊整理，可以防止真正的 error 資訊外洩給使用者。
 * 
 * ! 讓例外的處理整個抽離，不會讓例外處理與邏輯混在一起。
 * 
 * Reference:
 *  - https://www.tpisoftware.com/tpu/articleDetails/1334
 */
@ControllerAdvice
public class CustomExceptionHandler {
    
    /**
     * 定義 error exception 並 return ResponseEntity<?> 和 httpstatus.
     */
    @ExceptionHandler(CustomException.class)
    public Object customHandler(CustomException e) {
        String msg = e.getMessage();

        String message = "get error: CustomException: 你猜猜是什麼錯誤? \n" + "ans: " + msg;
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(message);
    }

    @ExceptionHandler(TooSmallException.class)
    public Object tooSmallHandler(TooSmallException te) {
        String msg = te.getMessage();

        String message = "get error: TooSmallException: " + msg;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(message);
    }
}
