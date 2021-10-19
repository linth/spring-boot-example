package com.example.springarchitecture.exception;

/**
 * TODO: 多一些其他 exception example.
 */
public class CustomException extends RuntimeException {
    private String msg;

    public CustomException(String msg) {
        this.msg = msg;
    }

    public CustomException() {
        
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }
}
