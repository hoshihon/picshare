package com.github.hoshihon.picshare.service;

public class ResponseResult<T> {
    private LoginResult code;

    private String msg;

    private T Data;

    public ResponseResult(LoginResult code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        Data = data;
    }

    public ResponseResult(LoginResult code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public LoginResult getCode() {
        return code;
    }

    public void setCode(LoginResult code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
