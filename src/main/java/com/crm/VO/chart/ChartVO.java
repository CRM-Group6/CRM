package com.crm.VO.chart;

import lombok.Data;

import java.util.List;
@Data
public class ChartVO<T> {
    private Title title;
    private Axis axis;//横坐标对象
    private Axis yAxis;//纵轴对象
    List<T> charts;// 曲线对象
    private ToolTip toolTip;
    public ChartVO(List<T> lines,String xTitle,String yTitle,List<String> xItems,String title){
        charts=lines;
        axis = new Axis();
        axis.setTitle(new Title(xTitle));
        axis.setCategories(xItems);
        yAxis = new Axis();
        yAxis.setTitle(new Title(yTitle));
        this.title = new Title(title);
        this.setToolTip(new ToolTip());
    }
    public ChartVO(){}
}
