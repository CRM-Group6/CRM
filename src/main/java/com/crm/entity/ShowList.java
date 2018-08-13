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
    private String name;
    private List<T> data;
}
