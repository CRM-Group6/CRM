package com.crm.enums;

import lombok.Getter;

@Getter
public enum Department {
    SALES(1,"销售部门"), FINANCE(2,"财务部门"), CUSTOMER_SERVICE(3,"客服部门"),OPERATING(4,"业务部门");
    private int index;
    private String message;
    Department(int index,String message){
        this.index = index;
        this.message = message;
    }
}
