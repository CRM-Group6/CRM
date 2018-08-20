package com.crm.VO.chart;

import com.crm.VO.ScatterData;
import lombok.Data;

import java.util.List;

/**
 * Created by JackKo
 * 2018/8/20 17:21
 **/
@Data
public class Histogram {
    String name;//曲线名称
    List<ScatterData> data;//曲线数据

    public Histogram(String name, List<ScatterData> data) {
        this.name = name;
        this.data = data;
    }
}
