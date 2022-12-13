package com.github.hoshihon.picshare.service;

import org.springframework.http.HttpStatus;

public enum LoginResult {
    SUCCESS(HttpStatus.OK, "login success"),
    ACCOUNT_DISABLE(HttpStatus.BAD_REQUEST, "account disable"),
    WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "wrong password"),
    ACCOUNT_LOCKED(HttpStatus.BAD_REQUEST, ""),
    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND,"account not found");

    private final HttpStatus status;


    private final String desc;

    LoginResult(HttpStatus status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

}
