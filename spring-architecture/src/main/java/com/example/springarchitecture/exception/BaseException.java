package com.example.springarchitecture.exception;

/**
 * TODO: 是否可用繼承方式來減少 custom exception 部分?
 */
public class BaseException extends RuntimeException {
    protected String msg;

    public BaseException(String msg) {
        this.msg = msg;
    }

    public BaseException() {
        
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }
}
