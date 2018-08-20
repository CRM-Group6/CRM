package com.crm.VO.chart;

import lombok.Data;

import java.util.List;
@Data
public class ChartVO {
    private Axis axis;//横坐标对象
    List<Chart> charts;// 曲线对象
}
