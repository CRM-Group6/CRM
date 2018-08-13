package com.crm.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 10:58 2018/8/13
 * @Modify By:
 */
@Data
public class ShowList <T,E>{
    private E type;
    private List<T> data;
    public ShowList(E type,List<T> data){
        this.type = type;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ShowList{" +
                "region=" + type +
                "\n data" + data +
                '}';
    }
}
