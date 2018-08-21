package com.crm.enums.customer_services;

import lombok.Getter;

@Getter
public enum  ExecutedStatus {
    EXCUTED(true,"已执行"),
    UNEXCUTED(false,"未执行"),
    ;
    private Boolean code;
    private String message;

    ExecutedStatus(Boolean code, String message) {
        this.code = code;
        this.message = message;
    }
}