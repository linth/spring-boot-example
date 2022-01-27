package com.example.springarchitecture.exception;

/**
 * Error Exception:
 *  1) 建立新 custom exception, e.g., CustomException, TooSmallException, etc.
 *  2) 建立 customExceptionHandler 並增加 @ControllerAdvice.
 *  3) 在 controller 下，設定要處理的情況下throw exception。
 * 
 * TODO: 是否可用繼承方式來減少 custom exception 部分?
 */
public class BaseException extends RuntimeException {
    protected String msg;

    public BaseException(String msg) {
        this.msg = msg;
    }

    public BaseException() {
        
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }
}
