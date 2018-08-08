package com.crm.enums;

/**
 * Created by JackKo
 * 2018/8/8 11:23
 **/
public enum InfoType {
    TRAVEL(1), BROADCAST(2), BARGAIN(3);
    private int index;
    InfoType(int index){
        this.index = index;
    }
}
