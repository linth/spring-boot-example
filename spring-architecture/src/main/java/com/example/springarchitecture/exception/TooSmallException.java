package com.example.springarchitecture.exception;

public class TooSmallException extends RuntimeException {
    private String msg;

    public TooSmallException(String msg) {
        this.msg = msg;
    }

    public TooSmallException() {
        
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

}
