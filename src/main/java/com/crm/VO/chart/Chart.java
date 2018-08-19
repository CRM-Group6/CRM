package com.crm.VO.chart;

import lombok.Data;
import org.nustaq.serialization.annotations.Serialize;

import java.util.List;
@Serialize
@Data
public class Chart {
    String name;//曲线名称
    List<Double> data;//曲线数据
    String color;
    int lineWidth=2;

    public Chart() {
    }

    public Chart(String name, List<Double> data) {
        this.name = name;
        this.data = data;
        this.color = "#48a4ff";
    }
    public Chart(String name, List<Double> data,String color) {
        this.name = name;
        this.data = data;
        this.color = color;
    }
}

