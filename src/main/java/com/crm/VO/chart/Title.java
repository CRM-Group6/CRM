package com.crm.VO.chart;

import lombok.Data;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 10:30 2018/8/20
 * @Modify By:
 */
@Data
public class Title {
    private String text;
    public Title(String title){
        this.text=title;
    }
}
