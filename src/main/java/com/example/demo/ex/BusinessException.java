package com.example.demo.ex;

/**
 * Common business exception.
 *
 * @author Jarvis Song
 */
public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(int code) {
        this.code = code;
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public String getDefaultMessage() {
        return "A business exception occurred!";
    }

    public int getCode() {
        return this.code;
    }

}
