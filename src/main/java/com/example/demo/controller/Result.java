package com.example.demo.controller;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Rest controller result wrapper.
 *
 * @param <T> fill data type
 * @author Jarvis Song
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> extends LinkedHashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 8632514164317028380L;

    /**
     * Static result for true.
     */
    public static final Result<Boolean> TRUE = success(true);

    private static final String KEY_SUCCESS = "success";

    private static final String KEY_CODE = "code";

    private static final String KEY_MESSAGE = "msg";

    private static final String KEY_DATA = "data";

    private static final String KEY_STATUS = "status";

    private static final String KEY_FIELDS = "fields";

    private static final int CODE_SUCCESS = 200;

    private static final int CODE_ERROR = 500;

    public Result(boolean success, int code, T data) {
        this.setSuccess(success).setCode(code).setData(data);
    }

    public static <T> Result<T> success(T data) {
        return success(CODE_SUCCESS, data);
    }

    public static <T> Result<T> success(int code, T data) {
        return new Result<>(true, code, data);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<T>(false, code, null).setMsg(message);

    }

    public static <T> Result<T> fail(int code, String message, T data) {
        return new Result<>(false, code, data).setMsg(message);

    }

    public static <T> Result<T> fail(String message) {
        return fail(CODE_ERROR, message);
    }

    public boolean isSuccess() {
        return (boolean) this.get(KEY_SUCCESS);
    }

    public Result<T> setSuccess(boolean success) {
        return this.set(KEY_SUCCESS, success);
    }

    public int getCode() {
        return (int) this.get(KEY_CODE);
    }

    public Result<T> setCode(int code) {
        this.set(KEY_STATUS, code >= 200 && code < 300 ? 0 : code);
        return this.set(KEY_CODE, code);
    }

    public String getMsg() {
        return (String) this.get(KEY_MESSAGE);
    }

    public Result<T> setMsg(String message) {
        return this.set(KEY_MESSAGE, message);
    }

    public int getStatus() {
        return (int) this.get(KEY_STATUS);

    }

    public Result<T> setFields(Map<String, String[]> fields) {
        return this.set(KEY_FIELDS, fields);
    }

    @SuppressWarnings({"unchecked"})
    public Map<String, String[]> getFields() {
        return (Map<String, String[]>) this.get(KEY_FIELDS);
    }

    @SuppressWarnings({"unchecked"})
    public T getData() {
        return (T) this.get(KEY_DATA);
    }

    public Result<T> setData(T data) {
        return this.set(KEY_DATA, data);
    }

    public Result<T> set(String key, Object value) {
        this.put(key, value);
        return this;
    }

    public Result<T> setMap(Map<String, ?> map) {
        this.putAll(map);
        return this;
    }

    @Override
    public String toString() {
        return "{\"success\": " + this.isSuccess() + ",\"code\": " + this.getCode() + ",\"status\": " + this.getStatus()
                + ",\"message\": \"" + this.getMsg() + "\",\"data\": " + this.getData() + "}";
    }

}
