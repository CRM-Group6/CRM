package com.crm.deeplearning.utils;

/**
 * Created by JackKo
 * 2018/8/17 10:42
 **/

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class PlotUtil {

    public static void plot(double[] predicts, double[] actuals, String name) {
        double[] index = new double[predicts.length];
        for (int i = 0; i < predicts.length; i++)
            index[i] = i;
        Double min = minValue(predicts, actuals);
        Double max = maxValue(predicts, actuals);
        final XYSeriesCollection dataSet = new XYSeriesCollection();
        addSeries(dataSet, index, predicts, "Predicts");
        addSeries(dataSet, index, actuals, "Actuals");
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Prediction Result", // chart title
                "Index", // x axis label
                name, // y axis label
                dataSet, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );
        XYPlot xyPlot = chart.getXYPlot();
        // X-axis
        final NumberAxis domainAxis = (NumberAxis) xyPlot.getDomainAxis();
        domainAxis.setRange((int) index[0], (int) (index[index.length -1 ] + 2 ));
        domainAxis.setTickUnit(new NumberTickUnit(20));
        domainAxis.setVerticalTickLabels(true);
        // Y-axis
        final NumberAxis rangeAxis = (NumberAxis) xyPlot.getRangeAxis();
        rangeAxis.setRange(min, max);
//        System.err.println(min + "," + max);
        rangeAxis.setTickUnit(new NumberTickUnit(100));
        final ChartPanel panel = new ChartPanel(chart);
        final JFrame f = new JFrame();
        f.add(panel);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private static void addSeries (final XYSeriesCollection dataSet, double[] x, double[] y, final String label){
        final XYSeries s = new XYSeries(label);
        for( int j = 0; j < x.length; j++ ) s.add(x[j], y[j]);
        dataSet.addSeries(s);
    }

    private static Double minValue (double[] predicts, double[] actuals) {
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < predicts.length; i++) {
            if (min > predicts[i]) min = predicts[i];
            if (min > actuals[i]) min = actuals[i];
        }
        return min * 0.98;
    }

    private static Double maxValue (double[] predicts, double[] actuals) {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < predicts.length; i++) {
            if (max < predicts[i]) max = predicts[i];
            if (max < actuals[i]) max = actuals[i];
        }
        return max * 1.02;
    }

}