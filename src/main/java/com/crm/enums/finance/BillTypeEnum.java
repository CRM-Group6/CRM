package com.crm.enums.finance;

import lombok.Getter;

@Getter
public enum BillTypeEnum {
    COLLECTION(0,"收款单"),
    PAY(1,"付款单"),
    ;
    private Integer code;
    private String message;

    BillTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
