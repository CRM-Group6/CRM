package com.crm.VO.chart;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;
import org.nustaq.serialization.annotations.Serialize;

import java.util.List;
@Serialize
@Data
public class Chart<T>{
    String type="line";//图类型：默认曲线
    String name;//曲线名称
    List<T> data;//曲线数据
    String color = null;
    int lineWidth=2;

    public Chart() {
    }

    public Chart(String name, List<T> data) {
        this.name = name;
        this.data = data;
    }
    public Chart(String name, List<T> data,String color,int lineWidth) {
        this.name = name;
        this.data = data;
        this.color = color;
        this.lineWidth = lineWidth;
    }
}

