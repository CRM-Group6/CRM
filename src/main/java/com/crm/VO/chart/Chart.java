package com.crm.VO.chart;

import lombok.Data;
import org.nustaq.serialization.annotations.Serialize;

import java.util.List;
@Serialize
@Data
public class Chart {
    String name;//曲线名称
    List<Double> data;//曲线数据
    public Chart(String name, List<Double> data) {
        this.name = name;
        this.data = data;
    }
}

