package com.crm.VO;

import lombok.Data;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 11:51 2018/8/21
 * @Modify By:
 */
@Data
public class ShowRegionSum {
    private String province,city,area;
    private long num;
    public ShowRegionSum(String province, String city, String area, long num) {
        this.province = province;
        this.city = city;
        this.area = area;
        this.num = num;
    }
    public String getLocation(){
        return province+" "+city+" "+area;
    }
}
