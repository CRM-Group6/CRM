package com.crm.VO;

import lombok.Data;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 19:16 2018/8/16
 * @Modify By:
 */
@Data
public class ScatterData {
    private String name;
    private double y;

    public ScatterData(String name, double y) {
        this.name = name;
        this.y = y;
    }

    public ScatterData() {
    }
}
