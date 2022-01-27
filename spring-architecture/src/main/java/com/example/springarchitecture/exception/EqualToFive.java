package com.example.springarchitecture.exception;

public class EqualToFive extends RuntimeException {
    private String msg;

    public EqualToFive(String msg) {
        this.msg = msg;
    }

    public EqualToFive() {

    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }
}
