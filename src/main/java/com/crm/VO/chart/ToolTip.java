package com.crm.VO.chart;

import lombok.Data;

/**
 * @Author: Ben wu
 * @Description: 数据提示标签
 * @Date:Created in 11:02 2018/8/20
 * @Modify By:
 */
@Data
public class ToolTip {
    private String backgroundColor="#F9F9F9";     // 背景颜色: 默认白色'F9F9F9',
    private String borderColor="black";         // 边框颜色: 'black',
    private int borderRadius =10;           // 边框圆角: 10,
    private int borderWidth =1;            // 边框宽度: 1,
    private boolean shadow=true;             // 是否显示阴影: true,
    private boolean animation=true;          // 是否启用动画效果: true
    private String valuePrefix;         // 前缀: '￥',
    private String valueSuffix;         // 后缀: '元'
    private boolean crosshairs;         // 启用准星线: true
    public ToolTip(){

    }
    public ToolTip(String valuePrefix, String valueSuffix) {
        this.valuePrefix = valuePrefix;
        this.valueSuffix = valueSuffix;
    }

    public ToolTip(String backgroundColor, String borderColor, int borderRadius, int borderWidth, boolean shadow, boolean animation, String valuePrefix, String valueSuffix, boolean crosshairs) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.borderRadius = borderRadius;
        this.borderWidth = borderWidth;
        this.shadow = shadow;
        this.animation = animation;
        this.valuePrefix = valuePrefix;
        this.valueSuffix = valueSuffix;
        this.crosshairs = crosshairs;
    }
}
