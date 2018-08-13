package com.crm.enums.finance;

import lombok.Getter;

@Getter
public enum  BillStatusEnum {
    OPEN(false,"未结"),
    CLOSED(true,"已结"),
    ;
    private Boolean code;
    private String message;

    BillStatusEnum(Boolean code, String message) {
        this.code = code;
        this.message = message;
    }
}
