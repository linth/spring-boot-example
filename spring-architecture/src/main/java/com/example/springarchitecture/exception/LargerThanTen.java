package com.example.springarchitecture.exception;

public class LargerThanTen extends RuntimeException {
    private String msg;

    public LargerThanTen(String msg) {
        this.msg = msg;
    }

    public LargerThanTen() {

    }

    @Override
    public String getMessage() {
        return this.msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }
}
