package com.crm.enums;

import lombok.Getter;

/**
 * Created by JackKo
 * 2018/8/8 11:23
 **/
@Getter
public enum InfoType {
    TRAVEL(1,"商旅咨询"), BROADCAST(2,"通告"), BARGAIN(3,"特价信息");
    private int index;
    private String message;
    InfoType(int index,String message){
        this.index = index;
        this.message = message;
    }
}
