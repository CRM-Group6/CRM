package com.crm.deeplearning.predict;

/**
 * Created by JackKo
 * 2018/8/19 18:41
 **/
import com.crm.VO.chart.Chart;
import com.crm.deeplearning.representation.SaleAmountDataSetIterator;
import com.crm.deeplearning.utils.PlotUtil;
import javafx.util.Pair;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.io.ClassPathResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class PredictionAPI {

    private static final Logger log = LoggerFactory.getLogger(SaleAmountPrediction.class);

    private static int exampleLength = 50;

    private static MultiLayerNetwork net;

    private static SaleAmountDataSetIterator iterator;

    private static List<Double> origin;

    public static List<Chart> predictionUI() throws IOException , InvalidKerasConfigurationException, UnsupportedKerasConfigurationException {
        String file = new ClassPathResource("SaleAmountData.csv").getFile().getAbsolutePath();
        int batchSize = 128; // mini-batch size
        double splitRatio = 0.9; // 90% for training, 10% for testing

        log.info("Create dataSet iterator...");

        iterator = new SaleAmountDataSetIterator(file,  batchSize, exampleLength, splitRatio);
        log.info("Load test dataset...");
        List<Pair<INDArray, INDArray>> test = iterator.getTestDataSet();

        origin = iterator.getOrigin();

        log.info("Load model...");
        net = org.deeplearning4j.nn.modelimport.keras.KerasModelImport.importKerasSequentialModelAndWeights
                        ("src/main/java/com/crm/deeplearning/model/model.json" ,
                                "src/main/java/com/crm/deeplearning/model/model.h5");

        log.info("Testing...");
        double max = iterator.getMaxArray();
        double min = iterator.getMinArray();
        List<Chart> result  = predictPriceOneAhead(net, test, max, min,origin);
        double predict = (net.rnnTimeStep(iterator.getTest50().getKey()).getDouble(exampleLength - 1) +1)* origin.get(origin.size()-exampleLength);
        System.err.println("最新预测销售额为 = " + changeData(predict));
        log.info("Done...");
        return result;
    }

    /** Predict one feature of a stock one-day ahead */
    private static List<Chart> predictPriceOneAhead (MultiLayerNetwork net, List<Pair<INDArray, INDArray>> testData, double max, double min,List<Double> origin) {
//        System.err.println("Inside predict function:"+testData.size());
        double[] predicts = new double[testData.size()];
        double[] actuals = new double[testData.size()];
        for (int i = 0; i < testData.size(); i++) {
            predicts[i] = (net.rnnTimeStep(testData.get(i).getKey()).getDouble(exampleLength - 1) +1)* origin.get(origin.size()-(exampleLength+(testData.size()-i)));
            actuals[i] = (testData.get(i).getValue().getDouble(0) +1)* origin.get(origin.size()-(exampleLength+(testData.size()-i)));
        }
        List<Double> predictionList = new ArrayList<>();
        List<Double> actualList = new ArrayList<>();
        for(int i =0 ; i < testData.size() ; i ++){
            predictionList.add(predicts[i]);
            actualList.add(actuals[i]);
        }
        Chart preChart = new Chart();
        Chart actChart = new Chart();
        preChart.setName("预测值");
        preChart.setData(predictionList);
        preChart.setColor("#FF0000");
        preChart.setLineWidth(1);
        actChart.setName("真实值");
        actChart.setData(actualList);
        actChart.setColor("#000080");
        actChart.setLineWidth(1);
        List<Chart> chartList  = new ArrayList<>() ;
        chartList.add(preChart);
        chartList.add(actChart);

//        log.info("Print out Predictions and Actual Values...");
//        log.info("Predict,Actual");
//        NumberFormat format = NumberFormat.getPercentInstance();
//        format.setMaximumFractionDigits(2);//设置保留几位小数
//        for (int i = 0; i < predicts.length; i++){
//            log.info(predicts[i] + "," + actuals[i]+" -- 偏移比率："+format.format(Math.abs((actuals[i]-predicts[i])/actuals[i])));
//        }
        log.info("Plot...");
//        PlotUtil.plot(predicts, actuals,"Sale Amount");
        return chartList;
    }

    private static  String changeData(Double data){
        BigDecimal predictResult = new BigDecimal(data);
        String res1 = predictResult.toPlainString();
        res1 = res1.substring(0,10);
        String res2 = res1.substring(0,2);
        String res = res1 + "￥  ≈ " +res2 + "亿元";
        return res;
    }

    public static String newestPredict(){
        double predict = (net.rnnTimeStep(iterator.getTest50().getKey()).getDouble(exampleLength - 1) +1)* origin.get(origin.size()-exampleLength);
        return changeData(predict);
    }
}
