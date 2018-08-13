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
public class ShowList <T>{
    private Region region;
    private List<T> data;
    public ShowList(Region region,List<T> data){
        this.region = region;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ShowList{" +
                "region=" + region +
                '}';
    }
}
