package com.crm.VO.chart;

import lombok.Data;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 14:50 2018/8/20
 * @Modify By:
 */
@Data
public class PieItem {
    private String name;
    private double y;

    public PieItem(String name, double y) {
        this.name = name;
        this.y = y;
    }

    public PieItem() {
    }
}
