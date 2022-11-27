package com.github.hoshihon.picshare.controller.support;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public class ApiResult<T> {

    private final Integer code;

    private final String message;

    private final T data;

    private ApiResult(Integer code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> ApiResult<T> success() {
        return result(OK);
    }

    public static <T> ApiResult<T> success(T payload) {
        return result(OK, OK.getReasonPhrase(), payload);
    }

    public static <T> ApiResult<T> success(String msg, T payload) {
        return result(OK, msg, payload);
    }

    public static <T> ApiResult<T> failed() {
        return result(BAD_REQUEST);
    }

    public static <T> ApiResult<T> failed(String msg) {
        return failed(BAD_REQUEST, msg, null);
    }

    public static <T> ApiResult<T> failed(HttpStatus status, String msg) {
        return failed(status, msg, null);
    }

    public static <T> ApiResult<T> failed(HttpStatus status, String msg, T payload) {
        return result(status, msg, payload);
    }

    public static <T> ApiResult<T> error() {
        return result(INTERNAL_SERVER_ERROR);
    }

    public static <T> ApiResult<T> error(String msg) {
        return result(INTERNAL_SERVER_ERROR, msg, null);
    }

    public static <T> ApiResult<T> error(HttpStatus status, String msg) {
        return result(status, msg, null);
    }

    public static <T> ApiResult<T> result(HttpStatus status) {
        return result(status, status.getReasonPhrase(), null);
    }

    private static <T> ApiResult<T> result(HttpStatus status, String msg, T payload) {
        return new ApiResult<>(status.value(), msg, payload);
    }

}
