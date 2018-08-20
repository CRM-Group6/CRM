package com.crm.VO.chart;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 15:52 2018/8/20
 * @Modify By:
 */
@Data
public class Pie<T> {
    String type="pie";//图类型：默认曲线
    String name;//曲线名称
    List<T> data;//曲线数据
    public Pie(String name, List<T> data) {
        this.name = name;
        this.data = data;
    }
}
