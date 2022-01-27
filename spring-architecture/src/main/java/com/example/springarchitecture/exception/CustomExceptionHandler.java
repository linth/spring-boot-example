package com.example.springarchitecture.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
 *  - https://ithelp.ithome.com.tw/articles/10277161
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

    @ExceptionHandler(EqualToFive.class)
    public Object notFoundHandler(EqualToFive et) {
        String msg = et.getMessage();

        String message = "get error: EqualToFive: " + msg;
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(message);
    }

    @ExceptionHandler(LargerThanTen.class)
    public Object largerThanTenHandler(LargerThanTen ltt) {
        String msg = ltt.getMessage();

        String message = "[Error] LargerThanTen: " + msg;
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(message);
    }

    // TODO: 200, 201, 400, 403, 404, 500, ..., etc.
    // @ExceptionHandler(Exception.class)
    // public Object notFound(Exception e) {
    //     String msg = e.getMessage();
    // }
}
