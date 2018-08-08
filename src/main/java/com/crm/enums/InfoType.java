package com.crm.enums;

/**
 * Created by JackKo
 * 2018/8/8 11:23
 **/
public enum InfoType {
    TRAVEL(1,"商旅咨询"), BROADCAST(2,"通告"), BARGAIN(3,"特价信息");
    private int code;
    private String message;
    InfoType(int code,String message){
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
