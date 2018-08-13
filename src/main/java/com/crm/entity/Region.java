package com.crm.entity;

import lombok.Data;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 11:25 2018/8/13
 * @Modify By:
 */
@Data
public class Region {
    private String province;
    private String city;
    private String area;
    public Region(String province,String city,String area){
        this.province = province;
        this.city = city;
        this.area = area;
    }
    @Override
    public String toString() {
        return "Region{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
