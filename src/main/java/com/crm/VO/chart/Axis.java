package com.crm.VO.chart;

import lombok.Data;

import java.util.List;
@Data
public class Axis {
    private List<String> categories;//横坐标的值
    private Title title;
}
